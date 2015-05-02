package unoLo02;

public class CarteStandard extends Carte {

    private char couleur;
    private final int type = 1;

    public CarteStandard(int score, char couleur) {
        super.setValeurPrScore(score);
        this.couleur = couleur;
    }

    /**
     * @return the couleur
     */
    @Override
    public char getCouleur() {
        return couleur;
    }

    /**
     * Retourne le numéro de la carte
     *
     * @return Numéro de la carte
     */
    public int getNumero() {
        return super.getValeurPrScore();
    }

    @Override
    public boolean jouabilite(char couleurAJouer, Carte CarteSuperieur) {
        boolean bool = false;

        if (couleurAJouer == this.couleur || CarteSuperieur.getValeurPrScore() == super.getValeurPrScore()) {
            bool = true;
        }

        return bool;
    }

    @Override
    public void jouerCarte(int nb,PartieUno pa, Joueur j, int numCarte) {
        // TODO Auto-generated method stub
       
        pa.passerTour(nb,1);
        pa.setCouleurAJouer(this.couleur);
    }

    /**
     * Retourne une chaine de caractere d�signant la carte. La chaine est de la
     * forme "CouleurNumero" retourn Chaine d�signant la carte
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + this.couleur + this.getNumero();
    }

    public int getType() {
        return type;
    }

	@Override
	public void jouerCarte(int nb, PartieUno pa, Joueur j, int numCarte, char c) {
		// TODO Auto-generated method stub
		 pa.passerTour(nb,1);
	        pa.setCouleurAJouer(this.couleur);
	}



}
