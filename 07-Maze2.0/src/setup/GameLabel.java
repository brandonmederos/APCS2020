
package setup;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * This Class is used to creates a custom label which 
 * we use to store the conditions for the main game
 */
@SuppressWarnings("serial")
public class GameLabel extends JLabel{
    private ImageIcon _i;
    
    public GameLabel() {
    }
    
    public GameLabel(ImageIcon i) {
        _i = i;
    }
    
    public ImageIcon getImage() {
        return _i;
    }
    
    public void setImage(ImageIcon i) {
        setIcon(i);
        _i = i;
    }
    
    public boolean matches(GameLabel g) {
        return _i.equals(_i);
    }
}
