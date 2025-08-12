package com.example.myproject.Controller;

import com.example.myproject.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class user {
    private final UserServiceImpl userService;

    @Autowired
    public user(UserServiceImpl userService) {
        this.userService=userService;
    }

    @GetMapping("/get-user")
    public String getData(@RequestHeader long userId){
        return this.userService.getDataByUserId(userId);
    }
}
