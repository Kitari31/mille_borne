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
    	try{
    		cartesEnMain.remove(carte);
        } catch(Exception e ){
            System.out.println("La carte n'est pas dans la main");
        }
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartesEnMain.iterator();
    }
    
    public List<Carte> getCarteEnMain(){
    	return cartesEnMain;
    }
}