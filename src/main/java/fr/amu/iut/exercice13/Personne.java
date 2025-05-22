package fr.amu.iut.exercice13;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personne {

    private final String nom;
    private final IntegerProperty age;

    public Personne(String nom, int ageInitial) {
        this.nom = nom;
        this.age = new SimpleIntegerProperty(ageInitial);
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int nouvelleValeur) {
        age.set(nouvelleValeur);
    }

    public IntegerProperty ageProperty() {
        return age;
    }
}
