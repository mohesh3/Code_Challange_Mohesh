package com.posts.Users.Controller;

import com.posts.Users.Entity.UserEntity;
import com.posts.Users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDetails")
public class UserController
{
    @Autowired
    UserService service;

    @GetMapping("/userIdCount")
    public Map<String, Integer> userIdCount()
    {
        return service.userIdCount();
    }

    @GetMapping("/ChangedData")
    public List<UserEntity> changedData()
    {
        return service.changeData();
    }

}
