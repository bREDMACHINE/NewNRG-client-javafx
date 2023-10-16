package com.newnrg.springjavafxclient.data.storage;

import com.newnrg.springjavafxclient.data.storage.models.User;
import com.newnrg.springjavafxclient.domain.models.UserDto;

public interface UserStorage {

    User getUser();

    Boolean saveUser(User user);
}
