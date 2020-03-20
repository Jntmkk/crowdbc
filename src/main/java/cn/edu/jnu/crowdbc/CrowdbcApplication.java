package cn.edu.jnu.crowdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@ComponentScans({@ComponentScan("cn.edu.jnu.crowdbc.utils")})
public class CrowdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdbcApplication.class, args);
    }

}
