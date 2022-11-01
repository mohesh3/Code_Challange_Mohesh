package com.posts.Users.Service;

import com.posts.Users.Entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class userService
{
    RestTemplate restTemplate;

    @Autowired
    public userService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Map<String,Integer>userIdCount()
    {
        try
        {
            userEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", userEntity[].class);
            List<userEntity> list = new ArrayList<>(Arrays.asList(user));
            return userIdCounter(list);
        }
        catch (RestClientException e)
        {
            throw new RuntimeException("Got a Run Time Exception");
        }
    }

    public Map<String,Integer> userIdCounter(List<userEntity> list)
    {
        try
        {
            Map<Integer, List<userEntity>> map = list.stream().collect(Collectors.groupingBy(userEntity::getUserId));
            Map<String, Integer> map1 = new HashMap<>();
            map.forEach((k, v) -> {map1.put("userId " + k+" : ", v.size());});
            return map1;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Got a Runtime Exception");
        }

    }

    public List<userEntity> changeData()
    {
        try
        {
            userEntity[] user = restTemplate
                    .getForObject("http://jsonplaceholder.typicode.com/posts"
                            , userEntity[].class);
            List<userEntity> list = new ArrayList<>(Arrays.asList((user)));
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
