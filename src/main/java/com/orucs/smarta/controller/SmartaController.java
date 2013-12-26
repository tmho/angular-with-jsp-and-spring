package com.orucs.smarta.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SmartaController {

    @RequestMapping(value="/")
    public String index() {
        return "new";
    }
}
