package unoLo02;

public class Inteligent implements Strategy {
	
    public void jouer(Joueur j,PartieUno pa,int nombreJoueur){//aleatoire par ordre et jouability
    	int i=0;
    	boolean good=false;
    	
    	try {
			Thread.sleep(0000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	do{
    		good=j.utiliserCarte( nombreJoueur, pa,i,'r');
    		i++;
    	}while(good==false&&i<j.getMain().size());
    	
    	if(good==false){
    		j.tirerCarte(pa);
    		pa.passerTour(nombreJoueur,1);
    	}
    		
    }
    


}
