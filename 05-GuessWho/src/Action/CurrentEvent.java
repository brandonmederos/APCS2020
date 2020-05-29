
package Action;

import CharacterHandler.Checker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import setup.GWFrame;
import setup.gameButton;

public class CurrentEvent implements ActionListener {
	/*--------------*/
	int max_tries = 5;
	/*--------------*/
	
    private static String[] op = new String[]{"Play Again", "Exit"};

    /*
     * This method is the ActionListener for all the UI buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ++GWFrame.wrongGuesses;
        String character = ((gameButton)e.getSource()).getString();
        if (Checker.isCorrect(character)) {
        	//If Correct
            GWFrame.wrongGuesses = 0;
            GWFrame.checkNum("You Guessed Correctly!!\n\r \n\rCongratulations!\n\r \n\rExiting...", op, new int[0]);
        } else {
        	//If wrong
            GWFrame.count.setText("Wrong Guesses: " + GWFrame.wrongGuesses);
            JOptionPane.showMessageDialog(null, "You Guessed Incorrect", "", -1);
            
            if (GWFrame.wrongGuesses >= max_tries) {
            	//If reaches the max_tries
                System.out.println("MAX TRIES");
                GWFrame.wrongGuesses = 0;
                for (int i = 0; i < GWFrame.buttys.length; ++i) {
                    for (int ii = 0; ii < GWFrame.buttys[i].length; ++ii) {
                        GWFrame.buttys[i][ii].setEnabled(false);
                    }
                }
                GWFrame.wrongGuesses = 0;
                //Restarts the game if reaches max_tries
                GWFrame.checkNum("You have reached the max attempts \n\r\n\rWould you like to play again?", GWFrame.getPlayagain(), new int[0]);
            }
        }
    }
}

