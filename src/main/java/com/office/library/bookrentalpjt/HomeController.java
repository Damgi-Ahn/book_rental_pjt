package com.office.library.bookrentalpjt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("[HomeController] home()");

        return "user/home";

    }

}
