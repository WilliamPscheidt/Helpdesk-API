package com.helpdeskproject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.models.UserLoginModel;
import com.helpdeskproject.models.UserModel;
import com.helpdeskproject.repository.LoginUserRepository;
import com.helpdeskproject.repository.UserRepository;
import com.helpdeskproject.utils.PasswordSecurity;
import com.helpdeskproject.utils.TokenSecurity;
import com.helpdeskproject.utils.ResponseFormatter;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(path = "/api/user/register")
    public ResponseEntity<String> SaveUser(@Valid @RequestBody UserModel userdata) {

        userdata.setPassword(PasswordSecurity.Hash(userdata.getPassword()));

        try{
            repository.save(userdata);
        }
        catch(DataAccessException e) {
            return ResponseEntity.badRequest().body(ResponseFormatter.SendResponse("error", "user already created"));
        }

        return ResponseEntity.ok().body(ResponseFormatter.SendResponse("success", "user registered"));
    }

    @PostMapping(path = "/api/user/login")
    public ResponseEntity<String> LoginUser(@Valid @RequestBody  UserLoginModel userloginmodel) {

        String[] dataQuery = LoginUserRepository.ExecuteQuery();

        if (PasswordSecurity.Verify(userloginmodel.getPassword(), dataQuery[1])) {

            String token = TokenSecurity.GenerateToken(userloginmodel);

            return ResponseEntity.ok().body(ResponseFormatter.SendSuccessResponse("success", "User logged in", token));
        } else {
            return ResponseEntity.badRequest().body(ResponseFormatter.SendResponse("error", "Invalid data provided"));
        }
    }
}