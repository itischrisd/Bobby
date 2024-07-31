package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrderAndCompanySubclassValidator.class)
public @interface OrderAllowedIfCompanyIsNotSupplier {
    String message() default "Invoice can be for an order only if company is not a supplier";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
