package com.gahan.gahan_app.controller;

import com.gahan.gahan_app.entity.Loan;
import com.gahan.gahan_app.service.LoanService;
import com.gahan.gahan_app.service.PdfService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;
    private final PdfService pdfService;

    public LoanController(LoanService loanService, PdfService pdfService) {
        this.loanService = loanService;
        this.pdfService = pdfService;
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

    @GetMapping("/{loanId}/pdf")
    public ResponseEntity<InputStreamResource> downloadLoanPdf(@PathVariable Long loanId) {

        Loan loan = loanService.getLoanById(loanId);
        double totalPayable = loanService.calculatePayableAmount(loanId);
        long months = loanService.getMonthsPassed(loan);

        ByteArrayInputStream pdf = pdfService.generateLoanPdf(loan, totalPayable, months);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=loan-summary.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
