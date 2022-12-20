package com.cap.eurekaclient.controller;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/greeting")
    public String greeting() {

        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName() + " Port: " + port);
    }
}