package pl.edu.pja.s25692.bobby.model.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.edu.pja.s25692.bobby.model.service.Reservation;
import pl.edu.pja.s25692.bobby.model.validation.EmlpoyeeHasOneDutyType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@EmlpoyeeHasOneDutyType
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Surname cannot be null or empty")
    @Size(min = 2, max = 100, message = "Surname must be between 2 and 100 characters")
    private String surname;

    @NotBlank(message = "Card number cannot be null or empty")
    @Size(min = 8, max = 8, message = "Card number must be 8 characters long")
    @Column(unique = true)
    private String employeeNumber;

    @NotBlank(message = "PESEL cannot be null or empty")
    @PESEL(message = "PESEL must be valid")
    private String PESEL;

    @NotNull(message = "Hire date cannot be null")
    @PastOrPresent(message = "Hire date must be in the past or present")
    private LocalDate hireDate;

    @NotBlank(message = "Phone number cannot be null or empty")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "Phone number must be in format XXX-XXX-XXX")
    private String phoneNumber;

    @NotNull(message = "Duty type cannot be null")
    @Column(updatable = false)
    @Enumerated(EnumType.STRING)
    private DutyType dutyType;

    @ElementCollection
    @CollectionTable(name = "employee_harmful_factor", joinColumns = @JoinColumn(name = "employee_id"))
    @Builder.Default
    private Set<String> harmfulFactors = null;

    @Builder.Default
    private Boolean isEligibleForGlassesRefund = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Position cannot be null")
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations = new HashSet<>();

    @Transient
    public LocalDate getBirthDate() {
        return LocalDate.of(Integer.parseInt(PESEL.substring(0, 2)), Integer.parseInt(PESEL.substring(2, 4)), Integer.parseInt(PESEL.substring(4, 6)));
    }

    public enum DutyType {
        BLUE_COLLAR,
        WHITE_COLLAR
    }
}
