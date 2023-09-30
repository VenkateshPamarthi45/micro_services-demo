package com.venky.department.department.service;

import java.util.List;

import com.venky.department.department.dto.DepartmentRequest;
import com.venky.department.department.dto.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse saveDepartment(DepartmentRequest department);

    List<DepartmentResponse> getDepartments();

    DepartmentResponse getDepartmentById(String id);

}