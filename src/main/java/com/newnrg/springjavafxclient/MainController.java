package com.newnrg.springjavafxclient;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("main-controller.fxml")
public class MainController implements Initializable {


    private boolean isUserLoggedIn = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Stage stageAuthorization = new Stage();
//        stageAuthorization.initModality(Modality.APPLICATION_MODAL);
//        FXMLLoader loader = new FXMLLoader();
//        Parent root = fxWeaver.loadView(AuthorizationController.class);
//        Scene scene = new Scene(root);
//        stageAuthorization.setScene(scene);
//        stageAuthorization.show();
    }
}
