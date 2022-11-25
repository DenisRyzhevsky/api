package com.apitest.Springboottest.service;

import com.apitest.Springboottest.controller.UserController;
import com.apitest.Springboottest.entity.UserEntity;
import com.apitest.Springboottest.exception.UserAlreadyExistsException;
import com.apitest.Springboottest.exception.UserNotFoundExecption;
import com.apitest.Springboottest.model.Status;
import com.apitest.Springboottest.model.Users;
import com.apitest.Springboottest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("Пользователь с тамким именем уже существует");
        }
        return userRepo.save(user);
    }

    public Users getOne(Long id) throws UserNotFoundExecption {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundExecption("Пользователь небыл найден");
        }
        return Users.toModel(user);
    }

//    public Status status(Long id) {
//        UserEntity user = userRepo.findById(id).get();
//        user.setOnline(!user.isOnline());
//        return Status.toModel(userRepo.save(user));
//    }

    public Status status(Long id) {
        UserEntity user = userRepo.findById(id).get();
        
        return Status.toModel(userRepo.save(user));
    }



}
