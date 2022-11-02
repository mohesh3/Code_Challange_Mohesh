package com.posts.Users.Service;

import com.posts.Users.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService
{
    RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Map<String,Integer>userIdCount() throws RuntimeException
    {
        try
        {
            UserEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserEntity[].class);
            List<UserEntity> list = null;
            if (user != null) {
                list = new ArrayList<>(Arrays.asList(user));
            }
            return userIdCounter(list);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Got a Run Time Exception");
        }
    }

    public Map<String,Integer> userIdCounter(List<UserEntity> list)
    {
        try
        {
            Map<Integer, List<UserEntity>> map = list.stream().collect(Collectors.groupingBy(UserEntity::getUserId));
            Map<String, Integer> map1 = new HashMap<>();
            map.forEach((k, v) -> map1.put("userId " + k+" : ", v.size()));
            return map1;
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Got a Runtime Exception");
        }

    }

    public List<UserEntity> changeData() throws NullPointerException
    {
        try
        {
            UserEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserEntity[].class);
            assert user != null;
            List<UserEntity> list = new ArrayList<>(Arrays.asList((user)));
            list.get(10).setBody("1800 Flowers");
            list.get(10).setTitle("1800 Flowers");
            return list;
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException("Got a NullPointer Exception");
        }
    }
}
