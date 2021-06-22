package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.Dto.web.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// Đánh dấu đây là một Controller
// Nơi tiếp nhận các reqquest từ phía người dùng
@Controller
@RequestMapping("web")
public class WebController {

    // Đón nhận request GET
    @GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
    public String index(Model model) {
        // model.addAttribute("name", "NGHI");


//        Champion loda = Champion.builder()
//                .name("loda")
//                .type("Support")
//                .build();

        return "index"; // Trả về file index.html
    }

    // Đón nhận request GET
    @GetMapping("/index") // Nếu người dùng request tới địa chỉ "/"
    public String index1(Model model) {
        model.addAttribute("name", "NGHI");


//        Champion loda = Champion.builder()
//                .name("loda")
//                .type("Support")
//                .build();

        return "index"; // Trả về file index.html
    }

    @GetMapping("/profile")
    public String profileGet(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();

        profile.add(new Info("fullname", "Nguyễn Hoàng Nam"));
        profile.add(new Info("nickname", "lốddaf"));
        profile.add(new Info("gmail", "loda.namnh@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Info("website", "https://loda.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String profilePost(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();

        profile.add(new Info("fullname", "Nguyễn Van Nghi"));
        profile.add(new Info("nickname", "nghinv"));
        profile.add(new Info("gmail", "nghinv@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/nghinv"));
        profile.add(new Info("website", "https://nghinv.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }


    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public String profilePut(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();

        profile.add(new Info("fullname", "Put"));
        profile.add(new Info("nickname", "Put"));
        profile.add(new Info("gmail", "Put"));
        profile.add(new Info("facebook", "Put"));
        profile.add(new Info("website", "Put"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.DELETE)
    public String profileDelete(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();

        profile.add(new Info("delete", "Deleted"));


        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }

    // Đón nhận request GET
    @GetMapping("/about") // Nếu người dùng request tới địa chỉ "/about"
    public String about(Model model, @Valid @RequestParam(name = "about", required = true, defaultValue = "") String about) {
        model.addAttribute("about", about);
        return "about"; // Trả về file index.html
    }

    @GetMapping("/hello")
    public String hello(
            // Request param "name" sẽ được gán giá trị vào biến String
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            // Model là một object của Spring Boot, được gắn vào trong mọi request.
            Model model
    ) {

        if (name.isEmpty()) {
            model.addAttribute("name", "Invalid name");
            return "index"; // Trả về file index.html
        }
        // Gắn vào model giá trị name nhận được
        model.addAttribute("name", name);
        Object name1 = model.getAttribute("name");
        model.addAttribute("name1", name1);

        return "hello"; // trả về file hello.html cùng với thông tin trong object Model
    }

}
