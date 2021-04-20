package com.jiming.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DailyApplication {

    public static void main(String[] args) {
        System.out.println("〓〓〓〓〓〓〓〓〓〓 DailyApplication star 〓〓〓〓〓〓〓〓〓〓");
        SpringApplication.run(DailyApplication.class, args);
        System.out.println("〓〓〓〓〓〓〓〓〓〓 DailyApplication success 〓〓〓〓〓〓〓〓〓〓");
    }

}
