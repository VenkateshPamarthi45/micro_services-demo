package com.venky.users.service;

import java.util.List;

import com.venky.users.dto.UsersRequest;
import com.venky.users.dto.UsersResponse;
import com.venky.users.dto.UsersWithDepartmentResponse;

public interface UsersService {

    UsersResponse saveUser(UsersRequest usersRequest);

    List<UsersResponse> getUsers();

    UsersWithDepartmentResponse getUser(String userId);

}