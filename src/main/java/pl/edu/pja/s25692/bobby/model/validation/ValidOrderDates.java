package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrderDatesValidator.class)
public @interface ValidOrderDates {
    String message() default "Order's expected delivery date must be after order's creation date";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
