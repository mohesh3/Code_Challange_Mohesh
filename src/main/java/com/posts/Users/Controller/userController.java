package com.posts.Users.Controller;

import com.posts.Users.Entity.userEntity;
import com.posts.Users.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDetails")
public class userController
{
    @Autowired
    userService uservice;

    @GetMapping("/userIdCount")
    public Map<String, Integer> userIdCount()
    {
        return uservice.userIdCount();
    }

    @GetMapping("/ChangedData")
    public List<userEntity> changedData()
    {
        return uservice.changeData();
    }

}
