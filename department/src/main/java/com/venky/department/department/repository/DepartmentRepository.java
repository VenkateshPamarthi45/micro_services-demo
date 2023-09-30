package com.venky.department.department.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.venky.department.department.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department,String>{
    
}
