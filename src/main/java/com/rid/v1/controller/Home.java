package com.rid.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home {

    @GetMapping("/")
    public String Home() {
        return "redirect:/swagger-ui.html";
    }


}
