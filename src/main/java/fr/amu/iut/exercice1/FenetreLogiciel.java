package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {

        // === MENU ===

        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");

        menuFile.getItems().addAll(
                new MenuItem("New"),
                new SeparatorMenuItem(),
                new MenuItem("Open"),
                new SeparatorMenuItem(),
                new MenuItem("Save"),
                new SeparatorMenuItem(),
                new MenuItem("close")
        );
        menuEdit.getItems().addAll(
                new MenuItem("Cut"),
                new SeparatorMenuItem(),
                new MenuItem("Copy"),
                new SeparatorMenuItem(),
                new MenuItem("Paste")
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        // === Panneau gauche ===
        VBox leftButtons = new VBox(10);
        leftButtons.setPadding(new Insets(10));
        leftButtons.setAlignment(Pos.CENTER_LEFT);
        leftButtons.getChildren().addAll(
                new Label("Boutons :"),
                new Button("Bouton 1"),
                new Button("Bouton 2"),
                new Button("Bouton 3")
        );

        // == Formulaire ==
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(10);
        form.add(new Label("Name:"), 0, 0);
        form.add(new TextField(), 1, 0);

        form.add(new Label("Email:"), 0, 1);
        form.add(new TextField(), 1, 1);

        form.add(new Label("Password:"), 0, 2);
        form.add(new PasswordField(), 1, 2);

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(new Button("Submit"), new Button("Cancel"));
        form.add(buttons, 1, 3);


        //=== Label du bas ===

        Label labelBas = new Label("Ceci est un label de bas de page");
        BorderPane.setAlignment(labelBas, Pos.CENTER);
        BorderPane.setMargin(labelBas, new Insets(5));

        // === MISE EN PAGE ===

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(leftButtons);
        root.setCenter(form);
        root.setBottom(labelBas);

        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        Scene scene = new Scene(root, 600, 400); // largeur et hauteur
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

