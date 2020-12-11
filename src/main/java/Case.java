
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
        double j = (10-difficulte)*Math.random();
        int k = (int) j;
        this.presencebombe = false;
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
