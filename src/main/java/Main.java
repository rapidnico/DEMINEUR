
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RICHARD nicolas et SAVOYE Valentin
 */
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int difficulte = 0;  // on initialise la difficulté ainsi que les tailles de la largeur et de longueur qu'on demendera de rentrer 
        int l = 0;
        int h = 0;

        do {
            System.out.println("Veuillez saisir la difficulté (de 1 à 5) :");
            int str = sc.nextInt();  // On va faire rentrer un entier avec cette fonction qui determinera la difficulté   
            if (str < 6 && str > 0) {
                difficulte = str;
            }
        } while (difficulte == 0);
        do {
            System.out.println("Veuillez saisir le nombre de cases en largeur (de 2 à 60) :");
            int str = sc.nextInt();  // On va prendre la valeur rentrée et l'associer à la longueur de la grille
            if (str < 61 && str > 1) { // On verifie que la valeur rentré est bien à la norme 
                l = str;
            }
        } while (l == 0);
        do {
            System.out.println("Veuillez saisir le nombre de cases en hauteur (de 2 à 30) :");
            int str = sc.nextInt();  // On va prendre la valeur rentrée et l'associer à la hauteur de la grille
            if (str < 31 && str > 1) {  // On verifie que la valeur rentré est bien à la norme 
                h = str;
            }
        } while (h == 0);

        Vue vue = new Vue(difficulte, h, l);
    }
}
