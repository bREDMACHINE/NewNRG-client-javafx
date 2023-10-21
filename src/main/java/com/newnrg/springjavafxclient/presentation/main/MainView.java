package com.newnrg.springjavafxclient.presentation.main;

import com.newnrg.springjavafxclient.presentation.authorization.AuthorizationView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-controller.fxml")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainView {

    private final FxControllerAndView<AuthorizationView, VBox> authorizationView;

    @FXML
    public Button openAuthorButton;

    @FXML
    public void initialize() {
        openAuthorButton.setOnAction(
                actionEvent -> authorizationView.getController().show()
        );
    }



}
