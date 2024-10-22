package com.example.Payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String pincode;
    private String mobile;
    private String degree;
    private String designation;
    private String branch;
    private String employeeClass;
    private Double basicPay;
    private Double salary;
    private String bankAccountNo;
    private String email;
    private String password;
    private String status;
}
