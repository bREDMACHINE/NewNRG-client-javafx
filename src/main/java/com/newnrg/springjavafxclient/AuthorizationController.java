package com.newnrg.springjavafxclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@FxmlView("authorization-controller.fxml")
public class AuthorizationController {

    private AuthorizationService authorizationService;
    @FXML
    private Label authorizationLabel;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void logIn(ActionEvent actionEvent) {
        this.authorizationLabel.setText(authorizationService.authorization());
    }
}
