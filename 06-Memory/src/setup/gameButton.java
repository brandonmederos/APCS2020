
package setup;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * This is a custom GameButton class which uses
 * getters and setters to and a compare method 
 */
@SuppressWarnings("serial")
public class gameButton extends JButton
{
    private ImageIcon _i;
    
    public gameButton() {
    }
    
    public void setImg(final ImageIcon iicon) {
       _i = iicon;
    }
    
    public ImageIcon getImg() {
        return _i;
    }
    
    public boolean matches(final gameButton g) {
        return _i.equals(g._i);
    }
}
