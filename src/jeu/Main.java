package jeu;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public interface Main {
    void prendre(Carte carte);
    void jouer(Carte carte);
    Iterator<Carte> iterator();
    List<Carte> getCarteEnMain();
}