package com.helpdeskproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.utils.ResponseFormatter;

@RestController
public class StatusController {
    
    @GetMapping(path = "/")
    public ResponseEntity<String> GetStatus() {
        return ResponseEntity.ok().body(ResponseFormatter.SendResponse("success", "API Running"));
    }
}
