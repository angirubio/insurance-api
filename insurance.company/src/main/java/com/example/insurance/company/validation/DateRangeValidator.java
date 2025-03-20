package com.example.insurance.company.validation;

import com.example.insurance.company.model.InsurancePolicy;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, InsurancePolicy>{

    @Override
    public boolean isValid(InsurancePolicy policy, ConstraintValidatorContext context) {
        if (policy.getStartDate() == null || policy.getEndDate() == null) {
            return true;
        }
        return !policy.getStartDate().isAfter(policy.getEndDate());
    }
    
}
