package com.nmsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String Email;
    private Integer gender; //0代表女,1代表男

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.Email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }

}
