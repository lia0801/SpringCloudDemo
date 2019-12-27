package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringCloudApplication
@EnableZuulProxy //开启zuu
public class ZuuApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuuApplication.class,args);
    }
}
