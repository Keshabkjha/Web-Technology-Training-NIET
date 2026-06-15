package com.adm.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbFirstProjectApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(SbFirstProjectApplication.class, args);
        User u = context.getBean(User.class);
        u.show();
    }
}
