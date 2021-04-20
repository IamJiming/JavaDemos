package com.jiming;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
@EnableConfigurationProperties(StarterProperties.class)
public class HelloAutoConfiguration {

    @Bean
    @ConditionalOnBean
    public IHelloStarter hello(){
        return new HelloStarterImpl();
    }
}
