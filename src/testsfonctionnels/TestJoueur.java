package testsfonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.*;
import jeu.Joueur;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("Joueur 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		
		//Test Question1
		System.out.println(joueur1.getNom());
		System.out.println(joueur1.getCollectionBornes());
		System.out.println(joueur1.getEnsembleBottes());
		System.out.println(joueur1.getPileBataille());
		System.out.println(joueur1.getPileLimitesVitesse());
		
		//Test Question2
		Joueur joueur2 = new Joueur("Joueur 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		Joueur joueur3 = new Joueur("Joueur 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		
		System.out.println(joueur2.toString());
		System.out.println(joueur1.toString());
		System.out.println(joueur2.equals(joueur1));
		System.out.println(joueur3.toString());
		System.out.println(joueur1.toString());
		System.out.println(joueur3.equals(joueur1));
		
		//Test Question 3-6
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		System.out.println(jeuDeCartes.getListeCartes());
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur1.getMain().getCarteEnMain());
		System.out.println(joueur2.getMain().getCarteEnMain());
		System.out.println(joueur3.getMain().getCarteEnMain());
		
		//Test Question 3-8
		Borne borne1 = new Borne(1,50);
		Borne borne2 = new Borne(1,100);
		Borne borne3 = new Borne(1,200);
		
		joueur1.jouerBorne(borne1);
		joueur1.jouerBorne(borne2);
		joueur1.jouerBorne(borne3);
		System.out.println(joueur1.getKm());
		
		//Test Question 3-10
		
		//défault
		System.out.println(joueur1.getlimite());
		//sommet = FinLimite
		Joueur joueurfinlimite = new Joueur("Joueur 4",List.of(new FinLimite(1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		System.out.println(joueurfinlimite.getlimite());
		//Proritaire
		Joueur joueurPrio = new Joueur("Joueur 4",List.of(new DebutLimite(1)), new ArrayList<>(), new ArrayList<>(), List.of(new Botte(1, Probleme.Type.FEU)));
		System.out.println(joueurPrio.getlimite());
		//pile non vide
		Joueur joueurLimite = new Joueur("Joueur 4",List.of(new DebutLimite(1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		System.out.println(joueurLimite.getlimite());
	}
}