
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// @author RICHARD nicolas et SAVOYE Valentin
public class Actions implements ActionListener, MouseListener {

    private Vue vue;

    Actions(Vue vue) {
        this.vue = vue;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

 

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vue.winlose();
        vue.NouvelleGrille();
        vue.refresh();
    }

    
    @Override
    public void mouseClicked(MouseEvent e){

        int x = e.getX() / 20;
        int y = e.getY() / 20;

            vue.selection(x,y);

        
 
 
        vue.refresh();
    }

 
}
 
