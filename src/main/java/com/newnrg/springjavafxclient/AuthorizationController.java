package com.newnrg.springjavafxclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("authorization-controller.fxml")
public class AuthorizationController {

    private AuthorizationService authorizationService;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordText;
    private User user;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        user = authorizationService.authorization(new UserDto(loginText.getText(), passwordText.getText()));
    }

    @FXML
    public void registration(ActionEvent actionEvent) {
    }

    public User getUser() {
        return user;
    }
}
