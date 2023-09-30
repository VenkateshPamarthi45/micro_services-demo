package com.venky.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.venky.users.dto.Department;
import com.venky.users.dto.UsersRequest;
import com.venky.users.dto.UsersResponse;
import com.venky.users.dto.UsersWithDepartmentResponse;
import com.venky.users.entity.User;
import com.venky.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UsersResponse saveUser(UsersRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .departmentId(request.getDepartmentId())
                .build();

        User savedEntity = repository.save(user);
        UsersResponse response = mapToResponse(savedEntity);
        return response;
    }

    @Override
    public List<UsersResponse> getUsers() {
        List<User> users = repository.findAll();
        List<UsersResponse> response = users.stream().map(user -> mapToResponse(user)).toList();
        return response;
    }

    private UsersResponse mapToResponse(User user) {
        return UsersResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .departmentId(user.getDepartmentId())
                .build();
    }

    @Override
    public UsersWithDepartmentResponse getUser(String userId) {
        
        User userEntity = repository.findById(userId).orElse(new User());

        // call department
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/departments/"+userEntity.getDepartmentId(), Department.class);
        return new UsersWithDepartmentResponse(userEntity.getId(),userEntity.getFirstName(),userEntity.getLastName(), userEntity.getEmail(), department);

    }

}
