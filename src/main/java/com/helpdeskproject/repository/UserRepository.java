package com.helpdeskproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.helpdeskproject.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}