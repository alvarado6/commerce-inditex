package com.inditex.robert.commerce.util.respoonse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommerceResponse<T> {

    private String status;
    private String code;
    private String message;
    private T data;

}
