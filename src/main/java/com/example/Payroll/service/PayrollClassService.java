package com.example.Payroll.service;

import com.example.Payroll.model.PayrollClass;
import com.example.Payroll.repository.PayrollClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollClassService {

    @Autowired
    private PayrollClassRepository payrollClassRepository;

    public PayrollClass savePayrollClass(PayrollClass payrollClass) {
        return payrollClassRepository.save(payrollClass);
    }

    public List<PayrollClass> getAllPayrollClasses() {
        return payrollClassRepository.findAll();
    }

    public Optional<PayrollClass> getPayrollClassById(Long id) {
        return payrollClassRepository.findById(id);
    }

    public PayrollClass updatePayrollClass(Long id, PayrollClass updatedPayrollClass) {
        updatedPayrollClass.setId(id);
        return payrollClassRepository.save(updatedPayrollClass);
    }

    public boolean deletePayrollClass(Long id) {
        if (payrollClassRepository.existsById(id)) {
            payrollClassRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
