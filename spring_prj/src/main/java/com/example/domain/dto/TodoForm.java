package com.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoForm {
    //編集するid
    private int id;
    //編集投稿された本文
    private String updateBodytext;
}
