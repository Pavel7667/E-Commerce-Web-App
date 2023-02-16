package com.pavelhnelytcia.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AdminController class for navigation in the administrative part of the site, which include
 * <p>Main adminHome page.
 * <p>Page for adding categories.
 * <p>Page for adding product.
 */
@Controller
public class AdminController {



    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }


}
