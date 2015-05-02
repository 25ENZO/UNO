package unoLo02;

public class CartePlusDeux extends CarteSpecial {
	private char couleur;
	private final int type=2;
	public CartePlusDeux(char couleur){
		this.couleur=couleur;
	}

	/**
	 * @return the couleur
	 */
        @Override
	public char getCouleur() {
		return couleur;
	}

    /**
     *
     * @param couleurAJouer
     * @param CarteSuperieur
     * @return
     */
    @Override
	public boolean jouabilite(char couleurAJouer, Carte CarteSuperieur){
		if (couleurAJouer==this.couleur||CarteSuperieur instanceof CartePlusDeux){
			return true;
                }
                else {
                    return false;
                }
	}
	
        @Override
	public void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte) {
        //aremplir
            
            pa.passerTour(nb,2);
            pa.setCouleurAJouer(this.couleur);
            
    }
    
    /**
     * M�thode renvoyant un cha�ne de caract�re d�signant la carte, elle de la forme 
     * "couleur+2" 
     * retourn Chaine de caract�re d�signant la carte
     * @return 
     */   
        @Override
    public String toString() {
        return "+2"+this.couleur;
    }
        @Override
    public int getType(){
            return type;
        }
    public int getValeurPrScore() {
		return 20;
	}

	@Override
	public void jouerCarte(int nb, PartieUno pa, Joueur j, int numCarte, char c) {
		// TODO Auto-generated method stub
		pa.passerTour(nb,2);
        pa.setCouleurAJouer(this.couleur);
		
	}


	
}
