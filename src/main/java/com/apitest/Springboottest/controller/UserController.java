package com.apitest.Springboottest.controller;

import com.apitest.Springboottest.entity.UserEntity;
import com.apitest.Springboottest.exception.UserAlreadyExistsException;
import com.apitest.Springboottest.exception.UserNotFoundExecption;
import com.apitest.Springboottest.model.Users;
import com.apitest.Springboottest.repository.UserRepo;
import com.apitest.Springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundExecption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity userStatus(@RequestParam Long id,
                                     @RequestParam("online") Boolean current) {
        try {
            return ResponseEntity.ok(userService.status(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не найден пользователь");
        }
    }
}


