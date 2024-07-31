package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.order.Order;

public class OrderDatesValidator implements ConstraintValidator<ValidOrderDates, Order> {

    @Override
    public void initialize(ValidOrderDates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Order value, ConstraintValidatorContext context) {
        return value.getOrderDate().isBefore(value.getPlannedDeliveryDate());
    }
}
