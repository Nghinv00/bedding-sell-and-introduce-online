package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.Dto.UsersDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UsersController {

    @GetMapping("/index") // Nếu người dùng request tới địa chỉ "/"
    public String index(Model model, RedirectAttributes redirectAttributes) {

        UsersDto user = (UsersDto) redirectAttributes.getAttribute("user");
        if (user == null) {
            user.setPassword("1");
            user = new UsersDto();
//            throw new RuntimeException();
        }
        model.addAttribute("user", user);
        // redirectAttributes.addFlashAttribute("user", user);

        return "/user/index"; // Trả về file index.html
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserGet(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UsersDto());
        }

        // persisting the user
        return "/user/addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user")@Valid UsersDto user, BindingResult result, // @Validate
                              HttpServletRequest request,
                              Model model,
                              RedirectAttributes redirectAttributes
                              ) {

        // model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);

        // persisting the user
        return "/user/index";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUserGet(@ModelAttribute("user")@Valid UsersDto user, BindingResult result, // @Validate
                                HttpServletRequest request,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UsersDto());
        }

        // persisting the user
        return "/user/addUser";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user")@Valid UsersDto user, BindingResult result, // @Validate
                              HttpServletRequest request,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        // model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);

        // persisting the user
        return "/user/index";
    }
}
