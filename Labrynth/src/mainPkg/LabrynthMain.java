
package mainPkg;

import javax.swing.JOptionPane;
import controller.Frame;
import javax.swing.JFrame;

public class LabrynthMain
{
    static JFrame j;
    
    static {
        LabrynthMain.j = new Frame();
    }
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome To the Riddler's Labyrnth!!\r\nFor Help Press the Help (?) Button and Follow Along! \r\nGood Luck!");
        LabrynthMain.j.setVisible(true);
        LabrynthMain.j.setSize(1200, 600);
        LabrynthMain.j.setDefaultCloseOperation(3);
    }
}
