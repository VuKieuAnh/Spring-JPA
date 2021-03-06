package com.codegym.student.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "user/user";
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "user/admin";
    }

    @GetMapping("/accessDenied")
    public String error() {
        return "user/accessDenied";
    }
}
