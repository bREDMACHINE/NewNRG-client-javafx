package com.newnrg.springjavafxclient.presentation.view;

import com.newnrg.springjavafxclient.presentation.model.AuthorizationService;
import com.newnrg.springjavafxclient.presentation.model.User;
import com.newnrg.springjavafxclient.presentation.model.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("authorization-controller.fxml")
public class AuthorizationViewController {

    private AuthorizationService authorizationService;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordText;
    private Stage stage;
    @FXML
    private VBox window;

    @Autowired
    public AuthorizationViewController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        User user = authorizationService.authorization(new UserDto(loginText.getText(), passwordText.getText()));
    }

    @FXML
    public void registration(ActionEvent actionEvent) {
    }

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(window));
        stage.setTitle("НОВАЯ ЭНЕРГИЯ");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void show() {
        stage.show();
    }
}
