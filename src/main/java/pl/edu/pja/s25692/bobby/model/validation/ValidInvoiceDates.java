package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InvoiceDatesValidator.class)
public @interface ValidInvoiceDates {
    String message() default "Invoice issue date must be before payment date";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
