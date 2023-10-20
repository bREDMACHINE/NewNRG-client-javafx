package com.newnrg.springjavafxclient.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserAuth {

    @NotBlank
    @Email
    private String userName;
    @NotBlank
    private String userPassword;
}
