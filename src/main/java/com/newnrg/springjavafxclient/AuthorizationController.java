package com.newnrg.springjavafxclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("authorization-controller.fxml")
public class AuthorizationController {

    private AuthorizationService authorizationService;
    @FXML
    private Text authorizationLabel;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @FXML
    public void logIn(ActionEvent actionEvent) {
        this.authorizationLabel.setText(authorizationService.authorization());
    }
}
