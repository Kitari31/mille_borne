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
        if (pileLimitesVitesse.isEmpty() || pileLimitesVitesse.get(pileLimitesVitesse.size() - 1) instanceof FinLimite || prioritaire) {
            return 200;
        } else {
            return 50;
        }
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
}

