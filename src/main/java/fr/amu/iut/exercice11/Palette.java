package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private IntegerProperty nbFois = new SimpleIntegerProperty(0);
    private StringProperty message = new SimpleStringProperty("");
    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");
    private BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(true);

    private Label texteDuHaut = new Label();
    private Label texteDuBas = new Label();
    private Pane panneau = new Pane();

    @Override
    public void start(Stage primaryStage) {
        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");

        vert.setOnAction(e -> {
            nbFois.set(nbFois.get() + 1);
            message.set("Vert");
            couleurPanneau.set("green");
        });

        rouge.setOnAction(e -> {
            nbFois.set(nbFois.get() + 1);
            message.set("Rouge");
            couleurPanneau.set("red");
        });

        bleu.setOnAction(e -> {
            nbFois.set(nbFois.get() + 1);
            message.set("Bleu");
            couleurPanneau.set("steelblue");
        });

        // Mise en page
        HBox boutons = new HBox(10, vert, rouge, bleu);
        boutons.setAlignment(Pos.CENTER);

        texteDuBas.setPadding(new Insets(10));
        texteDuHaut.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(texteDuHaut);
        root.setBottom(new VBox(boutons, texteDuBas));
        root.setCenter(panneau);

        createBindings();

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercice 11");
        primaryStage.show();
    }

    private void createBindings() {
        // pasEncoreDeClic devient false dès qu’on clique
        pasEncoreDeClic.bind(nbFois.isEqualTo(0));

        // texte du haut : si jamais cliqué → “Rouge choisi X fois” sinon → “Cliquez sur un bouton”
        texteDuHaut.textProperty().bind(
                Bindings.when(pasEncoreDeClic)
                        .then("Cliquez sur un bouton")
                        .otherwise(
                                Bindings.concat(message, " choisi ", nbFois.asString(), " fois")
                        )
        );

        // style du panneau centré (changer la couleur de fond)
        panneau.styleProperty().bind(
                Bindings.concat("-fx-background-color: ", couleurPanneau)
        );

        // texte du bas (message coloré)
        texteDuBas.textProperty().bind(
                Bindings.when(pasEncoreDeClic)
                        .then("")
                        .otherwise(
                                Bindings.concat("Le ", message, " est une jolie couleur !")
                        )
        );

        texteDuBas.styleProperty().bind(
                Bindings.concat("-fx-text-fill: ", couleurPanneau)
        );
    }

}

