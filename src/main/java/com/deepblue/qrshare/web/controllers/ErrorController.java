package com.deepblue.qrshare.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("message", "The message");
        return "home";
    }
}
