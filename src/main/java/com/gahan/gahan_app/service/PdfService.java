package com.gahan.gahan_app.service;

import com.gahan.gahan_app.entity.Loan;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public ByteArrayInputStream generateLoanPdf(Loan loan, double totalPayable, long months) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            document.add(new Paragraph("Gahan Loan Summary", titleFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Customer Name: " + loan.getCustomer().getName(), normalFont));
            document.add(new Paragraph("Mobile: " + loan.getCustomer().getMobile(), normalFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Gahan Type: " + loan.getGahan().getGahanType(), normalFont));
            document.add(new Paragraph("Metal Type: " + loan.getGahan().getMetalType(), normalFont));
            document.add(new Paragraph("Weight (grams): " + loan.getGahan().getWeightInGrams(), normalFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Loan Amount: ₹" + loan.getPrincipalAmount(), normalFont));
            document.add(new Paragraph("Interest Rate: " + loan.getInterestRate() + "% per month", normalFont));
            document.add(new Paragraph("Months Passed: " + months, normalFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Total Payable Amount: ₹" + totalPayable, titleFont));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
