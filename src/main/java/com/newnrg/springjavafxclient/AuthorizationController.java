package com.newnrg.springjavafxclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private VBox dialog;

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

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));

        closeButton.setOnAction(
                actionEvent -> stage.close()
        );
    }

    public void show() {
        stage.show();
    }
}
