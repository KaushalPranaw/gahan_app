package com.gahan.gahan_app.repository;

import com.gahan.gahan_app.entity.Loan;
import com.gahan.gahan_app.entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByStatus(LoanStatus status);
}