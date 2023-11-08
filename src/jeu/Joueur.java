package jeu;

import java.util.List;

import cartes.Carte;

public class Joueur {
	private String nom;
	private List<Carte> pileLimitesVitesse;
	private List<Carte> pileBataille;
	private List<Carte> collectionBornes;
	private List<Carte> ensembleBottes;
	private Main main;

	public Joueur(String nom, List<Carte> pileLimitesVitesse, List<Carte> pileBataille, List<Carte> collectionBornes,
			List<Carte> ensembleBottes) {
		this.nom = nom;
		this.pileLimitesVitesse = pileLimitesVitesse;
		this.pileBataille = pileBataille;
		this.collectionBornes = collectionBornes;
		this.ensembleBottes = ensembleBottes;
		this.main = new MainAsListe();
	}

	public String getNom() {
		return nom;
	}
	
	public Main getMain() {
		return main;
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

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(List<Carte> sabot) {
		if (!sabot.isEmpty()) {
			Carte carte = sabot.remove(0);
			donner(carte);
			return carte;
		} else {
			return null;
		}
	}
}
