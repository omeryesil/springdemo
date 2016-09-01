package com.awapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yesiome on 8/30/2016.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Das Boot, reporting for duty!";
    }

}
