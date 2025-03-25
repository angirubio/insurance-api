package com.example.insurance.company.validation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;

@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.TYPE})
public @interface ValidDateRange {
    String message() default "startDate cannot be after endDate";
}
