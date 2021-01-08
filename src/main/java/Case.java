
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
//@author RICHARD nicolas et SAVOYE Valentin
public class Case {


   
    private int a;
    private boolean presencebombe; 
    private boolean montrer;

    public Case(int difficulte) {
        // initialisation des variables d'instance
     
        this.a=0;
        double j = (10-difficulte)*Math.random();  // on initialise selon la difficulté le nombre de bombe sur la grille plus le nombre de difficulté est élevé plus la chance d'avoir une bombe 
        int k = (int) j;                           // sur une des cases est élevé elle aussi 
        this.presencebombe = false;                // De plus on verifie que la case n'a pas deja une bombe associé 
        if (k == 0) {
            this.presencebombe = true;
        }
        this.montrer = false;
    }

    public boolean presencebombe() {
        return this.presencebombe;
    }
    public void putnumber(int y)
    {
        this.a = y;
    }
    public int getnumber()
    {
        return this.a;
    }

    public void montrer() {
        this.montrer = true;
    }

    public boolean montre() {
        return this.montrer;
    
}
}
