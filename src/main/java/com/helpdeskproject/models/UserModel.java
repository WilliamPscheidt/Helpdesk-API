package com.helpdeskproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "users")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "The name is required.")
    @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.")
    @Column(nullable = false, length = 40)
    String name;

    @NotEmpty(message = "The lastname is required.")
    @Size(min = 2, max = 100, message = "The length of lastname must be between 2 and 100 characters.")
    @Column(nullable = false, length = 40)
    String lastname;

    @NotEmpty(message = "The email is required.")
    @Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
    @Column(nullable = false, length = 100)
    String email;

    @NotEmpty(message = "The password is required.")
    @Size(min = 2, max = 100, message = "The length of password must be between 2 and 100 characters.")
    @Column(nullable = false, length = 100)
    String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
}
