package com.gahan.gahan_app.service;


import com.gahan.gahan_app.entity.Loan;

public interface LoanService {

    Loan createLoan(Loan loan);

    double calculatePayableAmount(Long loanId);

    Loan getLoanById(Long loanId);

    long getMonthsPassed(Loan loan);
}
