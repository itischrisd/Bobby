package pl.edu.pja.s25692.bobby.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.edu.pja.s25692.bobby.model.validation.ValidInternDates;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ValidInternDates
public class Intern extends Employee {

    @NotNull(message = "Internship end date cannot be null")
    private LocalDate internshipEndDate;

    @Transient
    public LocalDate getInternshipStartDate() {
        return getHireDate();
    }
}
