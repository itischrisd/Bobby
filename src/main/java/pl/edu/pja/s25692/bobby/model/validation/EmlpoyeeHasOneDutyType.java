package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeesDutyTypeValidator.class)
public @interface EmlpoyeeHasOneDutyType {
    String message() default "Employee can have attributes of only one duty type";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
