package unoLo02;

public class CartePasserTour extends CarteSpecial {
	private char couleur;
	private final int type=4;
	public CartePasserTour(char couleur){
		this.couleur=couleur;
	}

	/**
	 * @return the couleur
	 */
        @Override
	public char getCouleur() {
		return couleur;
	}

        @Override
	public boolean jouabilite(char couleurAJouer, Carte CarteSuperieur){
		if (couleurAJouer==couleur||CarteSuperieur instanceof CartePasserTour){
			return true;
                }
                else {
                    return false;
                }
	}

	@Override
	public void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte) {
		// TODO Auto-generated method stub
		
                pa.passerTour(nb,2);
                pa.setCouleurAJouer(this.couleur);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Passer tour"+this.couleur;
	}
        @Override
        public int getType(){
            return type;
        }
        public int getValeurPrScore() {
		return 20;
	}

		@Override
		public void jouerCarte(int nb, PartieUno pa, Joueur j, int numCarte,char c) {
            pa.passerTour(nb,2);
            pa.setCouleurAJouer(this.couleur);
			
		}



}
