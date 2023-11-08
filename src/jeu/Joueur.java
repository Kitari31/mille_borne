package jeu;

import java.util.List;

import cartes.*;

public class Joueur {
    private String nom;
    private List<Carte> pileLimitesVitesse;
    private List<Carte> pileBataille;
    private List<Carte> collectionBornes;
    private List<Carte> ensembleBottes;
    private Main main; // Ajout de la main du joueur
    private int kmParcourus;
    private boolean prioritaire;

    public Joueur(String nom, List<Carte> pileLimitesVitesse, List<Carte> pileBataille, List<Carte> collectionBornes, List<Carte> ensembleBottes) {
    	this.nom = nom;
        this.pileLimitesVitesse = pileLimitesVitesse;
        this.pileBataille = pileBataille;
        this.collectionBornes = collectionBornes;
        this.ensembleBottes = ensembleBottes;
        this.main = new MainAsListe(); // Initialisation de la main du joueur
        this.prioritaire = aLaBotteDeTypeFEU(ensembleBottes);
    }

    public String getNom() {
        return nom;
    }

    public Main getMain() {
        return main;
    }

    public void donner(Carte carte) {
        main.prendre(carte);
    }

    public List<Carte> getPileLimitesVitesse() {
        return pileLimitesVitesse;
    }

    public List<Carte> getPileBataille() {
        return pileBataille;
    }

    public List<Carte> getCollectionBornes() {
        return collectionBornes;
    }

    public List<Carte> getEnsembleBottes() {
        return ensembleBottes;
    }
    
    @Override
    public boolean equals(Object joueur) {
        if (this == joueur) {
            return true;
        }
        if (joueur == null || getClass() != joueur.getClass()) {
            return false;
        }

        Joueur autreJoueur = (Joueur) joueur;
        return nom.equals(autreJoueur.nom);
    }
    
    @Override
    public String toString() {
        return nom;
    }
    
    public Carte prendreCarte(List<Carte> sabot) {
        if (!sabot.isEmpty()) {
            Carte carte = sabot.remove(0);
            donner(carte); // Ajoute la carte à la main du joueur
            return carte;
        } else {
            return null; // Le sabot est vide, renvoie null
        }
    }
    
    public int getKM() {
        return kmParcourus;
    }
    
    public void ajouterKM(int km) {
        kmParcourus += km;
    }

    public void jouerBorne(Borne borne) {
        ajouterKM(borne.getKm());
    }
    
    public int getLimite(List<Carte> pileLimitesVitesse) {
        if (aLaBotteDeTypeFEU(ensembleBottes)) {
            return 200; // Joueur a la botte de type FEU, limite de vitesse de 200
        }
        
        if (pileLimitesVitesse.isEmpty()) {
            return 200; // Pile de limites vide, limite de vitesse de 200
        }
        
        // Vérification des cartes spécifiques en haut de la pile
        Carte sommet = pileLimitesVitesse.get(pileLimitesVitesse.size() - 1);
        if (sommet instanceof DebutLimite) {
            return 50; // La limite est de 50 si le sommet est une FinLimite ou une DebutLimite
        }
        
        return 200; // Par défaut, la limite est de 200
    }

    // Méthode pour vérifier si le joueur a la botte de type FEU
    private boolean aLaBotteDeTypeFEU(List<Carte> ensembleBottes) {
        for (Carte botte : ensembleBottes) {
            if (botte instanceof Botte && ((Botte) botte).getType() == Probleme.Type.FEU) {
                return true;
            }
        }
        return false;
    }
    
    public boolean estBloque() {
        // La pile de bataille est vide et le joueur est prioritaire.
        if (pileBataille.isEmpty() && prioritaire) {
            return false;
        }

        // Vérification si le sommet est une parade de type FEU.
        if (!pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1) instanceof Parade
                && ((Parade) pileBataille.get(pileBataille.size() - 1)).getType() == Probleme.Type.FEU) {
            return false;
        }

        // Le sommet est une parade et le joueur est prioritaire.
        if (!pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1) instanceof Parade && prioritaire) {
            return false;
        }

        // Le sommet est une attaque de type FEU et le joueur est prioritaire.
        if (!pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1) instanceof Attaque
                && ((Attaque) pileBataille.get(pileBataille.size() - 1)).getType() == Probleme.Type.FEU && prioritaire) {
            return false;
        }

        // Le sommet est une attaque d'un autre type pour lequel le joueur a une botte et il est prioritaire.
        if (!pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1) instanceof Attaque && prioritaire) {
            Attaque attaque = (Attaque) pileBataille.get(pileBataille.size() - 1);
            for (Carte botte : ensembleBottes) {
                if (botte instanceof Botte && ((Botte) botte).getType() == attaque.getType()) {
                    return false;
                }
            }
        }

        return true; // Si aucune des conditions pour avancer n'est remplie, le joueur est bloqué.
    }

}

