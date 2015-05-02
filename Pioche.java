package unoLo02;

import java.util.Collections;
import java.util.LinkedList;


public class Pioche {

	private LinkedList<Carte> pioche = new LinkedList<Carte>();
	
	public Pioche() {
        int k;
        
        pioche.add(new CarteStandard(0,'b'));
        pioche.add(new CarteStandard(0,'r'));
        pioche.add(new CarteStandard(0,'v'));
        pioche.add(new CarteStandard(0,'j'));
        
        for(k=1;k<=9;k++){
            pioche.add(new CarteStandard(k,'b'));
            pioche.add(new CarteStandard(k,'r'));
            pioche.add(new CarteStandard(k,'v'));
            pioche.add(new CarteStandard(k,'j'));
            pioche.add(new CarteStandard(k,'b'));
            pioche.add(new CarteStandard(k,'r'));
            pioche.add(new CarteStandard(k,'v'));
            pioche.add(new CarteStandard(k,'j'));
        }
        
        for(k=1;k<=2;k++){
        	pioche.add(new CartePlusDeux('b'));
        	pioche.add(new CartePlusDeux('r'));
        	pioche.add(new CartePlusDeux('v'));
        	pioche.add(new CartePlusDeux('j'));
            pioche.add(new CarteInversion('b'));
            pioche.add(new CarteInversion('r'));
            pioche.add(new CarteInversion('v'));
            pioche.add(new CarteInversion('j'));
            pioche.add(new CartePasserTour('b'));
            pioche.add(new CartePasserTour('r'));
            pioche.add(new CartePasserTour('v'));
            pioche.add(new CartePasserTour('j'));
        }
        
        for(k=1;k<=4;k++){
        	pioche.add(new CarteJoker());
        	pioche.add(new CartePlusQuatre());
        }
        
	}
	
	public void melanger(){
            
		Collections.shuffle(pioche);
                
	}
	public Carte tirerCarteDessu(){
		return pioche.pollFirst();
	}
    public void ajouterCarte(Carte c) {
        pioche.add(c);
    }
    public void affichercarte(){
    	for(int i=0; i<pioche.size();i++)
        {
        	 System.out.println (i+"=>"+pioche.get(i));
        }
    }

}
