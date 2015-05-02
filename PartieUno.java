/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoLo02;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class PartieUno {

    private int tour;
    private int sens;// 1 pour le sens a default -1 pour l autre
    private int score;
    private boolean gager;
    private Pioche pio = new Pioche();
    private Talon tal = new Talon();

    public void jouerTour() {

    }

    public PartieUno() {
        this.tour = 1;
        this.sens = 1;
        this.score = 0;

    }

    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void inverserSens() {
        if (sens == 1) {
            sens = -1;
        } else if (sens == -1) {
            sens = 1;
        }
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public void passerTour(int nbJoueur, int nbTourAPasser) {
        for (int i = 1; i <= nbTourAPasser; i++) {
            if(sens == 1){
                if(tour==nbJoueur){
                     tour=1;
                }
                else{
                    tour++;
                }
            }
            if(sens==-1){
                if(tour==1){
                    tour=nbJoueur;
                }
                else{
                    tour--;
                }
            }
        }
    }

    public void verifierGager(Joueur[] j,int nbJoueur) {
        gager = false;
        for(int k=0;k<nbJoueur;k++){
        if (j[k].getMain().isEmpty()) {
            gager = true;
            
        }
        }
    }

    public boolean isGager() {
        return gager;
    }

    public void setGager(boolean gager) {
        this.gager = gager;
    }
    
    public void melangerTalonDansPioche(){
    	this.tal.melangerDansPioche(pio);
    }
    
    public void afficherCartePioche(){
    	this.pio.affichercarte();
    }
    public void melangerPioche(){
    	pio.melanger();
    }
    public Carte tirerCarteDessuPioche(){
    	return pio.tirerCarteDessu();
    }
    public Carte getCarteSupTalon() {
        return tal.getCarteSup();
    }
    public char getCouleurAJouerTalon() {
        return tal.getCouleurAJouer();
    }
    public void setCouleurAJouer(char couleurAjouer){
    	tal.setCouleurAJouer(couleurAjouer);
    }
    public void ajouterCarteTalon(Carte c){
    	tal.ajoutCarteTalon(c);
    }
}
