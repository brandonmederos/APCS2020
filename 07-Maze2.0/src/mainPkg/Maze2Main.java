
package mainPkg;

import setup.Maze2Frame;

public class Maze2Main{
	/*
	 * This main method uses if the boolean to start the program and then to
	 * check if the it is the lose or continue condition
	 */
    public static void main(String... a) {
        run(true);
    }
    
    public static void run(boolean yes) {
        new Maze2Frame(yes);
    }
}
