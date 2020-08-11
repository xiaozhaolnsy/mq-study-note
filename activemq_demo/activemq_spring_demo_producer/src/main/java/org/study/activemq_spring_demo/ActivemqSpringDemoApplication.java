package org.study.activemq_spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActivemqSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqSpringDemoApplication.class, args);
    }

}
