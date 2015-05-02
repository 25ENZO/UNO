package unoLo02;

public abstract class Carte {
	private int valeurPrScore;
	
	/**
	 * @return the valeurPrScore
	 */
	public int getValeurPrScore() {
		return valeurPrScore;
	}

	public void setValeurPrScore(int valeurPrScore) {
		this.valeurPrScore = valeurPrScore;
	}

	public abstract boolean jouabilite(char couleurAJouer, Carte CarteSuperieur);
	
	public abstract void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte);
	public abstract void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte,char c);
        @Override
	public abstract String toString();
	public abstract char getCouleur();
        public abstract int getType();
        
}
