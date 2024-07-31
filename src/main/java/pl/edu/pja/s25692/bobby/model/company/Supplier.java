package pl.edu.pja.s25692.bobby.model.company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Supplier extends Company {

    @NotBlank(message = "Phone number cannot be null or empty")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "Phone number must be in format XXX-XXX-XXX")
    private String phoneNumber;

    @NotBlank(message = "Bank account number cannot be null or empty")
    @Pattern(regexp = "\\d{26}", message = "Bank account number must be 26 digits long")
    private String bankAccountNumber;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Offer> offers = new HashSet<>();
}
