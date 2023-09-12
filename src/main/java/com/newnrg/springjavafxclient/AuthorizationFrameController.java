package com.newnrg.springjavafxclient;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationFrameController {
    private String user;

    public AuthorizationFrameController() {

    }

    public String getUser() {
        return user;
    }
}
