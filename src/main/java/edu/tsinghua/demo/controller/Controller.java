package edu.tsinghua.demo.controller;

import edu.tsinghua.demo.util.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test1")
    public String localTime() {
        return "Hello, World!";
    }
}
