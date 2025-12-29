package com.gahan.gahan_app.controller;

import com.gahan.gahan_app.entity.Loan;
import com.gahan.gahan_app.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Create Loan
    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    // Get total payable amount
    @GetMapping("/{loanId}/payable")
    public double getPayableAmount(@PathVariable Long loanId) {
        return loanService.calculatePayableAmount(loanId);
    }
}
