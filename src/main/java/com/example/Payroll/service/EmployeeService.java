package com.example.Payroll.service;

import com.example.Payroll.model.EmployeeReport;
import com.example.Payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeReport saveEmployee(EmployeeReport employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeReport> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeReport> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public EmployeeReport updateEmployee(Long id, EmployeeReport updatedEmployee) {
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
