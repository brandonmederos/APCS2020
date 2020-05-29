
package setup;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * This class creates a custom button for the game which can hold 'enums' and a 
 * string for diagnostics
 */
@SuppressWarnings("serial")
public class gameButton extends JButton{
    private Choices _c;
    private String _s;
       
    //Constructors
    public gameButton(ImageIcon i) {
        super(i);
    }   
    public gameButton(Choices c, ImageIcon i) {
        super(i);
        _c = c;
    }
    
    /*
     * This method is used as a setter to set the Choice variable
     */
    public void setChoice( Choices choice) {
        _c = choice;
    }
    
    /*
     * This method is used as a getter to get the choice variable
     */
    public Choices getChoice() {
        return _c;
    }
    
    @Override
    public String toString() {
        return _s;
    }
}
