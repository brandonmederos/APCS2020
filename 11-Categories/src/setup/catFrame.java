
package setup;

import java.awt.event.ActionEvent;
import java.awt.Font;
import Images.ImageList;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class catFrame{
	
	/************\
	**	ints	**
	\************/
    private int curPlayer;
    private int curMode;
    private int p1Wins;
    private int p2Wins;
    private int ties;
    private int games;
    
    /************\
    **	JFrame	**
    \************/
    private JFrame _frame;
    private JPanel _bg;
    private JPanel _pan;
    private JLabel _text;   
    
    /****************\
    **	Variables	**
    \****************/
    private static JOP _j = new JOP();
    private boolean nextRound;
    private ActionListener doo;
    private ActionListener exit;
    
    /************\
    **	Arrays	**
    \************/
    private gameButton[] _buttons;
    private ImageIcon[] images;
    private Choices player1;
    private Choices player2;
    private Choices player3;
    private Choices player4;
    private Choices[] choice;
    private Choices[] players;
    
    //Constructor
    public catFrame() {
		curPlayer = 0;
		p1Wins = 0;
		p2Wins = 0;
		ties = 0;
		games = 0;
		nextRound = false;
		choice = new Choices[] { Choices.PEN, Choices.SCROLL, Choices.SWORD, Choices.SHIELD, Choices.MACE };
		images = new ImageIcon[] { ImageList.pen, ImageList.scroll, ImageList.sword, ImageList.shield, ImageList.mace };
		players = new Choices[] { player1, player2, player3, player4 };
		/************\
		**	JFrame	**
		\************/
		_frame = new JFrame("Categories Multiplayer");
		_bg = new JPanel(new GridLayout(2, 1));
		_pan = new JPanel(new GridLayout(2, 2));
		_text = new JLabel();
		_frame = new JFrame("Categories Multiplayer");
		_bg = new JPanel(new GridLayout(2, 1));
		_pan = new JPanel(new GridLayout(2, 2));
		_text = new JLabel();
		setupActions();
		ask();
		setupFrame();
    }
    
    /*
     * This method is used to set up the background of the JFrame
     */
    private void setupBackground() {
        _bg.add(_text);
        _bg.add(_pan);
    }
    
    /*
     * This method is used to add all the components to the Frame
     */
    private void setupFrame() {
        setupButtons();
        setupBackground();
        _frame.add(_bg);
        _frame.setDefaultCloseOperation(3);
        _frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
    }
    
    /*
     * This method is used to ask the player which mode they would like to play and
     * instantiates the corresponding variables to it's mode
     */
    private void ask() {
        String[] asker = { "Player vs. Player", "Player vs. AI", "Multiplayer" };
        int y = _j.option(asker, "Player vs. Player: You and a friend battle it out to see who wins the 'Categories Game'\n----\nPlayer vs. AI: You battle against an AI to see if you can beat the computer!\n----\nMultiplayer: This mode is in Beta but this is a 4 player gamemode where you vs 3 buddies (or foes)", "Who is your Foe? ");
        if (y == 0) {
            System.out.println("1v1");
            plyvply();
            curMode = 0;
        }
        else if (y == 1) {
            System.out.println("AI");
            aiPlayer();
            curMode = 1;
        }
        else if (y == 2) {
            System.out.println("Multiplayer");
            plymultiplyr();
            curMode = 2;
        }
        else {
            System.exit(0);
        }
    }
    
    /*
     * This method is used for when the player selects the 'Player Vs. Player' mode
     */
    public void plyvply() {
        String s = null;
        if (nextRound) {
            System.out.println("Current Leader: " + s);
            if (games > 2) {
                games = 0;
                if (p1Wins > p2Wins) {
                    _j.msg(null, "Player 1 Beat Player 2", ImageList.win);
                }
                else if (p1Wins == p2Wins) {
                    _j.msg(null, "Players Tied", ImageList.tie);
                }
                else {
                    _j.msg(null, "Player 2 Beat Player 1", ImageList.loss);
                }
                p1Wins = 0;
                p2Wins = 0;
                ties = 0;
                _j.msg("Next Round has Begun");
            }
            for (int i = 0; i < players.length; ++i) {
                players[i] = null;
            }
            nextRound = false;
            ++games;
            System.out.println("Reset");
        }
        if (p1Wins > p2Wins) {
            s = "PLAYER 1";
        }
        if (p2Wins > p1Wins) {
            s = "PLAYER 2";
        }
        _text.setFont(new Font("Times New Roman", 1, 32));
        _text.setHorizontalAlignment(0);
        _text.setVerticalAlignment(0);
        _text.setText("<html>Leader: " + s + "<br/><html> Ties: " + ties + " <br/>Games Played: " + games + " / 3<br/><html>Player 1 Wins: " + p1Wins + "<html><br/> Player 2 Wins: <html>" + p2Wins + "<br/>Player " + (curPlayer + 1) + "'s Turn: </html>");
    }
    
    /*
     * This method is used for when the player would like to play the 'AI' the AI selects a random 
     * category and the player must attempt to win.
     */
    private void aiPlayer() {
        String s = null;
        Choices[] choi = { Choices.PEN, Choices.SCROLL, Choices.SWORD, Choices.SHIELD, Choices.MACE };
        int rand = (int)(Math.random() * choi.length);
        if (games > 2) {
            games = 0;
            if (p1Wins > p2Wins) {
                _j.msg(null, "You Beat the AI", ImageList.win);
            }
            else if (p1Wins == p2Wins) {
                _j.msg(null, "You and the AI Tied Wins/Losses", ImageList.tie);
            }
            else {
                _j.msg(null, "The AI Beat You", ImageList.loss);
            }
            p1Wins = 0;
            p2Wins = 0;
            ties = 0;
            _j.msg("Next Round has Begun");
        }
        if (p1Wins > p2Wins) {
            s = "PLAYER";
        }
        if (p2Wins > p1Wins) {
            s = "AI";
        }
        players[1] = choi[rand];
        _text.setFont(new Font("Times New Roman", 1, 32));
        _text.setHorizontalAlignment(0);
        _text.setVerticalAlignment(0);
        _text.setText("<html>Leader: " + s + "<br/><html> Ties: " + ties + " <br/>Games Played: " + games + " / 3<br/><html>Player 1 Wins: " + p1Wins + "<html><br/> AI Wins: <html>" + p2Wins + "<br/>Player's Turn: </html>");
        ++games;
    }
    
    /*
     * This method is not yet implemented and is for the multiplayer aspect
     * for parties >2
     */
    private void plymultiplyr() {
        _j.msg("No Work :)");
        System.exit(0);
    }
    
    /*
     * This method is used to create each of the buttons and add their action
     */
    private void setupButtons() {
        _buttons = new gameButton[choice.length + 1];
        for (int i = 0; i < choice.length; ++i) {
            (_buttons[i] = new gameButton(choice[i], images[i])).setBorderPainted(false);
            _buttons[i].setFocusable(false);
            _buttons[i].addActionListener(doo);
            _pan.add(_buttons[i]);
        }
        (_buttons[_buttons.length - 1] = new gameButton(ImageList.exit)).addActionListener(exit);
        _buttons[_buttons.length - 1].setBorderPainted(false);
        _buttons[_buttons.length - 1].setFocusable(false);
        _pan.add(_buttons[_buttons.length - 1]);
    }
    
    /*
     * This method is used to setup the two action listeners for the various buttons, one of which are
     * the exit: which ends the game, and the
     * the buttons: which record the input and set that as the player's response.
     */
    private void setupActions() {
		exit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit");
				System.exit(0);
				
			}
		};
		doo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Choices cho = ((gameButton) e.getSource()).getChoice();
				if(curMode == 0) {
					players[curPlayer] = cho;
					System.out.println("Player: " + (curPlayer+1) + " Choice: " + players[curPlayer]);
					if(curPlayer > 1) {
						curPlayer =0;
						nextRound = true;
					}
					allPlayers();	
				}
				if(curMode == 1) {
					players[curPlayer] = cho;
					System.out.println("Player: " + (curPlayer+1) + " Choice: " + players[curPlayer]);
					if(curPlayer > 0) {
						curPlayer =0;
						nextRound = true;
					}
					allPlayers();	
				}
		
			}
		};
	}
    
    /*
     * This method is used to handle the winning and losing conditions of whether the player beat the other
     * player whether it be AI, or 'Player 2'
     */
    private void allPlayers() {
        if (curMode == 0) {
            if (players[curPlayer] != null && curPlayer < 1) {
                ++curPlayer;
            }
            else if (curPlayer == 1) {
                curPlayer = 0;
            }
            if (players[curPlayer] != null && players[curPlayer + 1] != null) {
                players[curPlayer].beats(players[curPlayer + 1]);
                if (Choices.tie) {
                    nextRound = true;
                    _j.msg("Player " + (curPlayer + 1) + " & " + "Player " + (curPlayer + 2) + " Tied");
                    Choices.tie = false;
                    ++ties;
                }
                else if (players[curPlayer].beats(players[curPlayer + 1])) {
                    nextRound = true;
                    _j.msg("Player " + (curPlayer + 1) + " Wins");
                    ++p1Wins;
                }
                else if (!players[curPlayer].beats(players[curPlayer + 1]) && !Choices.tie) {
                    nextRound = true;
                    _j.msg("Player " + (curPlayer + 1) + " Lost");
                    ++p2Wins;
                }
            }
            plyvply();
        }
        else if (curMode == 1) {
            if (players[curPlayer] != null) {
                players[curPlayer].beats(players[curPlayer + 1]);
                System.out.println("Player: AI Choice: " + players[1]);
                if (Choices.tie) {
                    nextRound = true;
                    _j.msg(null, "You & the AI Tied", ImageList.ai);
                    Choices.tie = false;
                    ++ties;
                }
                else if (players[curPlayer].beats(players[curPlayer + 1])) {
                    nextRound = true;
                    _j.msg(null, "You beat the AI", ImageList.beatai);
                    ++p1Wins;
                }
                else if (!players[curPlayer].beats(players[curPlayer + 1]) && !Choices.tie) {
                    nextRound = true;
                    _j.msg(null, "You lost to the AI", ImageList.ai);
                    ++p2Wins;
                }
                aiPlayer();
            }
        }
        else {
            plymultiplyr();
            plymultiplyr();
        }
    }
    
   
}
