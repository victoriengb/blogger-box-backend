package com.dauphine.blogger_box_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(
        name = "Hello World API",
        description = "Hello World endpoints"
)
public class HelloWorldController {
    
    @GetMapping("hello-world")
    @Operation(
            summary = "Hello World",
            description = "Returns a hello world message"
    )
    public String helloWorld() {
        return "Hello World!";
    }
    
    //For filtering
    @GetMapping("hello")
    @Operation(
            summary = "Hello by name",
            description = "Returns a hello message with the given name"
    )
    public String helloByName(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    //To get a subresource
    @GetMapping("hello/{name}")
    @Operation(
            summary = "Hello by name",
            description = "Returns a hello message with the given name"
    )
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}