
package setup;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * This class is used as a window class which is is for convenience for JOptionPane
 */
public class JOP
{
    public void msg(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, -1);
    }
    
    public void msg(String msg, String title, ImageIcon icon) {
        JOptionPane.showMessageDialog(null, msg, title, -1, icon);
    }
    
    public String in(String msg) {
        return JOptionPane.showInputDialog(null, msg, null, -1);
    }
    
    public int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, null, options, options[0]);
    }
    
    public int option(String[] options, String msg, ImageIcon icon) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, icon, options, options[0]);
    }
    
    public int option(String[] options, String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, null, options, options[0]);
    }
    
    public int option(String[] options, String msg, String title, ImageIcon icon) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, icon, options, options[0]);
    }
    
    public void println(String msg) {
        System.out.println(msg);
    }
    
    public void print(String msg) {
        System.out.println(msg);
    }
    
    public void msg(Object msg) {
        JOptionPane.showMessageDialog(null, msg, null, -1);
    }
    
    public String in(Object msg) {
        return JOptionPane.showInputDialog(msg, -1);
    }
    
    public int option(Object[] options, Object msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, null, options, options[0]);
    }
}
