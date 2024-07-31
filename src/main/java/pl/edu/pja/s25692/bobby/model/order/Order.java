package pl.edu.pja.s25692.bobby.model.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import pl.edu.pja.s25692.bobby.model.client.IndividualClient;
import pl.edu.pja.s25692.bobby.model.company.CorporateClient;
import pl.edu.pja.s25692.bobby.model.misc.Address;
import pl.edu.pja.s25692.bobby.model.product.Product;
import pl.edu.pja.s25692.bobby.model.validation.OnlyOneOrderOwner;
import pl.edu.pja.s25692.bobby.model.validation.ValidOrderDates;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@OnlyOneOrderOwner
@ValidOrderDates
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Order date cannot be null")
    @PastOrPresent(message = "Order date must be in the past or present")
    private LocalDate orderDate;

    @NotNull(message = "Planned delivery date cannot be null")
    @FutureOrPresent(message = "Planned delivery date must be in the present or future")
    private LocalDate plannedDeliveryDate;

    @NotNull(message = "Shipping cost cannot be null")
    @PositiveOrZero(message = "Shipping cost must be positive or zero")
    private BigDecimal shippingCost;

    @Pattern(regexp = "|\\S.*", message = "Comments cannot be empty")
    @Size(min = 3, max = 1000, message = "Comments must be between 3 and 1000 characters")
    private String comments;

    @OneToOne(cascade = CascadeType.REMOVE)
    @NotNull(message = "Address cannot be null")
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @NotNull(message = "Order status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Products cannot be empty")
    private Set<OrderElement> products = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "client_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private IndividualClient individualClient;

    @ManyToOne
    @JoinColumn(name = "corporate_client_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CorporateClient corporateClient;

    @Transient
    public BigDecimal getTotalCost() {
        if (products == null || products.isEmpty()) {
            throw new IllegalStateException("Order products were not initialized");
        }
        return products.stream()
                .map(OrderElement::getProduct)
                .map(Product::getGrossPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(shippingCost);
    }

    public enum Status {
        PLACED,
        PAID,
        IN_PROGRESS,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}
