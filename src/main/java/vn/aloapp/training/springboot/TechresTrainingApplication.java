package vn.aloapp.training.springboot;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"vn.aloapp.training.springboot"})
@EnableAutoConfiguration
public class TechresTrainingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(TechresTrainingApplication.class, args);
        
    }
    
}