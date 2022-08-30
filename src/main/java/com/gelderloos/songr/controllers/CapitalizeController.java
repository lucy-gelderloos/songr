package com.gelderloos.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CapitalizeController {

    @GetMapping("/capitalize/{toCapitalize}")
    public String capitalize(@PathVariable String toCapitalize, Model model) {
        model.addAttribute("toCapitalize", toCapitalize.toUpperCase());
        return "capitalize";
        }
    }
