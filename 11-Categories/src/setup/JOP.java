
package setup;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOP
{
    public void msg(final String msg, final String title) {
        JOptionPane.showMessageDialog(null, msg, title, -1);
    }
    
    public void msg(final String msg, final String title, final ImageIcon icon) {
        JOptionPane.showMessageDialog(null, msg, title, -1, icon);
    }
    
    public String in(final String msg) {
        return JOptionPane.showInputDialog(null, msg, null, -1);
    }
    
    public int option(final ImageIcon[] options, final String msg, final String title, final ImageIcon icon) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, icon, options, options[0]);
    }
    
    public int option(final ImageIcon[] options, final String msg, final String title) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, null, options, options[0]);
    }
    
    public int option(final ImageIcon[] options, final String msg, final String title, final int initialValue) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, null, options, options[initialValue]);
    }
    
    public int option(final String[] options, final String msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, null, options, options[0]);
    }
    
    public int option(final String[] options, final String msg, final ImageIcon icon) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, icon, options, options[0]);
    }
    
    public int option(final String[] options, final String msg, final String title) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, null, options, options[0]);
    }
    
    public int option(final String[] options, final String msg, final String title, final ImageIcon icon) {
        return JOptionPane.showOptionDialog(null, msg, title, -1, -1, icon, options, options[0]);
    }
    
    public void println(final String msg) {
        System.out.println(msg);
    }
    
    public void print(final String msg) {
        System.out.println(msg);
    }
    
    public void msg(final Object msg) {
        JOptionPane.showMessageDialog(null, msg, null, -1);
    }
    
    public String in(final Object msg) {
        return JOptionPane.showInputDialog(msg, -1);
    }
    
    public int option(final Object[] options, final Object msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, null, options, options[0]);
    }
}
