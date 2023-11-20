package kr.co.wizcore.postgres;

import org.pf4j.Extension;

@Extension
public class HelloGreeting implements kr.co.wzicore.api.Greeting {

    public HelloGreeting() {
    }

    @Override
    public String getGreeting() {
        return "TEST";
    }
}
