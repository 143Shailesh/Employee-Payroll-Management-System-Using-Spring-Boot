package com.example.Payroll.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PayrollClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private Double basicPay;
    private Double salary;
    private Double travelAllowance = 0.0;
    private Double medicalAllowance = 0.0;
    private Double washingAllowance = 0.0;

    @OneToMany(mappedBy = "payrollClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeReport> employees;
}
