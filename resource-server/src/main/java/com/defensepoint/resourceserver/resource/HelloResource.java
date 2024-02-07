package com.defensepoint.resourceserver.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Task 2: Endpoint Security with OAuth 2.0
 */

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping("/all")
    public String helloAll() {
        return "Hello All";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User";
    }
}
