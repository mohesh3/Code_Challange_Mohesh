package com.posts.Users.Controller;

import com.posts.Users.Entity.UserEntity;
import com.posts.Users.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
class UserControllerTest
{
    @InjectMocks
    UserController controller;

    @Mock
    UserService service;

    @Test
    void userIdCount_test()
    {
        List<UserEntity> list= new ArrayList<>();
        UserEntity user1=new UserEntity();
        user1.setId(1L);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        assertNotNull(list);
        assertEquals(1,list.size());
        Map<Integer, List<UserEntity>> map = list.stream().collect(Collectors.groupingBy(UserEntity::getUserId));
        Map<String, Integer> map1 = new HashMap<>();
        map.forEach((k, v) -> map1.put("userId " + k, v.size()));
        assertNotNull(map1);
        assertEquals(1,map1.size());
        Mockito.when(service.userIdCount()).thenReturn(map1);
        assertNotNull(controller.userIdCount());
        assertNotNull(service.userIdCount());
        assertNotNull(service.userIdCounter(list));
    }

    @Test
    void changedData_test()
    {
        UserEntity user = new UserEntity();
        List<UserEntity> list = new ArrayList<>(List.of((user)));
        UserEntity user1=new UserEntity();
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