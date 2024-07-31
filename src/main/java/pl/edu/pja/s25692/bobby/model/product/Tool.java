package pl.edu.pja.s25692.bobby.model.product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Power must be positive")
    private Double power;

    @Positive(message = "Voltage must be positive")
    private Double voltage;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Product cannot be null")
    private Product product;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "tool_brand",
            joinColumns = @JoinColumn(name = "tool_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Brand> brands = new HashSet<>();
}
