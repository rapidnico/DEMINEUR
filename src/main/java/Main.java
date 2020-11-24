
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author louise Laurent
 */

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int diff=0;
        int l=0;
        int h = 0;
        
        do{
        System.out.println("Veuillez saisir la difficulté (de 1 à 5) :");
        int str = sc.nextInt();
            if(str<6&&str>0){
                diff = str;
            }
        }while(diff==0);
        do{
        System.out.println("Veuillez saisir le nombre de cases en largeur (de 2 à 60) :");
        int str = sc.nextInt();
            if(str<61&&str>1){
                l = str;
            }
        }while(l==0);
        do{
        System.out.println("Veuillez saisir le nombre de cases en hauteur (de 2 à 30) :");
        int str = sc.nextInt();
            if(str<31&&str>1){
                h = str;
            }
        }while(h==0);
        
        Vue vue = new Vue(diff,h,l);
    }
}
