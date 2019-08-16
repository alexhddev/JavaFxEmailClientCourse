package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField emailAddressFied;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction!!");
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressFied.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult= loginService.getValue();
                switch (emailLoginResult) {
                    case SUCCESS:
                        System.out.println("login succesfull!!!" + emailAccount);
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                }

            });

        }


    }

    private boolean fieldsAreValid() {
        if(emailAddressFied.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
            return false;
        }

        return true;

    }
}
