package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.dto.Demo;
import com.nghinv.beddingsellintroduce.common.dto.MemberRestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/memberrest")
public class MemberRestController {


    @Autowired
    @Qualifier("memberRestValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/")
    public ResponseEntity<MemberRestDto> index2(Model model) {
        MemberRestDto member = new MemberRestDto();
        member.setMemberGuiId("abcdef");
        member.setMemberId(2);
        member.setMemberName("Nguyen Van A");
        member.setMemberLogin("ABC");
        member.setPassword("DEF");
        return new ResponseEntity<MemberRestDto>(member, HttpStatus.OK);
    }

    @GetMapping("/index") // Nếu người dùng request tới địa chỉ "/index"
    public ResponseEntity<MemberRestDto> index(Model model) {
        MemberRestDto member = new MemberRestDto();
        member.setMemberGuiId("abcdef");
        member.setMemberId(2);
        member.setMemberName("Nguyen Van A");
        member.setMemberLogin("ABC");
        member.setPassword("DEF");
        return  new ResponseEntity<MemberRestDto>(member, HttpStatus.OK);
    }


    @GetMapping("/getMemberById/{id}")
    @ResponseBody
    public MemberRestDto getMemberById(@PathVariable @Min(1) Integer id) {

        MemberRestDto member = new MemberRestDto();
        member.setMemberGuiId("abcdef");
        member.setMemberId(id);
        member.setMemberName("Nguyen Van A");
        member.setMemberLogin("ABC");
        member.setPassword("DEF");
        return member;
    }


    @GetMapping("/getMemberByIdv3/{id}")
    public @ResponseBody String getMemberByIdv3(@PathVariable @Min(1) Integer id) {
        return "member";
    }

    @GetMapping("/getMemberById?id={id}")
    public MemberRestDto getMemberByIdv2(@PathVariable @Min(1) Integer id) {

        MemberRestDto member = new MemberRestDto();
        member.setMemberGuiId("abcdef");
        member.setMemberId(id);
        member.setMemberName("Nguyen Van A");
        member.setMemberLogin("ABC");
        member.setPassword("DEF");
        return  member;
    }

    @RequestMapping(value = "/restaddmemberv2", method = RequestMethod.POST)
    public MemberRestDto restaddmemberv2(String age) {
        //save to DB or ?
        MemberRestDto member = new MemberRestDto();
        member.setMemberGuiId(age);
        member.setMemberId(11);
        member.setMemberName("Nguyen Van A");
        member.setMemberLogin("ABC");
        member.setPassword("DEF");
        return  member;
    }

    @RequestMapping(value = "/restaddmemberv3", method = RequestMethod.POST)
    public ResponseEntity<MemberRestDto> restaddmemberv3(MemberRestDto member) {

        System.out.println(member.getMemberGuiId());
        System.out.println(member.getMemberId());
        member.setMemberId(member.getMemberId() + 1);
        //save to DB or ?

        return new ResponseEntity<MemberRestDto>(member, HttpStatus.OK);
    }

    @RequestMapping(value = "/restaddmemberv4", method = RequestMethod.POST)
    public ResponseEntity<Demo> restaddmemberv4(@Valid @RequestBody Demo demo) {

        return new ResponseEntity<Demo>(demo, HttpStatus.OK);
    }

    // TODO:
    @RequestMapping(value = "/restupdatemember", method = RequestMethod.POST)
    public ResponseEntity<MemberRestDto> restupdatemember(
            @RequestBody MemberRestDto member) {

        System.out.println(member.getMemberGuiId());

        //save to DB or ?

        return new ResponseEntity<MemberRestDto>(member, HttpStatus.OK);
    }

    // TODO:
    @RequestMapping(value = "/restupdatememberv2", method = RequestMethod.POST)
    public ResponseEntity<MemberRestDto> restupdatememberv2(
           @Valid @RequestBody MemberRestDto member) {

        System.out.println(member.getMemberGuiId());

        //save to DB or ?

        return ResponseEntity.ok().body(member);

       //  return new ResponseEntity<MemberRestDto>(member, HttpStatus.OK);
    }
}
