/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoLo02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Joueur {

    String nom;
    private int numJoueur;
    private boolean uno = false;
    private boolean mefier = false;

    protected ArrayList<Carte> main = new ArrayList<Carte>();

    private int score=0;

    public Joueur() {// 
            score=0;
    }

    /*public void ajouterJoueur(GrandePartieUno g) {
        g.ajouterJoueur(this);

    }*/

    public void compterScore(int scoreManche) {
        this.score = this.score + scoreManche;
        //if(score>500)jeufini
    }

    public void direUno() {
        uno = true;
    }//a remplir

    public void semefier() {
        mefier = true;

        /*méthode à vérifier */
    }

    public boolean utiliserCarte(int nb,PartieUno pa, int numCarte,char c) {

        if (main.get(numCarte).jouabilite(pa.getCouleurAJouerTalon(),pa.getCarteSupTalon())) {
            pa.ajouterCarteTalon(main.get(numCarte));
            System.out.println("Vous avez utlisé la carte "+ main.get(numCarte));
            main.get(numCarte).jouerCarte(nb,pa, this,numCarte);
            main.remove(numCarte);
            return true;
        } else {
            return false;
        }

    }
    public void jouer(PartieUno pa,int nombreJoueur){
    	Scanner in = new Scanner(System.in);
    	int v;
    	int m;
    	boolean cartetiree=false;
    	boolean tourfini=false;
    	boolean carteUtilise=false;
    	System.out.println("----Vos cartes sont:");
        this.affichercarte();
        
        do{
        	System.out.println("Utiliser une carte: <1|0>:");
            v = in.nextInt();//
            if(v==1){
            	System.out.println("Num carte a jouer:");
                m = in.nextInt();
                System.out.println("Vous avez choisi la carte:" + this.getMain().get(m - 1));
                carteUtilise=this.utiliserCarte(nombreJoueur, pa, m - 1,'r');
                	if (carteUtilise==false){
                		System.out.println("Cette carte ne peu pas etre jouer");
                	}
            }else if(cartetiree==false){
            	cartetiree=true;
            	this.tirerCarte(pa);
                System.out.println("Vous avez tire une carte depuis la pioche");
                System.out.println("Votre cartes à main sont:");
                this.affichercarte();
            }else{
            	pa.passerTour(nombreJoueur,1);
            	tourfini=true;
            }
        }while(carteUtilise == false&&tourfini==false);
    	
    }
    
    public void affichercarte() {
    	int i=0;
        for (Carte elem : main) {
        	i++;
            System.out.println("--<"+i+">--"+elem);
        }
    }

    public void tirerCarte(PartieUno pa) {
        main.add(pa.tirerCarteDessuPioche());

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomJoueur, int numJoueur) {
        this.numJoueur = numJoueur;
        this.nom = nomJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public boolean isUno() {
        return uno;
    }

    public void setUno(boolean uno) {
        this.uno = uno; /*a remplir*/
    }

    public boolean isMefier() {
        return mefier;
    }

    public void setMefier(boolean mefier) {
        this.mefier = mefier; /*a remplir*/
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void setMain(Carte c) {
        main.add(c);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void compterScore(){
        int size=main.size();
        for(int k=0;k<size;k++){
            score=score+main.get(k).getValeurPrScore();
        }/*problem*/
    }
    public void supprimerCarte(int numCarte){
        main.remove(numCarte);
    }
    public void mettreEnTalon(PartieUno pa){
        int size=main.size();
        
        for (int k=0;k<size;k++){
        	pa.ajouterCarteTalon(main.get(0));
        	main.remove(0);
        }
    }

}
