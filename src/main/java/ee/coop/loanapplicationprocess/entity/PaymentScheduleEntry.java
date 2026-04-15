package com.coop.loan.entity;

import ee.coop.loanapplicationprocess.entity.LoanApplication;
import jakarta.persistence.*;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "payment_schedule_entries")
public class PaymentScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loan_application_id", nullable = false)
    private LoanApplication loanApplication;

    /**
     * Makse number (1, 2, 3, ...)
     */
    @Setter
    @Column(name = "payment_number", nullable = false)
    private Integer paymentNumber;

    /**
     * Makse kuupäev
     */
    @Setter
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    /**
     * Igakuine annuiteetmakse kogusumma
     */
    @Setter
    @Column(name = "total_payment", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalPayment;

    /**
     * Põhiosa osa maksest
     */
    @Setter
    @Column(name = "principal", nullable = false, precision = 15, scale = 2)
    private BigDecimal principal;

    /**
     * Intressiosa maksest
     */
    @Setter
    @Column(name = "interest", nullable = false, precision = 15, scale = 2)
    private BigDecimal interest;

    /**
     * Järelejäänud põhiosa pärast makset
     */
    @Setter
    @Column(name = "remaining_principal", nullable = false, precision = 15, scale = 2)
    private BigDecimal remainingPrincipal;

    // --- Getters and Setters ---

    public UUID getId() { return id; }

    public LoanApplication getLoanApplication() { return loanApplication; }

    public Integer getPaymentNumber() { return paymentNumber; }

    public LocalDate getPaymentDate() { return paymentDate; }

    public BigDecimal getTotalPayment() { return totalPayment; }

    public BigDecimal getPrincipal() { return principal; }

    public BigDecimal getInterest() { return interest; }

    public BigDecimal getRemainingPrincipal() { return remainingPrincipal; }
}
