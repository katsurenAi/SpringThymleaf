package com.example.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

//会員登録フォームで入力される項目
@Data
public class SignUpForm {

    private String loginid;
    private String password;
}