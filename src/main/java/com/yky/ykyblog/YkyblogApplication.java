package com.yky.ykyblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@EnableWebMvc
public class YkyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(YkyblogApplication.class, args);
    }

}
