package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IndividualClientSubtypeValidator.class)
public @interface OnlyOneClientType {
    String message() default "Client must have only one subtype";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
