package com.venky.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venky.users.dto.UsersRequest;
import com.venky.users.dto.UsersResponse;
import com.venky.users.dto.UsersWithDepartmentResponse;
import com.venky.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UsersControllerImpl implements UsersController {

    @Autowired
    private UsersService service;

    @Override
    public UsersResponse saveUsers(UsersRequest request) {
        return service.saveUser(request);
    }

    @Override
    public List<UsersResponse> getUsers() {
        log.debug("get users");
        return service.getUsers();
    }

    @Override
    public UsersWithDepartmentResponse getUserWithDepartment(String userId) {
        return service.getUser(userId);
    }

}
