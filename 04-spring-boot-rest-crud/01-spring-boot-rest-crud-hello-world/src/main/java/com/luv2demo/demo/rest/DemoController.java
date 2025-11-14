package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Rest
@RequestMapping
public class DemoController {

    // add code for the "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}