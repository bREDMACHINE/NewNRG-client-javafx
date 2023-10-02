package com.newnrg.springjavafxclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavafxClientNewNRG extends Application {

    private ConfigurableApplicationContext context;
    private boolean isUserLoggedIn = false;
    private FxWeaver fxWeaver = context.getBean(FxWeaver.class);
    private Stage stageMain;
    private Stage stageAuthorization;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.context = new SpringApplicationBuilder()
                .sources(SpringJavafxClientApplication.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.context.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stageMain) throws Exception {
        this.stageMain = stageMain;
        initMainWindow();
        initAuthorizationWindow();
    }

    private void initMainWindow() {
        Parent root = fxWeaver.loadView(MainController.class);
        Scene scene = new Scene(root);
        stageMain.setScene(scene);
        stageMain.setTitle("НОВАЯ ЭНЕРГИЯ");
        stageMain.getIcons().add(new Image("file:icon.png"));
        stageMain.show();
    }

    private void initAuthorizationWindow() {
        stageAuthorization = new Stage();
        stageAuthorization.initModality(Modality.APPLICATION_MODAL);
        Parent root = fxWeaver.loadView(AuthorizationController.class);
        Scene scene = new Scene(root);
        stageAuthorization.setScene(scene);
        stageAuthorization.show();
    }
}
