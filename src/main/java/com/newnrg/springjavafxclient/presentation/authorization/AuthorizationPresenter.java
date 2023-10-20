package com.newnrg.springjavafxclient.presentation.authorization;

import com.newnrg.springjavafxclient.presentation.model.AuthorizationService;
import com.newnrg.springjavafxclient.presentation.model.User;
import com.newnrg.springjavafxclient.presentation.model.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    private final AuthorizationContract.Model model;
    private final AuthorizationContract.View view;
    private final AuthorizationContract.UserStorage userStorage;


//    @Autowired
//    public AuthorizationPresenter(AuthorizationContract.View view) {
//        this.model = new AuthorizationService();
//        this.view = view;
//    }

    @Override
    public void login(String userName, String password) {
        User user = model.authorization(new UserAuth(userName, password));
        if (user != null) {
            userStorage.saveUser(user);
            view.close();
        }
    }

    @Override
    public void registration() {
       // registrationPresenter.getController().show();
    }
}
