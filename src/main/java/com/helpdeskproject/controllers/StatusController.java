package com.helpdeskproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    
    @GetMapping(path = "/api/status")
    public static String ReturnData() {
        return "Ok";
    }
}
