package com.newnrg.springjavafxclient.data.storage.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String userName;
    private Long userId;
    private Role userRole;
}
