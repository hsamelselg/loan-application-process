package ee.coop.loanapplicationprocess.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Setter
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Setter
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;

    @Setter
    @Column(name = "personal_id_code", nullable = false, length = 11)
    private String personalIdCode;

    @Setter
    @Column(name = "loan_period_months", nullable = false)
    private Integer loanPeriodMonths;

    @Setter
    @Column(name = "interest_margin", nullable = false, precision = 10, scale = 4)
    private BigDecimal interestMargin;

    @Setter
    @Column(name = "base_interest_rate", nullable = false, precision = 10, scale = 4)
    private BigDecimal baseInterestRate;

    @Setter
    @Column(name = "loan_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal loanAmount;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LoanStatus status;

    @Setter
    @Column(name = "rejection_reason", length = 50)
    private String rejectionReason;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Setter
    @OneToMany(mappedBy = "loanApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("paymentDate ASC")
    private List<com.coop.loan.entity.PaymentScheduleEntry> paymentSchedule = new ArrayList<>();


    public UUID getId() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPersonalIdCode() { return personalIdCode; }

    public Integer getLoanPeriodMonths() { return loanPeriodMonths; }

    public BigDecimal getInterestMargin() { return interestMargin; }

    public BigDecimal getBaseInterestRate() { return baseInterestRate; }

    public BigDecimal getLoanAmount() { return loanAmount; }

    public LoanStatus getStatus() { return status; }

    public String getRejectionReason() { return rejectionReason; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public List<com.coop.loan.entity.PaymentScheduleEntry> getPaymentSchedule() { return paymentSchedule; }
}
