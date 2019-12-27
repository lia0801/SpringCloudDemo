package com.hp.controller;

import com.hp.client.UserClient;
import com.hp.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class CustomerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;//eureka客户端

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        String url = "http://localhost:8091/user/" + id;
//        //调用service中的方法 不在浏览器上访问
//        return this.restTemplate.getForObject(url, User.class);
//    }
//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        //获取服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //列表中取出一个服务
//        ServiceInstance serviceInstance = instances.get(0);
//        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//
//        String url="http://user-service/user/"+id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

//    //Hystrix第一种使用
//    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryback")  //方法使用熔断器
//    public String  queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        String  user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    public String queryback(Long id){
//        return "网络拥堵！！！！！！";
//    }

//    //Hystrix第二种使用
//    @GetMapping("{id}")
//    @HystrixCommand
//    public String  queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        String  user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    //当发生异常时调用
//    public String defaultFallback(){
//        return "网络拥堵！！！！！！222";
//    }

    @Autowired
    UserClient userClient;

    @GetMapping("{id}")
    public User  queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }


}
