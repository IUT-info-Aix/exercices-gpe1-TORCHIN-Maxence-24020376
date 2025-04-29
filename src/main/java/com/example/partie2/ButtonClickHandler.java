package com.example.partie2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Objects;
import java.util.Random;

import javax.swing.*;

import static java.lang.Long.SIZE;

public class ButtonClickHandler implements EventHandler<Event> {

    private Label helloLabel;
    private TextField nameField;

    public ButtonClickHandler(Label helloLabel, TextField nameField) {
        this.helloLabel = helloLabel;
        this.nameField = nameField;
    }

    @Override
    public void handle(Event event) {
        // Utiliser le Label récupéré
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
    }
}