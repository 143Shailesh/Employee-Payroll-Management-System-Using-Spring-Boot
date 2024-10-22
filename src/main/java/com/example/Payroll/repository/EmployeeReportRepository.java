package com.example.Payroll.repository;

import com.example.Payroll.model.EmployeeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReportRepository extends JpaRepository<EmployeeReport, Long> {
    List<EmployeeReport> findByBranch(String branch);
}
