package kr.co.wizcore.demo;

import kr.co.wzicore.api.Greeting;
import org.pf4j.Extension;

@Extension
public class TestGreeting  implements Greeting {
    @Override
    public String getGreeting() {
        return "hho";
    }
}
