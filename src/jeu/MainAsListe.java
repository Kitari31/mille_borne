package jeu;

import cartes.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainAsListe implements Main {
    private List<Carte> cartesEnMain = new ArrayList<>();

    @Override
    public void prendre(Carte carte) {
        cartesEnMain.add(carte);
    }

    @Override
    public void jouer(Carte carte) {
        assert cartesEnMain.contains(carte) : "La carte n'est pas dans la main.";
        cartesEnMain.remove(carte);
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartesEnMain.iterator();
    }
}
