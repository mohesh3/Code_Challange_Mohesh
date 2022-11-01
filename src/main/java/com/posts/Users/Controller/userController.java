package com.posts.Users.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
public class userController {
    @Autowired
    userService uservice;

    @GetMapping("/userIdCount")
    public Map<String, Integer> userIdCount()
            throws JsonProcessingException, JsonMappingException
    {
        return uservice.userIdCount();
    }

    @GetMapping("/ChangedData")
    public List<userEntity> changedData()
            throws JsonProcessingException
    {
        return uservice.changeData();
    }
}
