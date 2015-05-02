/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unoLo02;

import java.util.Scanner;


/**
 *
 * @author Michael
 */
public class JoueurVirtuel extends Joueur {
	private Strategy strategy;
	public JoueurVirtuel(Strategy s){
		this.strategy=s;
	}
	
	public void jouer(PartieUno pa,int nombreJoueur){
		strategy.jouer(this, pa,nombreJoueur);
	}
    public boolean utiliserCarte(int nb,PartieUno pa, int numCarte,char c) {

        if (super.main.get(numCarte).jouabilite(pa.getCouleurAJouerTalon(),pa.getCarteSupTalon())) {
            pa.ajouterCarteTalon(super.main.get(numCarte));
            System.out.println("Vous avez utlisé la carte "+ super.main.get(numCarte));
            if(super.main.get(numCarte) instanceof CarteJoker ||super.main.get(numCarte) instanceof CartePlusQuatre )
            	super.main.get(numCarte).jouerCarte(nb,pa, this,numCarte,c);
            else
            	super.main.get(numCarte).jouerCarte(nb,pa, this,numCarte);
            super.main.remove(numCarte);
            return true;
        } else {
            return false;
        }
    }

}

