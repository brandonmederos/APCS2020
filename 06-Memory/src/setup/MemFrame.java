
package setup;

import java.util.Collections;
import javax.swing.JOptionPane;
import mainPkg.MemMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.GridLayout;
import resources.EmptyClass;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import Images.ImageList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MemFrame extends JFrame{
	/************\
	**	JFRAME	**
	\************/
    private JFrame _frame;
    private JPanel background;
    private JPanel buttons;
    private JPanel options;
    private JButton restart;
    private JButton counter;
    
    /************\
    **	Images	**
    \************/
    private ImageList IL = new ImageList();
    private ArrayList<ImageIcon> iList = new ArrayList<ImageIcon>(Arrays.asList(IL.imageList));
    private ArrayList<ImageIcon> iList2 = new ArrayList<ImageIcon>(Arrays.asList(IL.imageList));
    private static final ImageIcon BLACKBG = new ImageIcon(EmptyClass.class.getResource("blackbg.png"));
    private static final ImageIcon TOOMUCH = new ImageIcon(EmptyClass.class.getResource("itstoomuch.gif"));
    private static final ImageIcon RUDE = new ImageIcon(EmptyClass.class.getResource("rude.gif"));
    private static final ImageIcon WIN = new ImageIcon(EmptyClass.class.getResource("win.gif"));
    
    /****************\
    **	Variables	**
    \****************/
    private static int count = 0;
    private static final String[] op = new String[] { "Restart Game", "Exit" };
    public gameButton[][] buttys;
    private gameButton storeBut;
    /*-----------------------------*/
    private int lose_condition = 10;
    /*-----------------------------*/
    
    //Constructor
    public MemFrame() {
        super("Memory");
        _frame = this;
        background = new JPanel();
        buttons = new JPanel(new GridLayout(4, 5));
        options = new JPanel(new GridLayout(1, 2));
        buttys = new gameButton[4][5];
        restart = new JButton("Restart Game");
        
        /* Set the Size of JFrame components */
        _frame.setSize(1200, 600);
        buttons.setSize(800, 500);
        setDefaultCloseOperation(3);
        
        addToFrame();
    }
    
    /*
     * This method adds all the components to the frame 
     * at the end of the constructor
     */
    public void addToFrame() {
        background.add(buttons);
        add(options, "South");
        addButtons();
        setup2ndPanel();
        add(background);
        this.pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    
    /*
     * This method sets up the size of the second panel
     * which hold the buttons and the options
     */
    private void setup2ndPanel() {
        setupOpButts();
        options.setSize(300, 100);
        options.add(restart);
    }
    
    /*
     * This method sets up the option buttons which have all the
     * actions
     */
    private void setupOpButts() {
        counter = new JButton("Wrong Guesses: " + MemFrame.count);
        options.add(counter);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MemFrame.this.restartParam();
            }
        });
    }
    
    /*
     * This method is called when the game must be restarted
     */
    private void restartParam() {
        MemFrame.count = 0;
        _frame.dispose();
        iList = new ArrayList<ImageIcon>(Arrays.asList(IL.imageList));
        iList2 = new ArrayList<ImageIcon>(Arrays.asList(IL.imageList));
        MemMain.main(new String[0]);
    }
    
    /*
     * This method sends the user a JOP message which prompts the user when there is 
     * too many guesses, which restarts the game
     */
    private void restartJOP() {
        int y = JOptionPane.showOptionDialog(null, "", "Too many guesses", -1, 1, MemFrame.TOOMUCH, MemFrame.op, MemFrame.op[0]);
        if (y == 0) {
            JOptionPane.showMessageDialog(null, "Restarting Game", "", -1);
            restartParam();
        }
        else if (y == 1) {
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "", "Really You left w/o a good bye again...", 1, MemFrame.RUDE);
            dispose();
            System.exit(0);
        }
    }
    
    /*
     * This Method is the same as the 'restartJOP' method but is prompted when the player meets 
     * the win conditions
     */
    private void restartJOPW() {
        int y = JOptionPane.showOptionDialog(null, "", "You Won!!", -1, 1, MemFrame.WIN, MemFrame.op, MemFrame.op[0]);
        if (y == 0) {
            JOptionPane.showMessageDialog(null, "Restarting Game", "", -1);
            restartParam();
        }
        else if (y == 1) {
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "", "Really You left w/o a good bye again...", 1, MemFrame.RUDE);
            dispose();
            System.exit(0);
        }
    }
    
    /*
     * This method is used to check whether the player has lost or not
     */
    private boolean checkLose() {
        return MemFrame.count != lose_condition;
    }
    
    /*
     * This method is used to check whether the player has completed
     * the entire puzzle
     */
    private boolean checkWin() {
        for (int i = 0; i < buttys.length; ++i) {
            for (int ii = 0; ii < buttys[i].length; ++ii) {
                if (buttys[i][ii].getIcon().equals(MemFrame.BLACKBG)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /*
     * This method adds all the cards for the game in a random order to the board
     */
    private void addButtons() {
        int cnt = 0;
        for (int i = 0; i < buttys.length; ++i) {
            for (int ii = 0; ii < buttys[i].length; ++ii) {
                if (cnt == iList.size()) {
                    cnt = 0;
                }
                buttys[i][ii] = new gameButton();
                if (iList.size() != 0) {
                    Collections.shuffle(iList);
                    buttys[i][ii].setImg(iList.get(cnt));
                    iList.remove(cnt);
                }
                else {
                    Collections.shuffle(iList2);
                    buttys[i][ii].setImg(iList2.get(cnt));
                    iList2.remove(cnt);
                }
                buttons.add(buttys[i][ii]);
                buttys[i][ii].setIcon(MemFrame.BLACKBG);
                buttys[i][ii].setContentAreaFilled(false);
                buttys[i][ii].setBorder(null);
                buttys[i][ii].setBorderPainted(false);
            }
        }
        ActListener();

        
    }
    
    /*
     * This ActionListener handles the actions of the cards and flips them when clicked
     */
    private void ActListener() {
    
		for(int i = 0; i < buttys.length; i++) {
			for(int ii = 0; ii < buttys[i].length; ii++) {
				buttys[i][ii].addActionListener(e -> {
						gameButton g = ((gameButton)e.getSource());
						if(checkWin()) {
							restartJOPW();
							return;
						}
						if(checkLose() == false) { 
							restartJOP();
							return;
						}
						if( g.getIcon().equals(g.getImg())) {
							return;
						}
						g.setIcon(g.getImg());
						
						if(storeBut == null) {
							storeBut = g;
						}
						else if(storeBut != g) {
							if(storeBut.matches(g)) {
								System.out.println("Correct");
								System.out.println("-------");
								storeBut = null;
							}
							else {
								System.out.println("Wrong");								
								System.out.println("-----");
								count++;
								counter.setText("Wrong Guesses: " + count);
								new Thread( new Runnable(){
									@Override
									public void run() {
									    try{
									        Thread.sleep(200);
									    } catch (InterruptedException e){
									        e.printStackTrace();
									    }
									    storeBut.setIcon(BLACKBG);
									    g.setIcon(BLACKBG);
									    _frame.pack();
									}}).start();
							}
						}
					}
				
				);
			}
			
		}
	}
}
