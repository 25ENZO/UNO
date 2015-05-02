package unoLo02;

import java.util.LinkedList;

public class Talon {

    private LinkedList<Carte> talon = new LinkedList<Carte>();

    private char couleurAJouer;

    public Talon() {

    }

    /**
     * @return the couleurAJouer
     */
    public char getCouleurAJouer() {
        return couleurAJouer;
    }

    /**
     * @param couleurAJouer
     */
    public void setCouleurAJouer(char couleurAJouer) {
        this.couleurAJouer = couleurAJouer;
    }

    public Carte getCarteSup() {
        return talon.getLast();
    }

    public void ajoutCarteTalon(Carte AAjouter) {
        talon.add(AAjouter);
        couleurAJouer = AAjouter.getCouleur();
    }

    public void melangerDansPioche(Pioche p) {
        while (talon.size() > 0) {
            p.ajouterCarte(talon.pollFirst());
        }
        p.melanger();
        do{
        talon.add(p.tirerCarteDessu());
        }while(p.tirerCarteDessu() instanceof CartePlusQuatre||p.tirerCarteDessu() instanceof CarteJoker );
        
        couleurAJouer = talon.getLast().getCouleur();
    }

    public void affichercarte() {
        for (int i = 0; i < talon.size(); i++) {
            System.out.println(i + "=>" + talon.get(i));
        }
    }
    

}
