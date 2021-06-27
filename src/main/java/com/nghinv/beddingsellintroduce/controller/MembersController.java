package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.Dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.Validator;

@Controller
@RequestMapping("member")
public class MembersController extends BaseController {

    @Autowired
    @Qualifier("memberValidator")
    private Validator validator;


    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
    public String index2(Model model) {

        return "member/index"; // Trả về file index.html
    }

    @GetMapping("/index") // Nếu người dùng request tới địa chỉ "/index"
    public String index(Model model) {

        if (model.getAttribute("errorMessage") != null) {
            // test message
            String mess = (String)model.getAttribute("errorMessage");
            model.addAttribute("errorMessage",mess );
        }
        else {
            // test message
            model.addAttribute("errorMessage", "Index.html");
        }

        return "member/index"; // Trả về file index.html
    }

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public String reLoad(Model model) {

        return "redirect:/member/index";
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.GET)
    public String addMember(Model model) {

        MembersDto member = new MembersDto();
        if (model.getAttribute("member") == null) {
            member.setMemberGuiId("abcdef");
            member.setMemberId(1);
            member.setMemberName("Nguyen Van A");
            member.setMemberLogin("ABC");
            member.setPassword("DEF");
        }
        else {
            member = (MembersDto)model.getAttribute("member");
            Object error = model.getAttribute("error");

        }
        model.addAttribute("member", member);
        return "/member/addMember";
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("member")@Valid MembersDto member,
                              BindingResult result, // @Validate
                              HttpServletRequest request,
                              Model model,
                              RedirectAttributes redirectAttributes,
                              BindingResult result1
    ) {

        if (null != result && result.hasErrors()) {
//            TODO:
            return "member/addMember";
        }

        redirectAttributes.addFlashAttribute("member", member);

        // persisting the user
        return "redirect:/member/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model, RedirectAttributes redirectAttributes) {


        MembersDto member = new MembersDto();
        if (model.getAttribute("member") == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "success.html");
            return "redirect:/member/index";
        }
        else {
            member = (MembersDto) model.getAttribute("member");
            model.addAttribute("member", member);
            model.addAttribute("messageSuccess", "Congratulations! You are old enough to sign up for this site.");
            return "member/success";
        }
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.GET)
    public String updateUserGet(@ModelAttribute("member")@Valid MembersDto member, BindingResult result, // @Validate
                                HttpServletRequest request,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        model.addAttribute("member" , member);

        return "member/updateMember";
    }


    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("member")@Valid MembersDto member, BindingResult result, // @Validate
                                 HttpServletRequest request,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("member", member);

        // persisting the user
        return "redirect:/member/success";
    }

}
