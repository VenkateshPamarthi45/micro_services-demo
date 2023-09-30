package com.venky.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersWithDepartmentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
     private Department department;
}
