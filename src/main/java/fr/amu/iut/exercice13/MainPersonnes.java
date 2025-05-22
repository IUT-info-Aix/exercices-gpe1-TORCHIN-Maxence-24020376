package fr.amu.iut.exercice13;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.beans.Observable;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;
    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(
                personne -> new Observable[]{ personne.ageProperty() }
        );

        unChangementListener = change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Personne p : change.getAddedSubList()) {
                        System.out.println("Ajout de : " + p.getNom());
                    }
                }
                if (change.wasRemoved()) {
                    for (Personne p : change.getRemoved()) {
                        System.out.println("Supression de : " + p.getNom());
                    }
                }
                if (change.wasUpdated()) { // 3
                    for (int i = change.getFrom(); i < change.getTo(); i++) { //.getFrom renvoie le premier élément de la liste modifiée
                        Personne p = lesPersonnes.get(i);
                        System.out.println(
                                p.getNom() + " a maintenant " + p.getAge() + " ans"
                        );
                    }
                }
                if (change.wasUpdated()) { // 4
                    // grâce à l’extractor, un appel à setAge()
                    // déclenche bien wasUpdated()
                    for (int i = change.getFrom(); i < change.getTo(); i++) {
                        Personne p = lesPersonnes.get(i);
                        System.out.println(
                                p.getNom() + " a maintenant " + p.getAge() + " ans"
                        );
                    }
                }
            }
        };
        plusieursChangementsListener = change1 -> {
            while (change1.next()) {
                if (change1.wasAdded()) {
                    for (Personne p : change1.getAddedSubList()) {
                        System.out.println("Ajout de : " + p.getNom());
                    }
                }
                if (change1.wasRemoved()) {
                    for (Personne p : change1.getRemoved()) {
                        System.out.println("Supression de : " + p.getNom());
                    }
                }
                if (change1.wasUpdated()) {
                    for (int i = change1.getFrom(); i < change1.getTo(); i++) {
                        Personne p = lesPersonnes.get(i);
                        System.out.println(
                                p.getNom() + " a maintenant " + p.getAge() + " ans"
                        );
                    }
                }
            }
        };

        lesPersonnes.addListener(unChangementListener);
        lesPersonnes.addListener(plusieursChangementsListener);
        question1();
        question2();
        question3();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

