package com.newnrg.springjavafxclient.presentation.model;

import com.newnrg.springjavafxclient.presentation.model.User;

public interface UserStorage {

    User getUser();

    Boolean saveUser(User user);
}
