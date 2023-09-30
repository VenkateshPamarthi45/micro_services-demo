package com.venky.department.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venky.department.department.dto.DepartmentRequest;
import com.venky.department.department.dto.DepartmentResponse;
import com.venky.department.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentControllerImpl implements DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest department){
        log.debug("save department");
        return departmentService.saveDepartment(department);
    }

    @Override
    public List<DepartmentResponse> getDepartments(){
        log.debug("get departments");
        return departmentService.getDepartments();
    }

    @Override
    public DepartmentResponse getDepartmentById(String id) {
        return departmentService.getDepartmentById(id);
    }
    
}
