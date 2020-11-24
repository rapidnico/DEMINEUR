import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Case
{
    
    private int n;
    private boolean isBomb; 
    private boolean isShown;

    
    public Case(int diff)
    {
        // initialisation des variables d'instance
       
        this.n=0;
        double j = (10-diff)*Math.random();
        int k = (int) j;
        this.isBomb = false;
        if(k==0){
            this.isBomb = true;
        }
        this.isShown = false;
    }

    public boolean isbomb()
    {
        return this.isBomb;
    }
    public void putnumber(int y)
    {
        this.n = y;
    }
    public int getnumber()
    {
        return this.n;
    }
    public void show()
    {
       this.isShown = true;
    }
    public boolean shown()
    {
       return this.isShown;
    }
}
