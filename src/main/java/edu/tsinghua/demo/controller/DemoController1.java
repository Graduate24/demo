package edu.tsinghua.demo.controller;

import edu.tsinghua.demo.service.demo1.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController1 {

    @Autowired
    @Qualifier("good")
    private Demo1Service service;

    @Autowired
    private Map<String, Demo1Service> serviceMap;

    @GetMapping("/test1")
    public String test1() {
        return "Hello, World!";
    }

    @GetMapping("/test2")
    public @ResponseBody
    String test2() {
        return service.serviceOne();
    }

    @GetMapping("/test3")
    public @ResponseBody
    String test3(@RequestParam String level) {
        return serviceMap.get(level).serviceOne();
    }
}
