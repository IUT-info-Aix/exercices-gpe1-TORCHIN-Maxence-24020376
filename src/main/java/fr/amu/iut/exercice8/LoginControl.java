package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.Optional;

public class LoginControl extends GridPane {

    @FXML
    private TextField username;

    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        if (username.getText().isEmpty() || pwd.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Fields");
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tout le formulaire");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Bienvenue");
            alert.show();

        }
    }
    @FXML
    private void cancelClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Vous voulez quitter le formulaire");
        alert.showAndWait();
    }
}