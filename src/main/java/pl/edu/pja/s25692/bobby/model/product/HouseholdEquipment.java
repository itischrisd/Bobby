package pl.edu.pja.s25692.bobby.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "household_equipment")
public class HouseholdEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Is for self assembly cannot be null")
    private boolean isForSelfAssembly;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Product cannot be null")
    private Product product;

    @ElementCollection
    @CollectionTable(name = "household_equipment_certificate", joinColumns = @JoinColumn(name = "household_equipment_id"))
    @Builder.Default
    private Set<String> certificates = new HashSet<>();
}
