package main;

import javax.swing.JOptionPane;

public class ArithMain
{
    private static int correct = 0;
    private static int num = 1;
    private static int questions = 0;
 
    public static void main(String[] args) {
        try {
            questions = Integer.parseInt(JOptionPane.showInputDialog("how many questions"));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "you buffoon");
        }
        int a = 0;
        int b = 0;
        int type = 0;
        for (int i = 0; i < questions; ++i) {
            a = (int)(Math.random() * 10.0);
            b = (int)(Math.random() * 10.0);
            type = (int)(Math.random() * 4.0);
            if (type == 0) {
                add(a, b);
            }
            else if (type == 1) {
                sub(a, b);
            }
            else if (type == 2) {
                mult(a, b);
            }
            else {
                div(a, b);
            }
            ++num;
        }
        JOptionPane.showMessageDialog(null, "you got " + correct + " / " + questions + " questions correct");
    }
    
    private static void add(int a, int b) {
        int answer = a + b;
        String q = JOptionPane.showInputDialog("question " + num + ": " + a + " + " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                questions = num;
            }
            else if (Integer.parseInt(q) == answer) {
                JOptionPane.showMessageDialog(null, "correct");
                ++correct;
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong");
        }
    }
    
    private static void sub(int a, int b) {
        while (b > a) {
            b = (int)(Math.random() * 10.0);
            a = (int)(Math.random() * 10.0);
        }
        int answer = a - b;
        String q = JOptionPane.showInputDialog("question " + num + ": " + a + " - " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                questions = num;
            }
            else if (Integer.parseInt(q) == answer) {
                JOptionPane.showMessageDialog(null, "correct");
                ++correct;
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong");
        }
    }
    
    private static void mult(int a, int b) {
        int answer = a * b;
        String q = JOptionPane.showInputDialog("question " + num + ": " + a + " * " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                questions = num;
            }
            else if (Integer.parseInt(q) == answer) {
                JOptionPane.showMessageDialog(null, "correct");
                ++correct;
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong");
        }
    }
    
    private static void div(int a, int b) {
        while (b == 0) {
            b = (int)(Math.random() * 10.0);
        }
        int answer = a * b / b;
        String q = JOptionPane.showInputDialog("question " + num + ": " + a * b + " / " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                questions = num;
            }
            else if (Integer.parseInt(q) == answer) {
                JOptionPane.showMessageDialog(null, "correct");
                ++correct;
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong");
        }
    }
}
