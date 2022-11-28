package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
})


public class SprinbootLoginappApplication {

    public static void main(String[] args) throws ParserConfigurationException, IOException {
        SpringApplication.run(SprinbootLoginappApplication.class, args);

        System.out.println("my app running");
        sabahhaber.sabahhaber();
    }

}
