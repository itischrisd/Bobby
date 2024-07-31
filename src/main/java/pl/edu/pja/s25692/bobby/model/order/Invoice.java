package pl.edu.pja.s25692.bobby.model.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.edu.pja.s25692.bobby.model.company.Company;
import pl.edu.pja.s25692.bobby.model.validation.OrderAllowedIfCompanyIsNotSupplier;
import pl.edu.pja.s25692.bobby.model.validation.ValidInvoiceDates;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@OrderAllowedIfCompanyIsNotSupplier
@ValidInvoiceDates
public class Invoice {

    @Getter
    @Setter
    private static double vatRate = 0.23;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Number cannot be null or empty")
    private String number;

    @NotNull(message = "Issue date cannot be null")
    private LocalDate issueDate;

    @NotNull(message = "Payment date cannot be null")
    private LocalDate paymentDate;

    @NotNull(message = "Net value cannot be null")
    @Positive(message = "Net value must be positive")
    private BigDecimal netValue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;

    @Transient
    public BigDecimal getGroosValue() {
        return netValue.multiply(BigDecimal.valueOf(1 + vatRate));
    }
}
