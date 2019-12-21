package com.wn.springcloud_provider03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient  //Eure服务发现
@MapperScan("com.wn.springcloud_provider03.*")
public class SpringcloudProvider03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider03Application.class, args);
    }

}
