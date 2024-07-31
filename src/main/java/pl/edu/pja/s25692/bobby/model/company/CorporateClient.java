package pl.edu.pja.s25692.bobby.model.company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.pl.REGON;
import pl.edu.pja.s25692.bobby.model.client.IClient;
import pl.edu.pja.s25692.bobby.model.order.Order;
import pl.edu.pja.s25692.bobby.model.service.Reservation;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CorporateClient extends Company implements IClient {

    @NotBlank(message = "Email cannot be null or empty")
    @Email(message = "Email must be valid")
    @Size(min = 3, max = 100, message = "Email must be between 3 and 100 characters")
    private String email;

    @Pattern(regexp = "|\\S.*", message = "REGON cannot be empty")
    @REGON(message = "REGON must be valid")
    private String REGON;

    @OneToMany(mappedBy = "corporateClient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "corporateClient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Reservation> reservations = new HashSet<>();
}
