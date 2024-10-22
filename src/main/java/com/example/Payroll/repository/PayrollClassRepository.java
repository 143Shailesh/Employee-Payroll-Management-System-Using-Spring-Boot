package com.example.Payroll.repository;

import com.example.Payroll.model.PayrollClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollClassRepository extends JpaRepository<PayrollClass, Long> {
}
