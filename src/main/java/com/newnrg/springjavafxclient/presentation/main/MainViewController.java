package com.newnrg.springjavafxclient.presentation.main;

import com.newnrg.springjavafxclient.presentation.authorization.AuthorizationView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-controller.fxml")
public class MainViewController {

    private final FxControllerAndView<AuthorizationView, VBox> authorizationController;

    @FXML
    public Button openAuthorButton;

    @Autowired
    public MainViewController(FxControllerAndView<AuthorizationView, VBox> authorizationController) {
        this.authorizationController = authorizationController;
    }

    @FXML
    public void initialize() {
        openAuthorButton.setOnAction(
                actionEvent -> authorizationController.getController().show()
        );
    }

}
