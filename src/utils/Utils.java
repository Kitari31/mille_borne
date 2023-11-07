package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Utils {
    public static <T> T extraire(List<T> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste est vide.");
        }

        int randomIndex = (int) (Math.random() * liste.size());
        return liste.remove(randomIndex);
    }

    public static <T> T extraire(ListIterator<T> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("La liste est vide.");
        }

        int randomIndex = (int) (Math.random() * (iterator.nextIndex() + 1));
        while (iterator.nextIndex() != randomIndex) {
            iterator.next();
        }

        T element = iterator.next();
        iterator.remove();
        return element;
    }

    public static <T> List<T> mélanger(List<T> liste) {
        List<T> résultat = new ArrayList<>(liste);
        Collections.shuffle(résultat);
        liste.clear();
        return résultat;
    }

    public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        return liste1.size() == liste2.size() &&
               liste1.containsAll(liste2) &&
               liste2.containsAll(liste1);
    }

    public static <T> List<T> rassembler(List<T> liste) {
        List<T> résultat = new ArrayList<>();
        if (liste.isEmpty()) {
            return résultat;
        }

        T précédent = liste.get(0);
        résultat.add(précédent);

        for (int i = 1; i < liste.size(); i++) {
            T actuel = liste.get(i);
            if (!actuel.equals(précédent)) {
                résultat.add(actuel);
                précédent = actuel;
            }
        }

        return résultat;
    }

    public static <T> boolean verifierRassemblement(List<T> listeRassemblee, List<T> listeMélangée) {
        if (listeRassemblee.size() > listeMélangée.size()) {
            return false;
        }

        int i = 0;
        for (T élémentRassemblee : listeRassemblee) {
            while (i < listeMélangée.size()) {
                if (listeMélangée.get(i).equals(élémentRassemblee)) {
                    i++;
                    break;
                }
                i++;
            }

            if (i >= listeMélangée.size() && !élémentRassemblee.equals(listeMélangée.get(listeMélangée.size() - 1))) {
                return false;
            }
        }

        return true;
    }


}
