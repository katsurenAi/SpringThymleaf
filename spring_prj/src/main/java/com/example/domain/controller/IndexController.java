package com.example.domain.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping(value="/index")
public class IndexController {
    @PostMapping
    public ModelAndView Index(ModelAndView mav) {
        return mav;

    }
}