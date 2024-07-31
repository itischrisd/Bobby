package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.order.Invoice;

public class InvoiceDatesValidator implements ConstraintValidator<ValidInvoiceDates, Invoice> {
    @Override
    public void initialize(ValidInvoiceDates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Invoice value, ConstraintValidatorContext context) {
        return value.getIssueDate().isBefore(value.getPaymentDate());
    }
}
