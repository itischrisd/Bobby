package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.employee.Intern;

public class InternDatesValidator implements ConstraintValidator<ValidInternDates, Intern> {
    @Override
    public void initialize(ValidInternDates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Intern value, ConstraintValidatorContext context) {
        return value.getHireDate().isBefore(value.getInternshipEndDate());
    }
}
