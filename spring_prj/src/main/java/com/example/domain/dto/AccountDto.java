package com.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
    private int id;
    private String tweetText;
    private String imageData;
    private String imagePath;
    private String accountDetails;//追加　アカウントの詳細
}
