package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;
import fr.amu.iut.exercice5.Obstacle;
import javafx.scene.text.Font;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private static final List<Obstacle> obstacles = new ArrayList<>();



    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        // Mur
        Obstacle mur = new Obstacle(200, 60, 40, 400);
        obstacles.add(mur);
        jeu.getChildren().add(mur);

        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getWidth());
                    break;

            }
            if (j1.estEnCollision(j2)){
                VBox gameOverPane = new VBox(20);
                gameOverPane.setAlignment(Pos.CENTER);

                Label message = new Label("Partie finie");
                message.setFont(new Font(36));

                Button resetButton = new Button("Réinitialiser la partie");
                // Réinitialise positions directement
                resetButton.setOnAction(e -> {
                    j1.setLayoutX(0);
                    j1.setLayoutY(0);
                    j2.setLayoutX(20 * 10);
                    j2.setLayoutY(0);
                    Pane jeu = new Pane();
                    jeu.setPrefSize(640, 480);
                    jeu.getChildren().setAll(j1, j2);
                    Obstacle mur = new Obstacle(200, 60, 40, 400);
                    obstacles.add(mur);
                    jeu.getChildren().add(mur);
                    root.setCenter(jeu);
                    scene.getRoot().requestFocus();
                });

                gameOverPane.getChildren().addAll(message, resetButton);
                root.setCenter(gameOverPane);
            }
        });
    }
}
