package com.jiming.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyApplication {

    public static void main(String[] args) {
        System.out.println("〓〓〓〓〓〓〓〓〓〓 DailyApplication star 〓〓〓〓〓〓〓〓〓〓");
        SpringApplication.run(DailyApplication.class, args);
        System.out.println("〓〓〓〓〓〓〓〓〓〓 DailyApplication success 〓〓〓〓〓〓〓〓〓〓");
    }

}
