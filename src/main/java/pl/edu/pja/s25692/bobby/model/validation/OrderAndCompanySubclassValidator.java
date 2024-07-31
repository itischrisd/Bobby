package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.company.Company;
import pl.edu.pja.s25692.bobby.model.company.Supplier;
import pl.edu.pja.s25692.bobby.model.order.Invoice;
import pl.edu.pja.s25692.bobby.model.order.Order;

public class OrderAndCompanySubclassValidator implements ConstraintValidator<OrderAllowedIfCompanyIsNotSupplier, Invoice> {
    @Override
    public void initialize(OrderAllowedIfCompanyIsNotSupplier constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Invoice value, ConstraintValidatorContext context) {
        Order order = value.getOrder();
        Company company = value.getCompany();

        if (order != null && company != null) {
            return !(company instanceof Supplier);
        }

        return true;
    }
}
