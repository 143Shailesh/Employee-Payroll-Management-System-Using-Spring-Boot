package com.example.Payroll.repository;

import com.example.Payroll.model.EmployeeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeReport, Long> {
}
