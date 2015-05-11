package com.jbetfairng.exceptions;

public class LoginException extends Throwable {

    public LoginException(Exception ex) {
        super(ex.getMessage());
    }
}
