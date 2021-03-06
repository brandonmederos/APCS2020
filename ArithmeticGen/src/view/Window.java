package view;

import javax.swing.JOptionPane;

//This Class Handles all the JOP methods
public class Window
{
    public void msg(final String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String in(final String msg) {
        return JOptionPane.showInputDialog(msg);
    }
    
    public int option(final String[] options, final String msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, 1, null, options, options[0]);
    }
    
    public void println(final String msg) {
        System.out.println(msg);
    }
    
    public void print(final String msg) {
        System.out.println(msg);
    }
    
    public void msg(final Object msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String in(final Object msg) {
        return JOptionPane.showInputDialog(msg);
    }
    
    public int option(final Object[] options, final Object msg) {
        return JOptionPane.showOptionDialog(null, msg, "Click a button", -1, 1, null, options, options[0]);
    }
}
