package com.aitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by sunyu on 2017/9/2.
 */
@SpringBootApplication
@EnableSwagger2
public class AiTaoApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AiTaoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AiTaoApplication.class, args);
    }
}