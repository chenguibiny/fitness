package com.ocean.validator;

import com.ocean.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required) {
            return ValidatorUtil.isMobile(s);
        } else {
            if(StringUtils.isEmpty(s)) {
                return true;
            }else {
                return ValidatorUtil.isMobile(s);
            }
        }
    }
}
