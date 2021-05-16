package com.inditex.robert.commerce.util.exceptions;

import com.inditex.robert.commerce.util.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundExceptions extends CommerceExceptions{

    public NotFoundExceptions(final String code, final String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }
    public NotFoundExceptions(final String code, final String message, ErrorDto data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }

}
