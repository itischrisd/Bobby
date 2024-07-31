package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.order.Order;

public class OrderOwnerValidator implements ConstraintValidator<OnlyOneOrderOwner, Order> {
    @Override
    public void initialize(OnlyOneOrderOwner constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Order value, ConstraintValidatorContext context) {
        var individual = value.getIndividualClient();
        var corporate = value.getCorporateClient();

        return (individual == null) != (corporate == null);
    }
}
