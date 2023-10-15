package com.newnrg.springjavafxclient;

import com.newnrg.springjavafxclient.application.JavafxClientNewNRG;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJavafxClientApplication {

	public static void main(String[] args) {
		Application.launch(JavafxClientNewNRG.class, args);
	}

}
