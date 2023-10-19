package com.newnrg.springjavafxclient.presentation.authorization;

public interface AuthorizationContract {

    interface View {

    }

    interface Model {

    }

    interface Presenter {
        void login(String userName, String password);

        void registration();
    }
}
