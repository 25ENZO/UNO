package unoLo02;

public class CarteInversion extends CarteSpecial {
	private char couleur;
	private final int type=3;
	public CarteInversion(char couleur){
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
		if (couleurAJouer==couleur||CarteSuperieur instanceof CarteInversion){
                    return true;
                }
                else {
                    return false;
                }
	}
	
        @Override
	public void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte){
		
                pa.inverserSens();  
                pa.passerTour(nb,1);//a remplir
                pa.setCouleurAJouer(this.couleur);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Inversion"+this.couleur;
	}
        public int getType(){
            return type;
        }
        public int getValeurPrScore() {
		return 20;
	}


		@Override
		public void jouerCarte(int nb, PartieUno pa, Joueur j, int numCarte, char c) {
			// TODO Auto-generated method stub
            pa.inverserSens();  
            pa.passerTour(nb,1);//a remplir
            pa.setCouleurAJouer(this.couleur);
		}



}
