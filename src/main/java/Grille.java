
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

 // @author RICHARD nicolas et SAVOYE Valentin

public class Grille extends JPanel
{
    private Case[][] cases;
    private Vue vue;
    
    public Grille(Vue vue)
    {
        this.vue = vue;
        cases = vue.getCases();
        for (int i=0;i<vue.getLargeur();i++){
            for (int j=0;j<vue.gethaut();j++){
                cases[i][j] = new Case(vue.getDifficulte());
            }
        }
        for (int i=0;i<vue.getLargeur();i++){
            for (int j=0;j<vue.gethaut();j++){
                for (int k=0;k<3;k++){
                    for (int l=0;l<3;l++){
                        if(i-1+k>=0&&j-1+l>=0&&i-1+k<vue.getLargeur()&&j-1+l<vue.gethaut()){
                            if(cases[i-1+k][j-1+l].isbomb()){
                                cases[i][j].putnumber(cases[i][j].getnumber()+1);
                            }
                        }
                    }
                }
            }
        }
        
        this.vue = vue;
        cases = vue.getCases();
 
        addMouseListener(new Actions(this.vue));
        JButton button = (JButton) vue.getreset();
        button.addActionListener(new Actions(this.vue)); 
 
        setPreferredSize(new Dimension(20*vue.getLargeur(), 20*vue.gethaut()));
        
    }
    @Override
    public void paintComponent(Graphics g){
 
        cases = vue.getCases();
 
        for (int i = 0; i <vue.getLargeur(); i++){
 
            for (int j = 0; j < vue.gethaut(); j++){
 
                Case current = cases[i][j];
 

                if (!current.shown()){ 
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.setColor(Color.BLACK);
                }
                else if (current.isbomb()){ 
                    g.setColor(Color.RED);
                    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.setColor(Color.BLACK);
                    g.drawLine(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.drawLine(i * 20, j * 20 + 20, i * 20 + 20, j * 20);
                }
                else{ 
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.setColor(Color.BLACK);
                }
 
                
 
                if (current.shown()&&!current.isbomb()){
                    if (current.getnumber() == 1){
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                    }
                    else if (current.getnumber() == 2){
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);    
                        g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);    
                    }
                    else if (current.getnumber() == 3){
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);   
                        g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);    
                    }
                    else if (current.getnumber() == 4){
                        g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);        
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                    }
                    else if (current.getnumber() == 5){
                        g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);        
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                        g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);    
                    }
                    else if (current.getnumber() == 6){
                        g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);        
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                        g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);    
                    }
                    else if (current.getnumber() == 7){
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                    }
                    else if (current.getnumber() == 8){
                        g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);        
                        g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);    
                        g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);    
                        g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);    
                        g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);    
                        g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);    
                        g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);    
                    }
                }
                if(vue.victoire()){
                    if(current.isbomb()){
                        g.setColor(Color.RED);
                        g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                        g.setColor(Color.BLACK);
                    }
                    else{
                        g.setColor(Color.YELLOW);
                        g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                        g.setColor(Color.BLACK);
                    }
                }
                g.setColor(Color.BLACK);
                g.drawRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
            }
        }
    }
    
    
    
    
    
}
