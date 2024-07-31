package pl.edu.pja.s25692.bobby.model.employee;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Contractor extends Employee {

    @Positive(message = "Contract value must be positive")
    @NotNull(message = "Contract value cannot be null")
    private BigDecimal contractValue;

    @NotNull(message = "Contract description cannot be null")
    @Size(min = 3, max = 1000, message = "Contract description must be between 3 and 1000 characters")
    private String contractDescription;

    @NotNull(message = "Payment date cannot be null")
    @FutureOrPresent(message = "Payment date must be in the present or future")
    private LocalDate paymentDate;
}
