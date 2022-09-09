package com.helpdeskproject.utils;

import java.util.Date;

import com.helpdeskproject.models.UserLoginModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenSecurity {

    private static final String KEY = "i5&soCodR9sZwe&xay9yD7cHXOiBfn8@^!ckj0oMrBh9G$rv1c";
    private static final long JWT_TOKEN_VALIDITY = 5*60*60;

    public static String GenerateToken(UserLoginModel userLoginModel) {
        return Jwts.builder().setSubject("HelpDeskSystem").claim("email", userLoginModel.getEmail()).signWith(SignatureAlgorithm.HS512, KEY).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).compact();
	}

    public static String VerifyEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().get("email", String.class);
    }

}