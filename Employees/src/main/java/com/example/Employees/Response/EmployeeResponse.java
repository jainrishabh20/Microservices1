package com.example.Employees.Response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private int id;
    private String ename;
    private String email;
    private String bgroup;

    private AddressResponse addressResponse;

}
