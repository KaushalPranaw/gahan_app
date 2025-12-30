package com.gahan.gahan_app.service.impl;

import com.gahan.gahan_app.entity.Loan;
import com.gahan.gahan_app.repository.LoanRepository;
import com.gahan.gahan_app.service.LoanService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public double calculatePayableAmount(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        long months = ChronoUnit.MONTHS.between(
                loan.getStartDate(),
                java.time.LocalDate.now()
        );

        return loan.getPrincipalAmount() +
                (loan.getPrincipalAmount() * loan.getInterestRate() * months / 100);
    }

    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public long getMonthsPassed(Loan loan) {
        return ChronoUnit.MONTHS.between(
                loan.getStartDate(),
                LocalDate.now()
        );
    }
}
