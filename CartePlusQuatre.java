package unoLo02;

import java.util.Scanner;

public class CartePlusQuatre extends CarteSpecial {

    private final int type = 6;

    public CartePlusQuatre() {
    }

    @Override
    public boolean jouabilite(char couleurAJouer, Carte CarteSuperieur) {
        return true;
    }

    //acompleter
    public void choisirCouleur(Talon t) {
        char couleur;
        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez la couleur a jouer");
        couleur = sc.next().charAt(0);

        t.setCouleurAJouer(couleur);
    }
    

    public void jouerCarte(int nb,PartieUno pa, Joueur j, int numCarte) {
        char couleur;
        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez la couleur a jouer");
        couleur = sc.next().charAt(0);

        pa.setCouleurAJouer(couleur);
        pa.passerTour(nb,2);
        //a remplir
    }

    public void jouerCarte(int nb,PartieUno pa, Joueur j, int numCarte,char c) {


        pa.setCouleurAJouer(c);
        pa.passerTour(nb,2);
        //a remplir
    }
    /**
     * M�thode renvoyant un cha�ne de caract�re d�signant la carte, elle de la
     * forme "couleur+2" retourn Chaine de caract�re d�signant la carte
     * @return 
     */
    @Override
    public String toString() {
        return "+4";
    }

    @Override
    public char getCouleur() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getType() {
        return type;
    }
    public int getValeurPrScore() {
		return 50;
	}

}
