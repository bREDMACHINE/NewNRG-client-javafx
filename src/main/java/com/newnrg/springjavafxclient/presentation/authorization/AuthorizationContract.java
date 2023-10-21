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
        void authorization(String userName, String password);

        void registration();
    }

    interface Memory {

        User getUser();

        Boolean saveUser(User user);
    }
}
