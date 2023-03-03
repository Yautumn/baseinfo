package com.yautumn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableEurekaClient
@ServletComponentScan
@EnableFeignClients
@MapperScan(basePackages = {"com.yautumn.dao"})
public class BaseInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseInformationApplication.class, args);
    }

}
