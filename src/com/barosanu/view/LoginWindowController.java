package com.barosanu.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailAddressFied;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginButtonAction() {
        System.out.println("cliK!!");
    }
}
