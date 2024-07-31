package pl.edu.pja.s25692.bobby.model.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pl.edu.pja.s25692.bobby.model.client.IndividualClient;
import pl.edu.pja.s25692.bobby.model.company.CorporateClient;
import pl.edu.pja.s25692.bobby.model.employee.Employee;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Number cannot be null or empty")
    @Size(min = 1, max = 10, message = "Number must be between 1 and 10 characters")
    @Column(unique = true)
    private String number;

    @NotNull(message = "Submission date cannot be null")
    private LocalDate submissionDate;

    @NotNull(message = "Planned start date cannot be null")
    private LocalDate plannedStartDate;

    @NotNull(message = "Reservation status cannot be null")
    @Enumerated(EnumType.STRING)
    private Reservation.Status status;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ReservationService> reservationService = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_client_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private IndividualClient individualClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporate_client_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CorporateClient corporateClient;

    public static void removeCancelledReservations(Set<Reservation> reservations) {
        reservations.removeIf(reservation -> reservation.getStatus() == Status.CANCELLED);
    }

    public void assignEmployee(Employee employee) {
        setEmployee(employee);
        employee.getReservations().add(this);
        setStatus(Status.ASSIGNED_TO_EMPLOYEE);
    }

    public void cancel() {
        getEmployee().getReservations().remove(this);
        setEmployee(null);
        setStatus(Status.CANCELLED);
    }

    public void confirm() {
        setStatus(Status.CONFIRMED);
    }

    public void markAsCompleted() {
        setStatus(Status.COMPLETED);
    }

    public enum Status {
        SUBMITTED,
        CANCELLED,
        ASSIGNED_TO_EMPLOYEE,
        CONFIRMED,
        COMPLETED
    }
}
