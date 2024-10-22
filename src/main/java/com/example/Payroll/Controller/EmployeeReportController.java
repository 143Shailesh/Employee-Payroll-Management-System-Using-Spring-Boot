package com.example.Payroll.Controller;

import com.example.Payroll.model.EmployeeReport;
import com.example.Payroll.repository.EmployeeReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeReportController {

    @Autowired
    private EmployeeReportRepository employeeReportRepository;

    // Get all employees
    @GetMapping
    public List<EmployeeReport> getAllEmployees() {
        return employeeReportRepository.findAll();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeReport> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeReport> employee = employeeReportRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new employee
    @PostMapping
    public EmployeeReport createEmployee(@RequestBody EmployeeReport employeeReport) {
        return employeeReportRepository.save(employeeReport);
    }

    // Update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeReport> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeReport employeeDetails) {
        Optional<EmployeeReport> existingEmployee = employeeReportRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeeReport employee = existingEmployee.get();
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
            EmployeeReport updatedEmployee = employeeReportRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeReportRepository.existsById(id)) {
            employeeReportRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get employees by branch
    @GetMapping("/branch/{branch}")
    public List<EmployeeReport> getEmployeesByBranch(@PathVariable String branch) {
        return employeeReportRepository.findByBranch(branch);
    }

    // Change employee status
    @PutMapping("/{id}/status")
    public ResponseEntity<EmployeeReport> changeEmployeeStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        Optional<EmployeeReport> employeeOptional = employeeReportRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeReport employee = employeeOptional.get();
            employee.setStatus(status);
            employeeReportRepository.save(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
