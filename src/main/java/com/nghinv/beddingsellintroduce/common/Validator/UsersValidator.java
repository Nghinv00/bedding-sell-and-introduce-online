package com.nghinv.beddingsellintroduce.common.Validator;

import com.nghinv.beddingsellintroduce.common.Dto.UsersDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Validator;

//@NoArgsConstructor
//@AllArgsConstructor
public class UsersValidator implements Validator {

    /**
     * This Validator validates *just* UsersDto instances
     */
    public boolean supports(Class clazz) {
        return UsersDto.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "UserId", "UserId.empty");
        UsersDto user = (UsersDto) obj;
        if (user.getUserLogin().length() > 50 ||
                user.getUserLogin().length() > 50 ||
                user.getPassword().length() > 50) {


        }


    }

}
