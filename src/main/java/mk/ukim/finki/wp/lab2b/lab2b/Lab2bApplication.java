package mk.ukim.finki.wp.lab2b.lab2b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab2bApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2bApplication.class, args);
    }

}
