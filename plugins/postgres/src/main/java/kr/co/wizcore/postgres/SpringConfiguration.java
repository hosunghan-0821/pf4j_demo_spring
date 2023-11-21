package kr.co.wizcore.postgres;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public MessageProvider messageProvider(){
        return  new HelloMessageProvider();
    }
}
