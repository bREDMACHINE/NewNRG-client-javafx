package com.newnrg.springjavafxclient.presentation.authorization;

import com.newnrg.springjavafxclient.presentation.model.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    private AuthorizationContract.Model model;
    private AuthorizationContract.View view;


    @Autowired
    public AuthorizationPresenter(AuthorizationContract.View view) {
        this.model = new AuthorizationService();
        this.view = view;
    }

    @Override
    public void login(String userName, String password) {

    }

    @Override
    public void registration() {
       // registrationPresenter.getController().show();
    }
}
