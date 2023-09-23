package edu.tsinghua.demo.controller;

import edu.tsinghua.demo.service.demo1.Demo1Service;
import edu.tsinghua.demo.service.demo1.GoodService;
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

    private Demo1Service serviceNew = new GoodService();

    @Autowired
    private Map<String, Demo1Service> serviceMap;

    @GetMapping("/test1")
    public String test1() {
        return service.serviceOne();
    }

    @GetMapping("/test2")
    public String test2() {
        return serviceNew.serviceOne();
    }

    @GetMapping("/test3")
    public String test3() {
        Demo1Service service3 = new GoodService();
        return service3.serviceTwo();
    }

    @GetMapping("/test4")
    public String test4(@RequestParam String level) {
        return serviceMap.get(level).serviceOne();
    }

    public static void main(String[] args) {
        DemoController1 controller1 = new DemoController1();
        controller1.test1();
        controller1.test2();
        controller1.test3();
    }
}
