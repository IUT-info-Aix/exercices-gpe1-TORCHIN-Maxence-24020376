package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.util.Random;


public class TicTacToe extends Application {

    @Override
    public void start (Stage primaryStage){
        primaryStage.setTitle("Tic Tac Toe");

        Random random = new Random();

        // === Création  de la grille 3x3 ===
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // === Création des cellules du TicTacToe ===
        for (int row = 0; row < 3; row++) { // On parcours chaque rangée
            for (int col = 0; col < 3; col++) { // On parcours chaque colonne de cette rangée
                Label cell = new Label();
                cell.setPrefSize(80, 80); //Taille de base des cellules
                cell.setAlignment(Pos.CENTER);

                cell.setBorder(new Border(new BorderStroke(
                        Color.LIGHTGRAY,                   // couleur
                        BorderStrokeStyle.SOLID,           // style
                        CornerRadii.EMPTY,                 // arrondis
                        new BorderWidths(2)             // épaisseur
                )));

                // Choix aléatoire : 0=Croix, 1=Rond, 2=vide
                int choix = random.nextInt(3);
                String image = switch (choix) {
                    case 0 -> "Croix.png";
                    case 1 -> "Rond.png";
                    default -> null;
                };

                // == Complétion de l'image ==
                if (image != null) {
                    ImageView iv = new ImageView("/exercice2/" + image);

                    iv.setFitWidth(60); // Taille de l'image
                    iv.setFitHeight(60);

                    cell.setGraphic(iv);
                }

                root.add(cell, col, row);
            }
        }


        // == MISE EN PAGE ==


        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

