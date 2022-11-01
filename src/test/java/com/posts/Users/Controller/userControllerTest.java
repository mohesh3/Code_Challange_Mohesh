package com.posts.Users.Controller;

import com.posts.Users.Service.userService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class userControllerTest {
    @InjectMocks
    userController controller;

    @Mock
    userService service;


    @Test
    void userIdCount_test() {

    }

    @Test
    void changedData_test() {
    }
}