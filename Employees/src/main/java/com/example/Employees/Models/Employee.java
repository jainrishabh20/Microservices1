package com.example.Employees.Models;

import com.example.Employees.Response.AddressResponse;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    private String ename;
    private String email;
    private String bgroup;

}
