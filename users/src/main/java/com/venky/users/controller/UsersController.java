package com.venky.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.venky.users.dto.UsersRequest;
import com.venky.users.dto.UsersResponse;
import com.venky.users.dto.UsersWithDepartmentResponse;

public interface UsersController {
    
    @PostMapping
    UsersResponse saveUsers(@RequestBody UsersRequest user);

    @GetMapping
    List<UsersResponse> getUsers();

    @GetMapping("/{id}")
    UsersWithDepartmentResponse getUserWithDepartment(@PathVariable("id") String userId);

}