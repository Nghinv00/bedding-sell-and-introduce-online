package com.nghinv.beddingsellintroduce.common.validator;


import com.nghinv.beddingsellintroduce.common.dto.MembersDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Validator;

//@NoArgsConstructor
//@AllArgsConstructor
//@Component("memberValidator")
public class MembersValidator  implements Validator {

    /**
     * This Validator validates Member instances, and any subclasses of Customer too
     */
    public boolean supports(Class<?> clazz) {
        return MembersDto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO:
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "MemberName", "MembersDto.MemberName");

        MembersDto member = (MembersDto) target;
        if (null == member.getMemberId() || (null != member.getMemberId() && member.getMemberId() <= 1)) {
            errors.rejectValue("MemberId", "MembersDto.MemberId", "Please enter a MemberId > 1 interface");
        }

        if (null == member.getMemberLogin() || (null != member.getMemberLogin() && member.getMemberLogin().length() > 1)) {
            errors.rejectValue("MemberLogin", "MembersDto.MemberLogin","Please enter a MemberLogin interface");
        }

        if (null == member.getPassword() || (null != member.getPassword() && member.getPassword().length() < 1)) {
            errors.rejectValue("Password", "MembersDto.Password","Please enter a Password interface");
        }
    }


//    Khi muon su dung laij code cua membervalidator thi dung doan code nay
//    private final Validator usersValidator;
//
//    public MembersValidator(Validator usersValidator) {
//        if (usersValidator == null) {
//            throw new IllegalArgumentException(
//                    "The supplied [Validator] is required and must not be null.");
//        }
//
//        if (!((UsersValidator) usersValidator).supports(UsersDto.class)) {
//            throw new IllegalArgumentException(
//                    "The supplied [Validator] must support the validation of [UserDto] instances.");
//        }
//        this.usersValidator = usersValidator;
//    }

}
