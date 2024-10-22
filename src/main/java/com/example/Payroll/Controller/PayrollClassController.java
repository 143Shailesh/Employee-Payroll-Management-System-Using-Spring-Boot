package com.example.Payroll.Controller;

import com.example.Payroll.model.PayrollClass;
import com.example.Payroll.service.PayrollClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payroll-classes")
public class PayrollClassController {

    @Autowired
    private PayrollClassService payrollClassService;

    @PostMapping
    public ResponseEntity<PayrollClass> createPayrollClass(@RequestBody PayrollClass payrollClass) {
        PayrollClass savedPayrollClass = payrollClassService.savePayrollClass(payrollClass);
        return ResponseEntity.ok(savedPayrollClass);
    }

    @GetMapping
    public ResponseEntity<List<PayrollClass>> getAllPayrollClasses() {
        List<PayrollClass> payrollClasses = payrollClassService.getAllPayrollClasses();
        return ResponseEntity.ok(payrollClasses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollClass> getPayrollClassById(@PathVariable Long id) {
        Optional<PayrollClass> payrollClass = payrollClassService.getPayrollClassById(id);
        return payrollClass.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollClass> updatePayrollClass(@PathVariable Long id, @RequestBody PayrollClass updatedPayrollClass) {
        Optional<PayrollClass> payrollClass = payrollClassService.getPayrollClassById(id);
        if (payrollClass.isPresent()) {
            PayrollClass savedPayrollClass = payrollClassService.updatePayrollClass(id, updatedPayrollClass);
            return ResponseEntity.ok(savedPayrollClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayrollClass(@PathVariable Long id) {
        boolean deleted = payrollClassService.deletePayrollClass(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
