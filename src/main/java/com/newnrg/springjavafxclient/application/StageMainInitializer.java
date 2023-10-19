package com.newnrg.springjavafxclient.application;

import com.newnrg.springjavafxclient.presentation.main.MainViewController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageMainInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Autowired
    public StageMainInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(MainViewController.class), 400, 300);
        stage.setScene(scene);
        stage.setTitle("НОВАЯ ЭНЕРГИЯ");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.show();
    }
}