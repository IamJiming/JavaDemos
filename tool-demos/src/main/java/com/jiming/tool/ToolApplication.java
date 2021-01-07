package com.jiming.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToolApplication {

    public static void main(String[] args) {
        System.out.println("〓〓〓〓〓〓〓〓〓〓 ToolApplication star 〓〓〓〓〓〓〓〓〓〓");
        SpringApplication.run(ToolApplication.class, args);
        System.out.println("〓〓〓〓〓〓〓〓〓〓 ToolApplication success 〓〓〓〓〓〓〓〓〓〓");
    }

}
