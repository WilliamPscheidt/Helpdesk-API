package com.helpdeskproject.models;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class UserLoginModel {
    
    @Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
    @Column(nullable = false, length = 40)
    String email;

    @Size(min = 2, max = 100, message = "The length of password must be between 2 and 100 characters.")
    @Column(nullable = false, length = 40)
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
