package com.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {
    private int messageId;
    private String messageTitle;
    private String messageDetail;
    private String submitAccount;
}
