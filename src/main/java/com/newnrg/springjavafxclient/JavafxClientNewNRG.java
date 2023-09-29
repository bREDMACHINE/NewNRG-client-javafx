package com.newnrg.springjavafxclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavafxClientNewNRG extends Application {

    private ConfigurableApplicationContext context;

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
    public void start(Stage stage) throws Exception {
        FxWeaver fxWeaver = context.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(AuthorizationController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Авторизация");
        stage.show();
    }
}
