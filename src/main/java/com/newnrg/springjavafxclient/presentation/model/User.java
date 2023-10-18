package com.newnrg.springjavafxclient.presentation.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String userName;
    private Long userId;
    private Role userRole;
}
