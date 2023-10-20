package com.newnrg.springjavafxclient.presentation.authorization;

import com.newnrg.springjavafxclient.presentation.model.User;
import com.newnrg.springjavafxclient.presentation.model.UserAuth;

public interface AuthorizationContract {

    interface View {

        void close();
    }

    interface Model {

        User authorization(UserAuth userAuth);
    }

    interface Presenter {
        void login(String userName, String password);

        void registration();
    }

    interface UserStorage {

        User getUser();

        Boolean saveUser(User user);
    }
}
