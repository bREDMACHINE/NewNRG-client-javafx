package com.newnrg.springjavafxclient.presentation.authorization;

import com.newnrg.springjavafxclient.presentation.model.User;
import com.newnrg.springjavafxclient.presentation.model.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    private final AuthorizationContract.Model model;
    private final AuthorizationContract.View view;
    private final AuthorizationContract.Memory memory;

    @Override
    public void authorization(String userName, String password) {
        User user = model.authorization(new UserAuth(userName, password));
        if (user != null) {
            if (memory.saveUser(user)) {
                view.close();
            }
        }
    }

    @Override
    public void registration() {
       // registrationPresenter.getController().show();
    }
}
