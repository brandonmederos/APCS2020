
package CharacterHandler;

import setup.GWFrame;
/*
 * This Class handles creating a random player for the user to guess for
 */
public class Checker {
    private static AspectList randomPlayer;

    public static AspectList randomP() {
        int cnt = (int)(Math.random() * (double)AspectList.CHARACTERS.length);
        randomPlayer = AspectList.CHARACTERS[cnt];
        return randomPlayer;
    }

    public static boolean isCorrect(String s) {
        return s.equals(GWFrame.selectedPlayer.getName());
    }
}

