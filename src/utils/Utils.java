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

    public static <T> List<T> melanger(List<T> liste) {
        List<T> resultat = new ArrayList<>(liste);
        Collections.shuffle(resultat);
        liste.clear();
        return resultat;
    }

    public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        return liste1.size() == liste2.size() &&
               liste1.containsAll(liste2) &&
               liste2.containsAll(liste1);
    }

    public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        if (liste.isEmpty()) {
            return resultat;
        }

        T precedent = liste.get(0);
        resultat.add(precedent);

        for (int i = 1; i < liste.size(); i++) {
            T actuel = liste.get(i);
            if (!actuel.equals(precedent)) {
            	resultat.add(actuel);
                precedent = actuel;
            }
        }

        return resultat;
    }

    public static <T> boolean verifierRassemblement(List<T> listeRassemblee, List<T> listemelangee) {
        if (listeRassemblee.size() > listemelangee.size()) {
            return false;
        }

        int i = 0;
        for (T elementRassemblee : listeRassemblee) {
            while (i < listemelangee.size()) {
                if (listemelangee.get(i).equals(elementRassemblee)) {
                    i++;
                    break;
                }
                i++;
            }

            if (i >= listemelangee.size() && !elementRassemblee.equals(listemelangee.get(listemelangee.size() - 1))) {
                return false;
            }
        }

        return true;
    }


}
