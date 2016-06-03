package edu.rdragunov.count.translator.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by roman.dragunov on 03-06-02016.
 */
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"edu.rdragunov.count.translator"})
public class Main {
  @Autowired
  private Config config;
  public static void main(String[] args) {
    ApplicationContext ctx=SpringApplication.run(Main.class);
  }

}
