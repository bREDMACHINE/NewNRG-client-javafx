package com.newnrg.springjavafxclient;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public String authorization() {
        return "Вы авторизованы";
    }
}
