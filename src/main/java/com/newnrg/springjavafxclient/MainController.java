package com.newnrg.springjavafxclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-controller.fxml")
public class MainController {

    private final FxControllerAndView<AuthorizationController, VBox> authorizationController;

    @FXML
    public Button openDialogButton;

    public MainController(FxControllerAndView<AuthorizationController, VBox> authorizationController) {
        this.authorizationController = authorizationController;
    }

    @FXML
    public void initialize() {
        openDialogButton.setOnAction(
                actionEvent -> authorizationController.getController().show()
        );
    }

}
