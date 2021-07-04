package com.nghinv.beddingsellintroduce.common.validator;
import com.nghinv.beddingsellintroduce.common.annotation.PhoneAnnotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneAnnotation, String> {



    @Override
    public void initialize(PhoneAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("\\d{10}");
    }
}
