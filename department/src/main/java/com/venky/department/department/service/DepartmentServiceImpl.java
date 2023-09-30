package com.venky.department.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.department.department.dto.DepartmentRequest;
import com.venky.department.department.dto.DepartmentResponse;
import com.venky.department.department.entity.Department;
import com.venky.department.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getName())
                .address(request.getAddress())
                .code(request.getCode())
                .build();

        Department savedEntity = repository.save(department);
        DepartmentResponse response = mapToResponse(savedEntity);
        return response;
    }

    @Override
    public List<DepartmentResponse> getDepartments() {
        List<Department> departments = repository.findAll();
        List<DepartmentResponse> response = departments.stream().map(department -> mapToResponse(department)).toList();
        return response;
    }

    private DepartmentResponse mapToResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .address(department.getAddress())
                .code(department.getCode())
                .build();
    }

    @Override
    public DepartmentResponse getDepartmentById(String id) {
        Department department = repository.findById(id).orElse(new Department());
        return mapToResponse(department);
    }

}
