package kr.co.wizcore.demo;

import kr.co.wzicore.api.Greeting;
import org.pf4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        final PluginManager pluginManager = new DefaultPluginManager(){
            @Override
            protected CompoundPluginDescriptorFinder createPluginDescriptorFinder() {
                return new CompoundPluginDescriptorFinder()
                        // Demo is using the Manifest file
                        // PropertiesPluginDescriptorFinder is commented out just to avoid error log
                        //.add(new PropertiesPluginDescriptorFinder())
                        .add(new ManifestPluginDescriptorFinder());
            }
        };

        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        logger.info("Plugindirectory: ");
        logger.info("\t" + System.getProperty("pf4j.pluginsDir", "plugins") + "\n");

        List<Greeting> greetings = pluginManager.getExtensions(Greeting.class);
        logger.info(String.format("Found %d extensions for extension point '%s'", greetings.size(), Greeting.class.getName()));
        for (Greeting greeting : greetings) {
            logger.info(">>> " + greeting.getGreeting());
        }

        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        for (PluginWrapper plugin : startedPlugins) {
            String pluginId = plugin.getDescriptor().getPluginId();
            logger.info(String.format("Extensions added by plugin '%s':", pluginId));
        }

        // stop the plugins
        pluginManager.stopPlugins();

    }
}
