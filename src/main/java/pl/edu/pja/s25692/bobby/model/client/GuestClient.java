package pl.edu.pja.s25692.bobby.model.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "guest_client")
public class GuestClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number cannot be null or empty")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "Phone number must be in format XXX-XXX-XXX")
    private String phoneNumber;

    @OneToOne(optional = false)
    @JoinColumn(name = "individual_client_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Individual client cannot be null")
    private IndividualClient individualClient;
}
