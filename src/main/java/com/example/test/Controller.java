package com.example.test;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private Button HistoryButt;

    @FXML
    private TextField LoginButt;

    @FXML
    private PasswordField PasswordButt;

    @FXML
    private Button SettingsButt;

    @FXML
    private Button SignInButt;

    @FXML
    private Button TestButt;

    @FXML
    ImageView RayanImage1;

    @FXML
    void initialize() {
        SignInButt.setOnAction(event -> {
            System.out.println("Вы пока не можете пережить концовку");
        });

    }

}