package pl.edu.pja.s25692.bobby.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.edu.pja.s25692.bobby.model.employee.Employee;

import java.util.Set;

public class EmployeesDutyTypeValidator implements ConstraintValidator<EmlpoyeeHasOneDutyType, Employee> {
    @Override
    public void initialize(EmlpoyeeHasOneDutyType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Employee value, ConstraintValidatorContext context) {
        Employee.DutyType dutyType = value.getDutyType();
        Boolean isEligibleForGlassesRefund = value.getIsEligibleForGlassesRefund();
        Set<String> harmfulFactors = value.getHarmfulFactors();

        if (dutyType == Employee.DutyType.WHITE_COLLAR) {
            return isEligibleForGlassesRefund != null && harmfulFactors == null;
        } else if (dutyType == Employee.DutyType.BLUE_COLLAR) {
            return isEligibleForGlassesRefund == null && harmfulFactors != null;
        } else {
            return false;
        }
    }
}
