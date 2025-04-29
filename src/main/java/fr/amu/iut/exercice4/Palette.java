package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;



    @Override
    public void start(Stage primaryStage) throws Exception {

        // == Fabrication des boutons ==

        Button Vert = new Button("Vert");
        Button Rouge = new Button("Rouge");
        Button Bleu = new Button("Bleu");

        // == Gestion des évènements ==

        label = new Label("");
        label.setFont( Font.font("Courier", FontWeight.BOLD, 22) );
        panneau = new Pane();


        Vert.setOnAction(e -> {
            nbVert++;
            panneau.setStyle("-fx-background-color: green;");
            label.setText("Nombre de clics sur Vert : " + nbVert);
        });

        Rouge.setOnAction(e -> {
            nbRouge++;
            panneau.setStyle("-fx-background-color: red;");
            label.setText("Nombre de clics sur Rouge : " + nbRouge);
        });

        Bleu.setOnAction(e -> {
            nbBleu++;
            panneau.setStyle("-fx-background-color: blue;");
            label.setText("Nombre de clics sur Bleu : " + nbBleu);
        });


        // === Mise en page ===

        bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10));
        bas.setSpacing(10);
        bas.getChildren().addAll(Vert, Rouge, Bleu);

        root = new BorderPane();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setCenter(panneau);
        root.setBottom(bas);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

