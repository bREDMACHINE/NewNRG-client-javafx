package com.newnrg.springjavafxclient.presentation.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.StringReader;

public class UserMapper {

    public static User toUser(Object object, String userName) {
        JsonObject jsonObject = JsonParser.parseReader(new StringReader(object.toString()))
                .getAsJsonObject();
        return User.builder()
                .userName(userName)
                .userRole(Role.valueOf(jsonObject.get("Role").getAsString()))
                .userId(jsonObject.get("Token").getAsString())
                .build();
    }
}
