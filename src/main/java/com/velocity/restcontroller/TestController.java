package com.velocity.restcontroller;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    /**
     * Feature 1: Get Billing Summary
     * URL: http://localhost:8080/api/billing/summary
     */
    @GetMapping("/summary")
    public String getBillingSummary() {
        return "Welcome to the Billing Dashboard. You have 3 pending invoices.";
    }

    /**
     * Feature 2: Get Invoice Details by ID
     * URL: http://localhost:8080/api/billing/invoice/101
     */
    @GetMapping("/invoice/{id}")
    public Map<String, Object> getInvoice(@PathVariable int id) {
        Map<String, Object> invoice = new HashMap<>();
        invoice.put("invoiceId", id);
        invoice.put("amount", 250.75);
        invoice.put("status", "Unpaid");
        invoice.put("dueDate", "2023-12-31");
        return invoice;
    }

    /**
     * Feature 3: Calculate Total with Tax
     * URL: http://localhost:8080/api/billing/calculate?subtotal=100
     */
    @GetMapping("/calculate")
    public String calculateTotal(@RequestParam double subtotal) {
        double taxRate = 0.10; // 10% tax
        double total = subtotal + (subtotal * taxRate);
        return "The total amount including tax (10%) is: $" + total;
    }

    /**
     * Feature 4: Process a Payment (Mock)
     * URL: POST http://localhost:8080/api/billing/pay
     */
    @PostMapping("/pay")
    public String processPayment(@RequestBody Map<String, Object> paymentDetails) {
        // Logic to process payment would go here
        return "Payment of $" + paymentDetails.get("amount") + " processed successfully!";
    }
}
