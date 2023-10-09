package com.newnrg.springjavafxclient;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserDto {

    @NotBlank
    @Email
    private String login;
    @NotBlank
    private String password;
}
