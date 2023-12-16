package com.che300.app.Validator;


import com.che300.app.Utils.StringUtil;
import com.che300.app.annotation.PhoneValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName PhoneValidator.java
 * @Description TODO
 * @createTime 2023/12/14 00:06
 */
public class PhoneValidator implements ConstraintValidator<PhoneValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Add your phone number validation logic here
        return (!StringUtil.isEmpty(value)) && StringUtil.isMobile(value);
    }
}
