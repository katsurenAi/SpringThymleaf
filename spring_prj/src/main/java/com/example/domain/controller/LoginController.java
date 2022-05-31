package com.example.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@RestController
@RequestMapping(value="/login")
public class LoginController {
    @GetMapping
    public ModelAndView login(ModelAndView mav) {
        return mav;
    }
	/**
	 * メインページに遷移する。
	 * ログインが成功した場合、このメソッドが呼び出される。
	 */
	@RequestMapping("/index")
	public String login(Model model) {

		//メインページ。
		return "index";
	}

}