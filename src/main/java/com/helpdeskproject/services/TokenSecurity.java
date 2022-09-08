package com.helpdeskproject.services;

import java.util.Date;

import com.helpdeskproject.models.UserLoginModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenSecurity {

    private static final String token = "i5&soCodR9sZwe&xay9yD7cHXOiBfn8@^!ckj0oMrBh9G$rv1c";
    private static final long JWT_TOKEN_VALIDITY = 5*60*60;

    public static String GenerateToken(UserLoginModel userLoginModel) {
        return Jwts.builder().setSubject(userLoginModel.getEmail()).signWith(SignatureAlgorithm.HS512, token).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).compact();
	}

}