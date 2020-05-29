
package setup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import mainPkg.GWMain;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.awt.Font;
import Action.CurrentEvent;
import java.awt.GridLayout;
import QuestionHandling.QuestionList;
import resources.EmptyClass;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import CharacterHandler.AspectList;
import CharacterHandler.Checker;
import Images.ImageList;
import QuestionHandling.Question;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GWFrame extends JFrame {
	
	/************\
	**	Images	**
	\************/
	private static ImageIcon RX = new ImageIcon(EmptyClass.class.getResource("redXs.png"));
	private static ImageIcon bg = new ImageIcon(EmptyClass.class.getResource("bg.png"));
	private static ImageIcon bye = new ImageIcon(EmptyClass.class.getResource("bye.gif"));
	/****************\
	**	Variables	**
	\****************/
	public static int wrongGuesses = 0;
	public static int counter = 0;
	public static int currentQ = -1;
	private static boolean setVis1 = false;
	private ActionListener action;
	
	/********************\
	**	Lists/Arrays	**
	\********************/
	public static ArrayList<Question> qList = QuestionList.getQList();
	public static AspectList selectedPlayer;
	private static ImageList IL = new ImageList();
	private static String[] playagain = new String[] { "Play Again", "Exit Game" };
	private static String[] characters = new String[] { "Alex", "Alfred", "Anita", "Anne", "Bernard", "Bill", "Charles",
			"Claire", "David", "Eric", "Frans", "George", "Herman", "Joe", "Maria", "Max", "Paul", "Peter", "Philip",
			"Richard", "Robert", "Sam", "Susan", "Tom" };
	
	/************\
	**	JFRAME	** 
	\************/
	public static JFrame frem;
	private static JLabel background = new JLabel();
	private static JPanel frameBG = new JPanel();
	private static JPanel buttons = new JPanel(new GridLayout(4, 6));
	private static JPanel QandA = new JPanel(new GridLayout(2, 1));
	private static JLabel XS = new JLabel(RX);
	private static JLabel theQuestion = new JLabel();
	public static gameButton[][] buttys = new gameButton[4][6];
	private static JPanel yesnonextQ = new JPanel(new GridLayout(1, 2));
	private static JButton ask = new JButton("Ask Question");
	private static JButton nextQ = new JButton("Display Question/Next Question");
	private static JButton prevQ = new JButton("Display Question/Prev Question");
	public static JButton count = new JButton("Wrong Guesses: " + wrongGuesses);
	
		
	// Getter for characters
	public String[] getCharacters() {
		return characters;
	}

	//Getter for the playagain
	public static String[] getPlayagain() {return playagain; }
	
	// Constructor
	public GWFrame() {
		super("Guess Who");
		this.action = new CurrentEvent();
		GWFrame.frem = this;
		GWFrame.selectedPlayer = Checker.randomP();
		GWFrame.background.setIcon(GWFrame.bg);
		System.out.println(GWFrame.selectedPlayer.getName());

		// Constructs the Frame
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		GWFrame.background.setBounds(0, 0, 1200, 600);
		GWFrame.XS.setBounds(0, 0, 1200, 600);
		GWFrame.buttons.setBounds(0, 0, 1200, 450);
		GWFrame.theQuestion.setBounds(0, 0, 900, 50);
		GWFrame.QandA.setBounds(25, 455, 1150, 100);
		GWFrame.frameBG.setLayout(null);
		GWFrame.theQuestion.setFont(new Font("Times New Roman", 1, 42));
		GWFrame.theQuestion.setHorizontalAlignment(0);
		GWFrame.nextQ.setFocusable(false);
		GWFrame.prevQ.setFocusable(false);
		GWFrame.ask.setFocusable(false);
		this.addButtons();
		this.addButtonAction();
		GWFrame.XS.setVisible(true);
		this.addNextQ();
		this.addPrevQ();
		this.addAsk();
		this.addToPanel();
		this.add(GWFrame.frameBG);
		this.setResizable(false);
	}

	/*
	 * This method adds all the buttons, questions to the panel of the frame
	 */
	private void addToPanel() {
		GWFrame.yesnonextQ.add(GWFrame.nextQ);
		GWFrame.yesnonextQ.add(GWFrame.prevQ);
		GWFrame.yesnonextQ.add(GWFrame.ask);
		GWFrame.yesnonextQ.add(GWFrame.count);
		GWFrame.yesnonextQ.setOpaque(false);
		GWFrame.QandA.add(GWFrame.theQuestion);
		GWFrame.QandA.add(GWFrame.yesnonextQ);
		GWFrame.frameBG.add(GWFrame.QandA);
		GWFrame.frameBG.add(GWFrame.buttons);
		GWFrame.frameBG.add(GWFrame.background);
		GWFrame.buttons.setOpaque(false);
	}

	/*
	 * This method is used as a helper method which displays the message and the options on a JOP for the
	 * user to use a end game
	 */
	public static void checkNum(String msg, Object[] option, int... x) {
		int y = JOptionPane.showOptionDialog(null, msg, "", 1, -1, null, option, option[1]);
		if (y == 0) {
			GWFrame.frem.dispose();
			GWFrame.counter = 0;
			GWFrame.qList = new ArrayList<Question>(Arrays.asList(QuestionList.qList1));
			GWFrame.selectedPlayer = Checker.randomP();
			System.out.println(GWFrame.selectedPlayer.getName());
			for (int i = 0; i < GWFrame.buttys.length; ++i) {
				for (int ii = 0; ii < GWFrame.buttys[i].length; ++ii) {
					GWFrame.buttys[i][ii].setEnabled(true);
				}
			}
			GWMain.main(new String[0]);
		} else if (y == 1) {
			JOptionPane.showMessageDialog(null, "", "Goodbye", 1, GWFrame.bye);
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "", "YOU LEFT WITHOUT A GOODBYE", 1, GWFrame.bye);
			System.exit(0);
		}
	}

	/*
	 * This method, asks the game the question marking off the people who do not
	 * fill the answer
	 */
	public void askQuestion() {
		for (int i = 0; i < GWFrame.buttys.length; ++i) {
			for (int ii = 0; ii < GWFrame.buttys[i].length; ++ii) {
				if (GWFrame.buttys[i][ii].getCharacter().theAnswer() != GWFrame.selectedPlayer.theAnswer()) {
					setButInvisible(GWFrame.buttys[i][ii]);
				}
			}
		}
		GWFrame.qList.remove(GWFrame.currentQ--);
		if (GWFrame.currentQ < 0) {
			GWFrame.currentQ = GWFrame.qList.size() - 1;
		}
		if (GWFrame.qList.size() == 0) {
			GWFrame.theQuestion.setText("No More Questions");
		} else {
			GWFrame.theQuestion.setText(GWFrame.qList.get(GWFrame.currentQ).getQuestion());
		}
	}

	/*
	 * This method creates an action for the 'next button' button adding the next
	 * question
	 */
	private void addNextQ() {
		nextQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XS.setEnabled(false);
				++currentQ;
				if (currentQ > qList.size() - 1) {
					currentQ = 0;
				}
				if (qList.size() != 0) {
					theQuestion.setText(qList.get(currentQ).getQuestion());
				}
				if (!setVis1) {

					for (int i = 0; i < buttys.length; ++i) {
						for (int ii = 0; ii < buttys[i].length; ++ii) {
							setButVisible(buttys[i][ii]);
						}
					}
				}
				XS.setEnabled(false);
			}
		});
	}

	/*
	 * This method creates an action for the 'prev button' button adding the
	 * previous question
	 */
	private void addPrevQ() {
		prevQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				XS.setEnabled(false);
				--currentQ;
				if (currentQ < 0) {
					currentQ = qList.size() - 1;
				}
				if (qList.size() != 0) {
					theQuestion.setText(qList.get(currentQ).getQuestion());
				}
				if (!setVis1) {
					for (int i = 0; i < buttys.length; ++i) {
						for (int ii = 0; ii < buttys[i].length; ++ii) {
							setButVisible(buttys[i][ii]);
						}
					}
				}
				buttons.repaint();
			}
		});
	}

	/*
	 * This method is used to display the questions on the frame
	 * the method checks if the game is started
	 */
	private void addAsk() {
		ask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentQ >= 0) {
					askQuestion();
				}
			}
		});
	}

	/*
	 * This method is used to add the buttons to the UI
	 * the method also adds the ActionListeners to the buttons
	 */
	private void addButtons() {
		int nxt = 0;
		for (int i = 0; i < buttys.length; ++i) {
			for (int ii = 0; ii < buttys[i].length; ++ii) {
				(buttys[i][ii] = new gameButton(characters[nxt], AspectList.CHARACTERS[nxt])).setIcon(IL.imageList[nxt]);
				buttons.add(buttys[i][ii]);
				buttys[i][ii].setForeground(Color.black);
				buttys[i][ii].setContentAreaFilled(false);
				buttys[i][ii].setBorder(null);
				buttys[i][ii].setBorderPainted(false);
				setButInvisible(buttys[i][ii]);
				++nxt;
			}
		}
	}

	/*
	 * This method is a help method for 'addButtons' method which consolidates the adding of
	 * actions listeners to the button
	 */
	private void addButtonAction() {
		for (int i = 0; i < buttys.length; ++i) {
			for (int ii = 0; ii < buttys[i].length; ++ii) {
				buttys[i][ii].addActionListener(this.action);
			}
		}
	}

	/*
	 * This helper method sets all the buttons invisible	
	 */
	public static void setButInvisible(final JButton but) {
		but.setEnabled(false);
	}

	/*
	 * This helper method sets all the buttons visible 
	 */
	public static void setButVisible(final JButton but) {
		but.setEnabled(true);
	}

	

}
