package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.client.GuestClient;
import pl.edu.pja.s25692.bobby.model.client.IndividualClient;
import pl.edu.pja.s25692.bobby.model.client.RegisteredClient;
import pl.edu.pja.s25692.bobby.model.client.RegularClient;

public class IndividualClientSubtypeValidator implements ConstraintValidator<OnlyOneClientType, IndividualClient> {
    @Override
    public void initialize(OnlyOneClientType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(IndividualClient value, ConstraintValidatorContext context) {
        GuestClient guest = value.asGuestClient();
        RegisteredClient registered = value.asRegisteredClient();
        RegularClient regular = value.asRegularClient();

        if (guest != null) {
            return registered == null && regular == null;
        } else if (registered != null) {
            return regular == null;
        } else {
            return true;
        }
    }
}
