package pl.edu.pja.s25692.bobby.model.company;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.pl.NIP;
import pl.edu.pja.s25692.bobby.model.misc.Address;
import pl.edu.pja.s25692.bobby.model.order.Invoice;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "NIP cannot be null or empty")
    @NIP(message = "NIP must be valid")
    private String NIP;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @NotNull(message = "Address cannot be null")
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Invoice> invoices = new HashSet<>();
}
