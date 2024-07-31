package pl.edu.pja.s25692.bobby.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import pl.edu.pja.s25692.bobby.model.company.Offer;
import pl.edu.pja.s25692.bobby.model.order.OrderElement;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements ITool, IBuildingMaterial, IHouseholdEquipment {

    @Getter
    @Setter
    private static double vatRate = 0.23;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description cannot be null or empty")
    @Size(min = 3, max = 1000, message = "Description must be between 3 and 1000 characters")
    private String description;

    @NotNull(message = "Net price cannot be null")
    @Positive(message = "Net price must be positive")
    private BigDecimal netPrice;

    @Size(min = 3, max = 100, message = "Color must be between 3 and 100 characters")
    private String color;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_material",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Used materials cannot be empty")
    private Set<AvailableProductMaterial> usedMaterials = new HashSet<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Tool tool;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BuildingMaterial buildingMaterial;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private HouseholdEquipment householdEquipment;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Category cannot be null")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderElement> orders = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Offer> offers = new HashSet<>();

    @PrePersist
    @PreUpdate
    private void validateAssociations() {
        if (tool == null && buildingMaterial == null && householdEquipment == null) {
            throw new IllegalArgumentException("At least one association (tool, buildingMaterial, or householdEquipment) must be set.");
        }
    }

    @Transient
    public BigDecimal getGrossPrice() {
        return netPrice.multiply(BigDecimal.valueOf(1 + vatRate));
    }

    @Override
    public BuildingMaterial asBuildingMaterial() {
        if (buildingMaterial == null) {
            throw new IllegalStateException("Product is not a building material");
        }
        return buildingMaterial;
    }

    @Override
    public HouseholdEquipment asHouseholdEquipment() {
        if (householdEquipment == null) {
            throw new IllegalStateException("Product is not a household equipment");
        }
        return householdEquipment;
    }

    @Override
    public Tool asTool() {
        if (tool == null) {
            throw new IllegalStateException("Product is not a tool");
        }
        return tool;
    }
}
