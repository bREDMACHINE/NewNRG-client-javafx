package com.newnrg.springjavafxclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrameController {

    private final AuthorizationFrameController authorizationFrameController;
    private final MainFrameController mainFrameController;

    @Autowired
    public FrameController (AuthorizationFrameController authorizationFrameController,
                            MainFrameController mainFrameController) {
        this.authorizationFrameController = authorizationFrameController;
        this.mainFrameController = mainFrameController;


    }


}
