package com.posts.Users.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.posts.Users.Entity.userEntity;
import com.posts.Users.Service.userService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class userControllerTest {
    @InjectMocks
    userController controller;

    @Mock
    userService service;
    RestTemplate restTemplate;


    @Test
    void userIdCount_test() throws JsonProcessingException {
        List<userEntity> list=new ArrayList<userEntity>();
        userEntity user1=new userEntity();
        user1.setId(1L);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        assertNotNull(list);
        assertEquals(1,list.size());
        Map<Integer, List<userEntity>> map = list.stream().collect(Collectors.groupingBy(userEntity::getUserId));
        Map<String, Integer> map1 = new HashMap<>();
        map.forEach((k, v) -> {map1.put("userId " + k, v.size());});
        assertNotNull(map1);
        assertEquals(1,map1.size());
        Mockito.when(service.userIdCount()).thenReturn(map1);
        assertNotNull(controller.userIdCount());
        assertNotNull(service.userIdCount());
        assertNotNull(service.userIdCounter(list));
    }

    @Test
    void changedData_test() throws JsonProcessingException {
        userEntity user = new userEntity();
        List<userEntity> list = new ArrayList<>(Arrays.asList((user)));
        userEntity user1=new userEntity();
        user1.setId(1L);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        list.get(1).setBody("1800 Flowers");
        list.get(1).setTitle("1800 Flowers");
        assertEquals("1800 Flowers",list.get(1).getTitle());
        assertEquals("1800 Flowers",list.get(1).getBody());
        assertEquals(1L,list.get(1).getId());
        Mockito.when(service.changeData()).thenReturn(list);
        assertNotNull(controller.changedData());
        assertNotNull(service.changeData());
    }
}