package com.nghinv.beddingsellintroduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/member/index";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        return "redirect:/member/index";
    }
}
