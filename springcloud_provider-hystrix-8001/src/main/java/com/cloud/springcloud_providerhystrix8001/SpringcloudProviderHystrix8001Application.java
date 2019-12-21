package com.cloud.springcloud_providerhystrix8001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringcloudProviderHystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderHystrix8001Application.class, args);
    }

}
