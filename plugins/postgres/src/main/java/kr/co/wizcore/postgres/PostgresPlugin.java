package kr.co.wizcore.postgres;

import kr.co.wzicore.api.Greeting;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostgresPlugin extends SpringPlugin {


    public PostgresPlugin(PluginWrapper wrapper) {
        super(wrapper);

    }

    @Override
    public void start() {
        System.out.println("Postgres-Plugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("Postgres-Plugin.stop()");
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(SpringConfiguration.class);
        applicationContext.refresh();
        return applicationContext;
    }

    @Extension(
            ordinal = 1
    )
    public static class T1 implements Greeting {

        private final MessageProvider messageProvider;

        @Autowired
        public T1(final MessageProvider messageProvider) {
            this.messageProvider = messageProvider;
        }

        public String getGreeting() {
            return messageProvider.getMessage();
        }
    }


}
