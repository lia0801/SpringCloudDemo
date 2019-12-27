package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *Customer去调用User
 */

//@EnableCircuitBreaker //开启熔断器（2）
//@EnableDiscoveryClient //erueka的客户端
//@SpringBootApplication
//    三合一

@SpringCloudApplication
@EnableFeignClients //开启Feign
public class CustomerApplication {
//feien代替
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
