package com.helpdeskproject.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordSecurity {

    public static String Hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static Boolean Verify(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
