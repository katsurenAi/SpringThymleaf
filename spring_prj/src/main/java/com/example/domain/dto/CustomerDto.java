package com.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {
    private int CustmerId;
    private String Custmername;
    private String Custmeremail;
}
//    private Integer id;