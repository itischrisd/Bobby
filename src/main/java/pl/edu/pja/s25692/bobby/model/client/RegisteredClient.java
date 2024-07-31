package pl.edu.pja.s25692.bobby.model.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "registered_client")
public class RegisteredClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Login cannot be null or empty")
    @Size(min = 8, max = 20, message = "Login must be between 8 and 20 characters")
    private String login;

    @NotBlank(message = "Password cannot be null or empty")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name = "individual_client_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Individual client cannot be null")
    private IndividualClient individualClient;
}
