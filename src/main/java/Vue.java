
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
 * @author louise LAURENT
 */
public class Vue extends JFrame
{
    private int difficulte;
    private int haut;
    private int larg;
    private Case[][] cases;
    private Grille grille;
    private JButton reset;
    private boolean win;
    
 
 
    public void selection(int x, int y){ 
 
        
        cases[x][y].show();
        if (cases[x][y].getnumber()==0){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if (x+i>0&&x-1+i<this.larg&&y+j>0&&y-1+j<this.haut){
                        
                    if (!cases[x-1+i][y-1+j].shown()){
                        this.selection(x-1+i,y-1+j);
                    }
                    }
                }
            }
        }
        if (cases[x][y].isbomb())
        {
            
            lose();
            this.refresh();
        }
        int com=0;
       
        for(int i=0;i<this.larg;i++){
            for(int j=0;j<this.haut;j++){
                if (cases[i][j].isbomb()||cases[i][j].shown()){
                    com++;
                }
            }
        }
        if(com==this.larg*this.haut){
            this.win = true;
        }
        
        
    }
    public Case[][] getCases(){
        return cases;
    }
    public void refresh(){ //Actualise
        grille.repaint();
    }
    public void lose(){ 
        for(int i=0;i<this.larg;i++){
            for(int j=0;j<this.haut;j++){
                cases[i][j].show();
            }
        }
    }
    public boolean win(){ 
        return win;
    }
    public void winlose(){ 
        win = false;
    }
    public void newgrille(){ 
        grille = new Grille(this); //Cree une nouvelle grille
        reset.setSize(grille.getWidth(), 100);
        reset.setText("Recommencer");
        add(grille, BorderLayout.CENTER); //Place la grille
        
        add(reset, BorderLayout.SOUTH); //Place la grille
        
        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
    public int getd(){ 
        return this.difficulte;
    }
    public int gethaut(){ 
        return this.haut;
    }
    public int getlar(){ 
        return this.larg;
    }
    public JButton getreset(){ 
        return this.reset;
    }
    public Vue(int d,int lon,int lar){
        win = false;
        this.haut = lon;
        this.larg = lar;
        this.difficulte = d;
        cases = new Case[lar][lon];
 
        reset = new JButton();
        
        grille = new Grille(this); //Cree une nouvelle grille
        reset.setSize(grille.getWidth(), 100);
        reset.setText("Recommencer");
        add(grille, BorderLayout.CENTER); //Place la grille
        
        add(reset, BorderLayout.SOUTH); //Place la grille
        
        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
    
}