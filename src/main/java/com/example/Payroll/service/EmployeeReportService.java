package com.example.Payroll.service;

import com.example.Payroll.model.EmployeeReport;
import com.example.Payroll.repository.EmployeeReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeReportRepository employeeReportRepository;

    // Get all employees
    public List<EmployeeReport> getAllEmployees() {
        return employeeReportRepository.findAll();
    }

    // Get employee by ID
    public Optional<EmployeeReport> getEmployeeById(Long id) {
        return employeeReportRepository.findById(id);
    }

    // Create new employee
    public EmployeeReport createEmployee(EmployeeReport employeeReport) {
        return employeeReportRepository.save(employeeReport);
    }

    // Update employee
    public Optional<EmployeeReport> updateEmployee(Long id, EmployeeReport employeeDetails) {
        return employeeReportRepository.findById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setCity(employeeDetails.getCity());
            employee.setPincode(employeeDetails.getPincode());
            employee.setMobile(employeeDetails.getMobile());
            employee.setDegree(employeeDetails.getDegree());
            employee.setDesignation(employeeDetails.getDesignation());
            employee.setBranch(employeeDetails.getBranch());
            employee.setEmployeeClass(employeeDetails.getEmployeeClass());
            employee.setBasicPay(employeeDetails.getBasicPay());
            employee.setSalary(employeeDetails.getSalary());
            employee.setBankAccountNo(employeeDetails.getBankAccountNo());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPassword(employeeDetails.getPassword());
            employee.setStatus(employeeDetails.getStatus());
            return employeeReportRepository.save(employee);
        });
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeReportRepository.deleteById(id);
    }

    // Get employees by branch
    public List<EmployeeReport> getEmployeesByBranch(String branch) {
        return employeeReportRepository.findByBranch(branch);
    }

    // Change employee status
    public Optional<EmployeeReport> changeEmployeeStatus(Long id, String status) {
        return employeeReportRepository.findById(id).map(employee -> {
            employee.setStatus(status);
            return employeeReportRepository.save(employee);
        });
    }
}
