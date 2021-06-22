package com.nghinv.beddingsellintroduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;

@Controller
@RequestMapping("/baserest")
public class BaseRestController {

    @GetMapping("/")
    public String index2(Model model) {

        return "baserest/index";
    }

    @GetMapping("/index")
    public String index(Model model) {

        return "baserest/index";
    }
}
