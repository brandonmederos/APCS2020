
package cont;

import view.Window;

public class Overseer
{
    private static Window _w = new Window();
    static int correct = 0;
    private static int _num = 1;
    private static int _questions = 0;
    private static int x = 1;
    
    //Constructor
    public Overseer() {
        while (x == 1) {
            try {
                String ihp = _w.in("There is a number of questions you wish yes \n:) Input that number please: ");
                if (!ihp.equalsIgnoreCase("exit")) {
                    _questions = Integer.parseInt(ihp);
                }
                else {
                    x = 0;
                }
            }
            catch (Exception e) {
                _w.msg("THAT'S NOT A NUMBER Dum-Bee");
            }
            int a = 0;
            int b = 0;
            int type = 0;
            for (int i = 0; i < _questions; ++i) {
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
                ++_num;
            }
            if (_questions > 0) {
                _w.msg("You actually got " + correct + " / " + _questions + " questions correct \n" + "Good Job! I give you A: " + _questions + "/" + _questions);
                x = 0;
            }
        }
    }
    
    
    /*
     * This Method handles all the questions that deal with addition,
     * the method creates a string that asks a random question, asks the 'player' to answer
     * the correct answer then parses the user's response and checks whether it matches the answer
     */
    private static void add(int a, int b) {
        int answer = a + b;
        String q = _w.in("Q " + _num + ": " + a + " + " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                _questions = _num;
                x = 0;
            }
            else if (Integer.parseInt(q) == answer) {
                _w.msg("BUENO!!");
                ++correct;
            }
            else {
                _w.msg("Errrrrorrr Wrong :(");
            }
        }
        catch (Exception e) {
            _w.msg("NO Sirrie");
        }
    }
    
    /*
     * This Method handles all the questions that deal with subtraction,
     * the method creates a string that asks a random question, asks the 'player' to answer
     * the correct answer then parses the user's response and checks whether it matches the answer
     */
    private static void sub(int a, int b) {
        while (b > a) {
            b = (int)(Math.random() * 10.0);
            a = (int)(Math.random() * 10.0);
        }
        int answer = a - b;
        String q = _w.in("Q " + _num + ": " + a + " - " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                _questions = _num;
                x = 0;
            }
            else if (Integer.parseInt(q) == answer) {
                _w.msg("Correct!");
                ++correct;
            }
            else {
                _w.msg("NO MENG!");
            }
        }
        catch (Exception e) {
            _w.msg("OYE YAAAA youre wrong chico/a");
        }
    }
    
    /*
     * This Method handles all the questions that deal with multiplication,
     * the method creates a string that asks a random question, asks the 'player' to answer
     * the correct answer then parses the user's response and checks whether it matches the answer
     */
    private static void mult(int a, int b) {
        int answer = a * b;
        String q = _w.in("Q " + _num + ": " + a + " * " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                _questions = _num;
                x = 0;
            }
            else if (Integer.parseInt(q) == answer) {
                _w.msg("Gracias for being Smart");
                ++correct;
            }
            else {
                _w.msg("okay but no.");
            }
        }
        catch (Exception e) {
            _w.msg("alr really....");
        }
    }
    
    /*
     * This Method handles all the questions that deal with division,
     * the method creates a string that asks a random question, asks the 'player' to answer
     * the correct answer then parses the user's response and checks whether it matches the answer
     */
    private static void div(int a, int b) {
        while (b == 0) {
            b = (int)(Math.random() * 10.0);
        }
        int answer = a * b / b;
        String q = _w.in("Q " + _num + ": " + a * b + " / " + b);
        try {
            if (q.equalsIgnoreCase("exit")) {
                _questions = _num;
                x = 0;
            }
            else if (Integer.parseInt(q) == answer) {
                _w.msg("THANK THE LORD!!");
                ++correct;
            }
            else {
                _w.msg("You deserve this: here ':('");
            }
        }
        catch (Exception e) {
            _w.msg("Just Exit.. type 'exit' dammit");
        }
    }
}
