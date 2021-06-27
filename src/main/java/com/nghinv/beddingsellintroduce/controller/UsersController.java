package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.ClientFrom.UserDtoListForm;
import com.nghinv.beddingsellintroduce.common.Dto.UsersDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UsersController {

    static ArrayList<UsersDto> list = new ArrayList<>();

    static {
//        UsersDto user2 = new UsersDto( true, 2, "name2", "login2", "pass2", "phone2");
//        list.add(user2);
//
//        UsersDto user3 = new UsersDto(false,3, "name3", "login3", "pass3", "phone3");
//        list.add(user3);

        UsersDto user2 = new UsersDto(true, 2, "name2", "login2", "pass2", "phone2");
        list.add(user2);

        UsersDto user3 = new UsersDto(false, 3,  "name3", "login3", "pass3", "phone3");
        list.add(user3);

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
    public String addUserPost(@ModelAttribute("user")@Valid UsersDto user, BindingResult result,
                              HttpServletRequest request,
                              Model model,
                              RedirectAttributes redirectAttributes
                              ) {

        if (result.hasErrors()) {

            return "/user/addUser";
        }
        // model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);

        // persisting the user
        return "redirect:/user/index";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    public String updateUserGet(@Valid @PathVariable Integer id) {

        int ii = 0;
        for (ii = 0; ii < list.size(); ii++) {
            if (list.get(ii).getUserId().equals(id)) {
                list.get(ii).setUserName(
                        list.get(ii).getUserName() + id.toString()
                );
            }
        }

        // persisting the user
        return "redirect:/user/index";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@Valid @RequestParam(required=false, name="id") Integer id,
                             @Valid @RequestParam(required=false, name="action") String action) {

        int ii;
        ArrayList<UsersDto> userList = new ArrayList<>();

        for (ii = 0; ii < list.size(); ii++) {
            if (!list.get(ii).getUserId().equals(id)) {
                userList.add(list.get(ii));
            }
        }
        list = userList;
        // persisting the user
        return "redirect:/user/index";
    }

    @GetMapping("/index")
    public String index(Model model, RedirectAttributes redirectAttributes) {
        UserDtoListForm form = new UserDtoListForm();
        Object userList = model.getAttribute("users");
        if (userList != null) {
            List<UsersDto> users = (List<UsersDto>)userList;
            form.setUserList(users);
        }
        else {
            form.setUserList(list);
        }
        model.addAttribute("form", form);
        return "/user/index"; // Trả về file index.html
    }


    @RequestMapping(value = "/deleteAllUser", method = RequestMethod.POST)
    public String deleteAllUser(
                        // @Valid
//                        @RequestParam("form") UserDtoListForm form,
                        @ModelAttribute("userList") List<UsersDto> userList,
                        String action,
                        BindingResult result,
                        HttpServletRequest request,
                        Model model,
                        RedirectAttributes redirectAttributes) {

        // persisting the user
        return "redirect:/user/index";
    }

    // Nếu người dùng request tới địa chỉ "/"
    @GetMapping("/")
    public String index2(Model model) {

        UserDtoListForm form = new UserDtoListForm();
        form.setUserList(list);
        model.addAttribute("form", form);

        return "/user/index222222222222222"; // Trả về file index.html
    }

    @RequestMapping(value = "/deleteAllUser222222", method = RequestMethod.POST)
    public String deleteAllUser222222(
            // @Valid
            @ModelAttribute UserDtoListForm form,
            String action,
            BindingResult result,
            HttpServletRequest request,
            Model model,
            RedirectAttributes redirectAttributes) {

        boolean check = form.getUserList() == null;
        System.out.println("----------");
        System.out.println(check);
        System.out.println("----------");
        return "redirect:/user/";
    }

    @GetMapping("/addMultiUser")
    public String addMultiUser(Model model) {

        UserDtoListForm form = new UserDtoListForm();
        for ( int ii = 0; ii < 2; ii++) {
            form.addUserDto(new UsersDto());
        }

        model.addAttribute("form", form);

        return "/user/addMultiUser"; // Trả về file addMultiUseraddMultiUser.html
    }

    @PostMapping("/addMultiUser")
    public String addMultiUserPost(@ModelAttribute UserDtoListForm form,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {

        boolean check = form.getUserList() == null;
        System.out.println(check);

        redirectAttributes.addFlashAttribute("users", form.getUserList());

        return "redirect:/user/index";
    }



    @PostMapping("/editMultiUserGetList")
    public String editMultiUser(@ModelAttribute UserDtoListForm form,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        if (form.getUserList() != null && form.getUserList().size() > 0) {
            for ( int ii = 0; ii < form.getUserList().size(); ii++) {
                System.out.println(form.getUserList().get(ii).getUserId());
            }
        }
        else {
            for ( int ii = 0; ii < 2; ii++) {
                form.addUserDto(new UsersDto());
            }
        }

        model.addAttribute("form", form);

        return "/user/editMultiUser";
    }

    @PostMapping("/editMultiUser")
    public String editMultiUserPost(@ModelAttribute UserDtoListForm form,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {

        boolean check = form.getUserList() == null;
        System.out.println(check);

        redirectAttributes.addFlashAttribute("users", form.getUserList());

        return "redirect:/user/index"; // Trả về file addMultiUseraddMultiUser.html
    }

}
