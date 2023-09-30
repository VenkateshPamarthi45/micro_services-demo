package com.venky.department.department.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.venky.department.department.dto.DepartmentRequest;
import com.venky.department.department.dto.DepartmentResponse;

public interface DepartmentController {
    
    @PostMapping
    DepartmentResponse saveDepartment(@RequestBody DepartmentRequest department);

    @GetMapping
    List<DepartmentResponse> getDepartments();

    @GetMapping("/{id}")
    DepartmentResponse getDepartmentById(@PathVariable String id);

}