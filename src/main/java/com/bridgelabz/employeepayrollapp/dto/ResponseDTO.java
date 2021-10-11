package com.bridgelabz.employeepayrollapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;
}