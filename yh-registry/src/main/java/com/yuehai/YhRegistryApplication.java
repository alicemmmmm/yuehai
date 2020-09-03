package com.yuehai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YhRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(YhRegistryApplication.class);
    }
}
