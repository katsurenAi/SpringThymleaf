package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.domain.form.SignUpForm;
import com.example.domain.service.SignUpService;
import com.example.domain.entity.UserEntity;

    /**
    * 会員登録をするクラス
    */

@RestController
@RequestMapping(value="/signup")
public class SignUpController {

    @Autowired
    private SignUpService signupService;

    //会員登録の画面を表示
    @GetMapping
    public ModelAndView signup(ModelAndView mav) {
        return mav;
    }

    //会員登録ボタンを押された後の処理
    @PostMapping
    public ModelAndView signup(@ModelAttribute SignUpForm signupForm, ModelAndView mav) {
		//USERテーブルにinsertする時の引数。
		UserEntity entity = new UserEntity();
        //Formの値をUserEntityの型にセットする
		entity.setLoginid(signupForm.getLoginid());
		entity.setPassword(signupForm.getPassword());
		//サービスクラスでDBに登録する
		signupService.save(entity);
        //ログイン画面へ移動
        mav.setViewName("login");
        return mav;
    }
}