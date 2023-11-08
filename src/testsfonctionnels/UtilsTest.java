package testsfonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {
	public static void main(String[] args) {
	    JeuDeCartes jeu = new JeuDeCartes();
	    List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
	    List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

	    System.out.println("Liste de cartes non Melangee :");
	    System.out.println(listeCarteNonMelangee);

	    listeCartes = Utils.melanger(listeCartes);

	    System.out.println("Liste de cartes Melangee :");
	    System.out.println(listeCartes);

	    boolean melangeSansErreur = Utils.verifierMelange(listeCarteNonMelangee, listeCartes);
	    System.out.println("Liste Melangee sans erreur ? " + melangeSansErreur);

	    if (melangeSansErreur) {
	        List<Carte> listeRassemblee = Utils.rassembler(listeCartes);

	        System.out.println("Liste de cartes rassemblee :");
	        System.out.println(listeRassemblee);

	        boolean rassemblementSansErreur = Utils.verifierRassemblement(listeRassemblee,listeCartes);
	        System.out.println("Liste rassemblee sans erreur ? " + rassemblementSansErreur);
	    }
	}
}
