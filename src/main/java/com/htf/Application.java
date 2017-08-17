package com.htf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        Environment environment = SpringApplication.run(Application.class, args).getEnvironment();
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://{}:{}\n----------------------------------------------------------",
                environment.getProperty("spring.application.name"),
                environment.getProperty("spring.application.ip"),
                environment.getProperty("server.port"));

    }
}
