package com.helpdeskproject.controllers;

import javax.validation.Valid;

import com.helpdeskproject.services.PasswordSecurity;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.models.UserLoginModel;
import com.helpdeskproject.models.UserModel;
import com.helpdeskproject.repository.LoginUserRepository;
import com.helpdeskproject.repository.UserRepository;
import com.helpdeskproject.services.TokenSecurity;;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(path = "/api/user")
    public ResponseEntity<String> SaveUser(@Valid @RequestBody UserModel userdata) {

        userdata.setPassword(PasswordSecurity.Hash(userdata.getPassword()));

        try{repository.save(userdata);}
        catch(DataAccessException e) {return ResponseEntity.badRequest().body(SendResponse("error", "user already created"));}

        return ResponseEntity.ok().body(SendResponse("success", "user registered"));
    }

    @PostMapping(path = "/api/login/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> LoginUser(@Valid @RequestBody  UserLoginModel userloginmodel) {

        String[] dataQuery = LoginUserRepository.ExecuteQuery();

        if (PasswordSecurity.Verify(userloginmodel.getPassword(), dataQuery[1])) {

            String token = TokenSecurity.GenerateToken(userloginmodel);

            return ResponseEntity.ok().body(SendSuccessResponse("success", "User logged in", token));
        } else {
            return ResponseEntity.badRequest().body(SendResponse("error", "Invalid data provided"));
        }
    }

    public static String SendResponse(String status, String message) {
        JSONObject resp = new JSONObject();
        resp.put("status", status);
        resp.put("message", message);
        return resp.toString();
    }

    public static String SendSuccessResponse(String status, String message, String token) {
        JSONObject resp = new JSONObject();
        resp.put("status", status);
        resp.put("message", message);
        resp.put("token", token);
        return resp.toString();
    }
}