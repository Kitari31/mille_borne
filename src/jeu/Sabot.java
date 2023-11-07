package jeu;

import cartes.Carte;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes;
    private int nbCartes;

    public Sabot() {
        this.cartes = new Carte[110];
        this.nbCartes = 0;
    }
    
    public int getNbCartes() {
        return nbCartes;
    }

    public Carte[] getCartes() {
        return cartes;
    }
    
    public boolean estVide() {
        return nbCartes == 0;
    }
    
    public void ajouterCarte(Carte carte) {
        if (nbCartes < cartes.length) {
            cartes[nbCartes] = carte;
            nbCartes++;
        } else {
            System.out.println("Le sabot est plein, impossible d'ajouter plus de cartes.");
        }
    }
    
    public void ajouterFamilleCarte(Carte carte) {
		int nbrFamille = carte.getNombre();
		for (int i = 0; i < nbrFamille; i++) {
			ajouterCarte(carte);
		}
	}
    
    public void ajouterFamilleCarte(Carte... args) {
		for (Carte carte : args){
			ajouterFamilleCarte(carte);
		}
	}
    
    public Carte piocher() {
        Iterator<Carte> iterator = iterator();
        if (iterator.hasNext()) {
            Carte cartePiochee = iterator.next();
            iterator.remove(); // Supprime la carte du sabot
            return cartePiochee;
        } else {
            throw new NoSuchElementException("Le sabot est vide, impossible de piocher.");
        }
    }
    
    @Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }

    private class SabotIterator implements Iterator<Carte> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < nbCartes;
        }

        @Override
        public Carte next() {
            if (!hasNext()) {
                return null;
            }
            return cartes[index++];
        }
        
        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("Vous ne pouvez pas supprimer avant d'appeler next.");
            }
            for (int i = index - 1; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
            cartes[nbCartes - 1] = null;
            nbCartes--;
            index--;
        }
    }
}
