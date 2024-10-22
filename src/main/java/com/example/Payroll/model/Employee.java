package com.example.Payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

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

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "payroll_class_id")
    private PayrollClass payrollClass;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
