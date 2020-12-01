
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RICHARD nicolas et SAVOYE Valentin
 */
public class Vue extends JFrame {

    private int difficulte;//initialisation de toutes les variables
    private int haut;
    private int largeur;
    private Case[][] cases;
    private Grille grille;
    private JButton reset;
    private boolean victoire;

    public void selection(int x, int y) {

        cases[x][y].show();
        if (cases[x][y].getnumber() == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (x + i > 0 && x - 1 + i < this.largeur && y + j > 0 && y - 1 + j < this.haut) {

                        if (!cases[x - 1 + i][y - 1 + j].shown()) {
                            this.selection(x - 1 + i, y - 1 + j);
                        }
                    }
                }
            }
        }
        if (cases[x][y].isbomb()) {

            defaite();
            this.refresh();
        }
        int com = 0;

        for (int i = 0; i < this.largeur; i++) {
            for (int j = 0; j < this.haut; j++) {
                if (cases[i][j].isbomb() || cases[i][j].shown()) {
                    com++;//compteur de coup
                }
            }
        }
        if (com == this.largeur * this.haut) {
            this.victoire = true;//quand le compteur de coup vaut la taille de la grille, sans que la partie soit perdue
        }                   //on gagne

    }

    public Case[][] getCases() {
        return cases;
    }

    public void refresh() { //Actualise la grille
        grille.repaint();
    }

    public void defaite() {//quand on perd on affiche la grille de jeu 
        for (int i = 0; i < this.largeur; i++) {
            for (int j = 0; j < this.haut; j++) {
                cases[i][j].show();
            }
        }
    }

    

    public void NouvelleGrille() {//creation de la grille
        grille = new Grille(this); //Cree une nouvelle grille
        reset.setSize(grille.getWidth(), 100);
        reset.setText("Recommencer");
        add(grille, BorderLayout.CENTER); //Place la grille

        add(reset, BorderLayout.SOUTH); //Place le bouton reset

        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    

    public Vue(int d, int lon, int lar) {//creation de la fenetre de jeu
        victoire = false;
        this.haut = lon;
        this.largeur = lar;
        this.difficulte = d;
        cases = new Case[lar][lon];

        reset = new JButton();

        grille = new Grille(this); //Cree une nouvelle grille avec les parametres recupérés lignes 117 a 119
        reset.setSize(grille.getWidth(), 100);//taille du bouton reset(recommencer)
        reset.setText("Recommencer");
        add(grille, BorderLayout.CENTER); //Place la grille

        add(reset, BorderLayout.SOUTH); //Place le bouton recommencer en bas

        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
    
    public int getDifficulte() { //les 3 methodes pour recuperer la taille de la grille et la diffictulté(nb bombes)
        return this.difficulte;
    }

    public int gethaut() {
        return this.haut;
    }

        public int getLargeur() {
        return this.largeur;
    }

    public JButton getreset() {
        return this.reset;
    }
    
    public boolean victoire() {
        return victoire;
    }

    public void winlose() {
        victoire = false;
    }

}
