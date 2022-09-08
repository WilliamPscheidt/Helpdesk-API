package com.helpdeskproject.controllers;

import javax.validation.Valid;

import com.helpdeskproject.services.PasswordSecurity;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.models.UserLoginModel;
import com.helpdeskproject.models.UserModel;
import com.helpdeskproject.repository.LoginUserRepository;
import com.helpdeskproject.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(path = "/api/user")
    public ResponseEntity<String> SaveUser(@Valid @RequestBody UserModel userdata) {

        userdata.setPassword(PasswordSecurity.Hash(userdata.getPassword()));

        try{repository.save(userdata);}
        catch(DataAccessException e) {return ResponseEntity.badRequest().body("{\"error\":User alterady created}");}

        return ResponseEntity.ok().body(JSONObject.quote("{\"Success\":User registered}"));
    }

    @PostMapping(path = "/api/login/")
    public ResponseEntity<String> LoginUser(@RequestBody  UserLoginModel userloginmodel) {

        String[] dataQuery = LoginUserRepository.ExecuteQuery();

        if(PasswordSecurity.Verify(userloginmodel.getPassword(), dataQuery[1])){
            return ResponseEntity.ok().body("Success: User logged");
        } else {
            return ResponseEntity.badRequest().body("Error: invalid");
        }
    }   
}