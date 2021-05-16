package com.inditex.robert.commerce.util.exceptions;

import com.inditex.robert.commerce.util.dtos.ErrorDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommerceExceptions extends Exception{

    private final String code;
    private final int responseCode;
    private final List<ErrorDto> errorList = new ArrayList<>();

    public CommerceExceptions(final String code, final int responseCode, String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public CommerceExceptions(final String code, final int responseCode, final String message, List<ErrorDto> errorList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }
}
