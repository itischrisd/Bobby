package pl.edu.pja.s25692.bobby.model.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "regular_client")
public class RegularClient {

    @Getter
    @Setter
    private static double initialDiscount = 0.05;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Card number cannot be null or empty")
    @Size(min = 16, max = 16, message = "Card number must be 16 characters long")
    private String cardNumber;

    @NotBlank(message = "Card pin cannot be null or empty")
    @Size(min = 4, max = 4, message = "Card pin must be 4 characters long")
    private String cardPin;

    @NotNull(message = "Discount cannot be null")
    @DecimalMin(value = "0.0", message = "Discount must be greater than 0")
    @DecimalMax(value = "1.0", message = "Discount must be less than 1")
    @Builder.Default
    private double discount = initialDiscount;

    @OneToOne(optional = false)
    @JoinColumn(name = "individual_client_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Individual client cannot be null")
    private IndividualClient individualClient;
}
