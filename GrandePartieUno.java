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
public class GrandePartieUno {

    private int modeDeJeu;
    private boolean gager;
    private  Joueur[] listJoueur = new Joueur[10];
    private int nombreJoueur;
    
    public void initialisationPartie(){
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.print("\n++++++++++++++++++++++++++++++++++++UNO++++++++++++++++++++++++++++++++++\n");
    	System.out.print("/\t\t\t\t\t\t\t\t\t/\n");
    	System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t----------------BIENVENUE-------------------\t\t/\n");
    	System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    	System.out.println("Nombre de joueur:");
        this.nombreJoueur = in.nextInt();
        //System.out.println("Le nombre de joueur est: " + this.nombreJoueur);
        

        String nom;
        for (int i = 0; i <= this.nombreJoueur - 1; i++) {
            int type;
            /* saiir les noms de joueur*/
            System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------------Joueur "+(i+1)+"-------------------\t\t/\n");
            System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            
            System.out.println("Nom:");
            nom = in.next();
            System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------------Type Joueur"+(i+1)+"-------------------\t\t/\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\tPhysique-----------------------------------<1>\t\t/\n");
            System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\tVirtuel------------------------------------<2>\t\t/\n/\t\t\t\t\t\t\t\t\t/");
            System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            type = in.nextInt();
            
            if(type==1)
            	this.listJoueur[i] = new Joueur();
            else{
                System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------------Mode de Jeur-------------------\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\tAleatoire----------------------------------<1>\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\tIntelligent--------------------------------<2>\t\t/\n/\t\t\t\t\t\t\t\t\t/");
                System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                int type2;

                type2=in.nextInt();
                if (type2 == 1) {
                	this.listJoueur[i] = new JoueurVirtuel(new Aleatoire());
                }
                if (type2 == 2) {
                	this.listJoueur[i] = new JoueurVirtuel(new Inteligent());
                }
            	
            }
            this.listJoueur[i].setNom(nom, i+1);
      
        }
    }
    
    public void deroulementPartie(){
    	Scanner in = new Scanner(System.in);
    	this.initialisationPartie();
        PartieUno pa = new PartieUno();

        while (this.isGager() == false) {

            pa.melangerTalonDansPioche();//
            pa.afficherCartePioche();//
            

            /*commencer le jeu*/
            pa.melangerPioche();/*melanger le pioche*/
               //definir le premier joueur on modifier le tour setTour(numjoueurcarte haute);
            
            this.distribuerCarte(pa);
            int joueurPrecedant = 0;
            pa.setGager(false);
            while (pa.isGager() == false) {
                
                System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------------Joueur:"+ this.listJoueur[pa.getTour() - 1].getNom()+"-------------------\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------Carte Superieur Talon:  "+ pa.getCarteSupTalon() +"-------\t\t/\n");
                System.out.print("/\t\t\t\t\t\t\t\t\t/\n/\t\t---------Couleur A Jouer:  "+ pa.getCouleurAJouerTalon()+"--------------\t\t/\n/\t\t\t\t\t\t\t\t\t/");
                System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                //System.out.println("C'est le tour de joueur: " + this.listJoueur[pa.getTour() - 1].getNom());
                /*affichier les cartes à main*/
                joueurPrecedant = pa.getTour();
                this.listJoueur[pa.getTour() - 1].jouer(pa,this.nombreJoueur);
                //this.jouerTour(pa);

                pa.verifierGager(this.listJoueur, this.nombreJoueur);/*probleme d'ici jusqu'a la fin*/
                

            }

            ajouterScoreAuGagnant(joueurPrecedant,pa);
        }
        
    }
    
    public void ajouterScoreAuGagnant(int joueurPrecedant,PartieUno pa){
        for (int k = 0; k < this.nombreJoueur; k++) {
            int size = this.listJoueur[k].getMain().size();
            if (k != joueurPrecedant - 1) {
                for (int k2 = 0; k2 < size; k2++) {

                	this.listJoueur[joueurPrecedant - 1].setMain(this.listJoueur[k].getMain().get(k2));

                }
                this.listJoueur[k].getMain().clear();
            }

        }
        this.listJoueur[joueurPrecedant - 1].compterScore();
        this.listJoueur[joueurPrecedant - 1].mettreEnTalon(pa);
        System.out.println("joueur " + this.listJoueur[joueurPrecedant - 1].getNom() + " a gangé et son score est: " + this.listJoueur[joueurPrecedant - 1].getScore());
        this.verifierGanant(this.listJoueur[joueurPrecedant-1]);
    }

    public void distribuerCarte(PartieUno pa){
    	for (int n = 0; n <= this.nombreJoueur - 1; n++) {
            for(int i=0;i<7;i++){
            		this.listJoueur[n].tirerCarte(pa); /*tirer 4 cartes au début*/
            }
        }
    }
    
    /*public void jouerTour(PartieUno pa){
    	Scanner in = new Scanner(System.in);
    	int v;
    	int m;
    	boolean cartetiree=false;
    	boolean tourfini=false;
    	boolean carteUtilise=false;
    	System.out.println("Votre cartes à main sont:");
        this.listJoueur[pa.getTour() - 1].affichercarte();
        
        do{
        	System.out.println("si vous voulez utiliser une carte taper 1,sinon 0:");
            v = in.nextInt();//
            if(v==1){
            	System.out.println("choisir une carte à jouer(saisir le numéro de la carte)");
                m = in.nextInt();
                System.out.println("Vous avez choisi la carte:" + this.listJoueur[pa.getTour() - 1].getMain().get(m - 1));
                carteUtilise=this.listJoueur[pa.getTour() - 1].utiliserCarte(this.nombreJoueur, pa, m - 1);
                if(carteUtilise==false)
                	System.out.println("La carte n est pas utilisable");
            }else if(cartetiree==false){
            	cartetiree=true;
            	this.listJoueur[pa.getTour() - 1].tirerCarte(pa);
                System.out.println("Vous avez tiré une carte depuis la pioche");
                System.out.println("Votre cartes à main sont:");
                this.listJoueur[pa.getTour() - 1].affichercarte();
            }else{
            	pa.passerTour(this.nombreJoueur,1);
            	tourfini=true;
            }
        }while(carteUtilise == false&&tourfini==false);
        
    }*/
    
    public GrandePartieUno(int modeDeJeu) {
        this.gager=false;
    }
    
    /*public void ajouterJoueur(Joueur j){
    	listJoueur.add(j);
    }*/
    
    public int getModeDeJeu() {
        return modeDeJeu;
    }

    public void setModeDeJeu(int modeDeJeu) {
        this.modeDeJeu = modeDeJeu;
    }


    public boolean isGager() {
        return gager;
    }

    public void setGager(boolean gager) {
        this.gager = gager;
    }
    public void verifierGanant(Joueur j) {
        if (j.getScore() >= 500) {
            System.out.println(j.getNom() + " a gage");
            gager=true;
        }
        finPartie();
    }
    
    public void finPartie(){
        /* méthode de mettre en fin d'un partie */
    }

    
    
}
