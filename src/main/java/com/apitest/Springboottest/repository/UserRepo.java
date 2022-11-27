package com.apitest.Springboottest.repository;

import com.apitest.Springboottest.entity.UserEntity;
import com.apitest.Springboottest.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
