
package controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class gameTile extends JPanel
{
    private JLabel _imgPane;
    
    public JLabel getImgPane() {
        return this._imgPane;
    }
    
    public gameTile() {
        this.add(this._imgPane = new JLabel());
    }
}
