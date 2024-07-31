package pl.edu.pja.s25692.bobby.model.product;

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
@Table(name = "building_material")
public class BuildingMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Unit cannot be null or empty")
    @Size(min = 1, max = 10, message = "Unit must be between 1 and 10 characters")
    private String unit;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Product cannot be null")
    private Product product;
}
