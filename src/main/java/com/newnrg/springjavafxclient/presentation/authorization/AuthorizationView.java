package com.newnrg.springjavafxclient.presentation.authorization;

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
import org.springframework.stereotype.Component;

@Component
@FxmlView("authorization-view.fxml")
public class AuthorizationView implements AuthorizationContract.View {

    private AuthorizationContract.Presenter presenter;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordText;
    private Stage stage;
    @FXML
    private VBox window;

    @FXML
    public void authorization(ActionEvent actionEvent) {
        presenter.authorization(loginText.getText(), passwordText.getText());
    }

    @FXML
    public void registration(ActionEvent actionEvent) {
        presenter.registration();
    }

    @FXML
    public void initialize() {
        presenter = new AuthorizationContract.Presenter(this, new AuthorizationContract.Model());
        this.stage = new Stage();
        stage.setScene(new Scene(window));
        stage.setTitle("НОВАЯ ЭНЕРГИЯ");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void show() {
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
