
package setup;

import javax.swing.JOptionPane;

public class Window
{
    public void msg(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, -1);
    }
    
    public String in(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }
    
    public int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, -1, null, options, options[0]);
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
