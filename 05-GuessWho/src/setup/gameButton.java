
package setup;

import CharacterHandler.AspectList;
import javax.swing.JButton;

/*
 * This Class is made as a custom button which can contain 
 * the aspect and name for the characters
 */
@SuppressWarnings("serial")
public class gameButton extends JButton {
    private String _s = "";
    private AspectList _c;

    public gameButton(String s, AspectList c) {
       _s = s;
       _c = c;
    }

    public String getString() {
        return _s;
    }

    public AspectList getCharacter() {
        return _c;
    }
}

