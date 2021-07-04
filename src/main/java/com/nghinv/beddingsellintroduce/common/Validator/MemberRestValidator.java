package com.nghinv.beddingsellintroduce.common.validator;

import com.nghinv.beddingsellintroduce.common.dto.Demo;
import com.nghinv.beddingsellintroduce.common.dto.MemberRestDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//@Component("memberRestValidator")
public class MemberRestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberRestDto.class.isAssignableFrom(clazz) || Demo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO:

        if (target instanceof  MemberRestDto) {

            MemberRestDto member = (MemberRestDto) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "MemberName", "MembersDto.MemberName", "Please enter a MemberName");

            if (null == member.getMemberId() || (null != member.getMemberId() && member.getMemberId() <= 1)) {
                errors.rejectValue("MemberId", "MembersDto.MemberId", "Please enter a MemberId > 1 interface");
            }

            if (null == member.getMemberLogin() || (null != member.getMemberLogin() && member.getMemberLogin().length() < 1)) {
                errors.rejectValue("MemberLogin", "MembersDto.MemberLogin","Please enter a MemberLogin interface");
            }

            if (null == member.getPassword() || (null != member.getPassword() && member.getPassword().length() < 1)) {
                errors.rejectValue("Password", "MembersDto.Password","Please enter a Password interface");
            }
        }
        else {
            Demo demo = (Demo) target;
            System.out.println(demo.getId());
            System.out.println(demo.getName());
            if (demo.getId().length() < 1) {
                errors.rejectValue("id", "MembersDto.MemberName","Please enter a Id");
            }
        }

    }
}
