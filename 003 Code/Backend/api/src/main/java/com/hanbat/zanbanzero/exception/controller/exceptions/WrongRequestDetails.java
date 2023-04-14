package com.hanbat.zanbanzero.exception.controller.exceptions;

import lombok.Getter;

@Getter
public class WrongRequestDetails extends RuntimeException{
    public WrongRequestDetails() {
    }

    public WrongRequestDetails(String message) {
        super(message);
    }
}