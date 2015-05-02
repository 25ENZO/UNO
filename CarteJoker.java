package unoLo02;

import java.util.Scanner;

public class CarteJoker extends CarteSpecial {
	private final int type=5;
	public CarteJoker(){
	}
	
        @Override
	public boolean jouabilite(char couleurAJouer, Carte CarteSuperieur){
			return true;
	}
	
        @Override
        public void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte){
		char couleur;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Donnez la couleur a jouer");
		couleur = sc.next().charAt(0);
		
		pa.setCouleurAJouer(couleur);
                pa.passerTour(nb,1);
	}
        
        public void jouerCarte(int nb,PartieUno pa,Joueur j,int numCarte,char c){
		pa.setCouleurAJouer(c);
        pa.passerTour(nb,1);
	}
        
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Joker";
	}

	@Override
	public char getCouleur() {
		// TODO Auto-generated method stub
		return 0;
	}
        public int getType(){
            return type;
        }
        public int getValeurPrScore() {
		return 50;
	}
	
}
