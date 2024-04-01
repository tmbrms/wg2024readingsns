package com.ibmtambara.readingsns;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hoge")
    public String index(){
        return "Hello, World!";
    }
}
