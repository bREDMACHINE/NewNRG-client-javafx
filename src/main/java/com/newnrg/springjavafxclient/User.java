package com.newnrg.springjavafxclient;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String login;
    private String userId;
    private String role;
}
