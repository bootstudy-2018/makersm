package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevController {
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("result", "dev");

        return "test";
    }
}
