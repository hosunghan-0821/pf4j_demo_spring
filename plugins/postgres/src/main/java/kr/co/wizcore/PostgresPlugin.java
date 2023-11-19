package kr.co.wizcore;

import kr.co.wzicore.api.Greeting;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class PostgresPlugin extends Plugin {


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

    @Extension(ordinal = 1)
    public static class HelloGreeting implements Greeting{

        @Override
        public String getGreeting() {
            return "Postgres";
        }
    }
}
