
package setup;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import mainPkg.Maze2Main;
import MazeEditor.Rat;
import MazeEditor.Maze;
import javax.swing.ImageIcon;
import resources.EmptyClass;
import javax.swing.JOptionPane;
import Images.ImageList;
import java.awt.GridLayout;
import MazeEditor.Player;
import MazeEditor.Minotaur;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Maze2Frame {

	/****************
	 * \ Variables ** \
	 ****************/
	private static String[] mazes = new String[] { "Maze 1", "Maze 2", "Maze 3", "Maze 4", "Maze 5" };
	private boolean hasSword = false;
	public static int curIndex;
	private Minotaur _m;
	private Player _p;

	/****************
	 * \ Position ** \
	 ****************/
	public static int curPStartX;
	public static int curPStartY;
	public static int curPEndX;
	public static int curPEndY;
	public static int curMinLocX;
	public static int curMinLocY;
	public static int curPLocX;
	public static int curPLocY;
	public int curMaze;
	public static final int SIZE = 15;

	/****************
	 * \ Components ** \
	 ****************/
	private JFrame _frame;
	private JPanel background = new JPanel(new GridLayout(15, 15, 0, -5));
	private static JPanel[][] LabPan = new JPanel[SIZE][SIZE];
	private static final GameLabel[][] LABBYS = new GameLabel[SIZE][SIZE];

	// Getter for 'Labbys'
	public static GameLabel[][] getLabbys() {
		return LABBYS;
	}

	// Constructor that takes a boolean value
	public Maze2Frame(boolean begin) {
		_m = new Minotaur();
		_p = new Player();
		if (begin) {
			ask();
			Listen();
			addToFrame();
		} else {
			nextLvl(curIndex);
			Listen();
			addToFrame();
		}
	}

	/*
	 * This Method is used to instantiate the beginning of the program as a level selector
	 */
	private void ask() {
		curMaze = JOptionPane.showOptionDialog(null, null, "Maze Select, Press 'MINUS' to Restart", -1, -1,
				ImageList.select, mazes, mazes[0]);
		if (curMaze == 0) {
			curIndex = 0;
			_frame = new JFrame("Maze 2.0 - Level: 1");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall2.png"));
			Maze.curMaze = Maze.MAZE1;
			curPStartX = 1;
			curPStartY = 14;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 11;
			curPEndY = 14;
			curMinLocX = 9;
			curMinLocY = 8;
		} else if (curMaze == 1) {
			curIndex = 1;
			_frame = new JFrame("Maze 2.0 - Level: 2");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall.png"));
			Maze.curMaze = Maze.MAZE2;
			curPStartX = 0;
			curPStartY = 5;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 11;
			curMinLocX = 6;
			curMinLocY = 8;
		} else if (curMaze == 2) {
			curIndex = 2;
			_frame = new JFrame("Maze 2.0 - Level: 3");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall3.png"));
			Maze.curMaze = Maze.MAZE3;
			curPStartX = 9;
			curPStartY = 14;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 11;
			curPEndY = 14;
			curMinLocX = 9;
			curMinLocY = 6;
		} else if (curMaze == 3) {
			curIndex = 3;
			_frame = new JFrame("Maze 2.0 - Level: 4");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall5t.png"));
			Maze.curMaze = Maze.MAZE4;
			curPStartX = 14;
			curPStartY = 3;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 13;
			curMinLocX = 1;
			curMinLocY = 11;
		} else if (curMaze == 4) {
			curIndex = 5;
			_frame = new JFrame("Maze 2.0 - Level: 5");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall5.png"));
			Maze.curMaze = Maze.MAZE5;
			curPStartX = 8;
			curPStartY = 7;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 12;
			curMinLocX = 12;
			curMinLocY = 10;
		} else {
			System.exit(0);
		}
	}

	/*
	 * This Method is used to go to the next level when the player reaches the end
	 */
	private void nextLvl(int currInd) {
		curMaze = curIndex;
		if (curMaze == 0) {
			curIndex = 0;
			_frame = new JFrame("Maze 2.0 - Level: 1");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall2.png"));
			curPStartX = 1;
			curPStartY = 14;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 11;
			curPEndY = 14;
			curMinLocX = 9;
			curMinLocY = 8;
			Maze.curMaze = Maze.MAZE1;
		} else if (curMaze == 1) {
			curIndex = 1;
			_frame = new JFrame("Maze 2.0 - Level: 2");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall.png"));
			curPStartX = 0;
			curPStartY = 5;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 11;
			curMinLocX = 6;
			curMinLocY = 8;
			Maze.curMaze = Maze.MAZE2;
		} else if (curMaze == 2) {
			curIndex = 2;
			_frame = new JFrame("Maze 2.0 - Level: 3");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall3.png"));
			curPStartX = 9;
			curPStartY = 14;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 11;
			curPEndY = 14;
			curMinLocX = 9;
			curMinLocY = 6;
			Maze.curMaze = Maze.MAZE3;
		} else if (curMaze == 3) {
			curIndex = 3;
			_frame = new JFrame("Maze 2.0 - Level: 4");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall5t.png"));
			curPStartX = 14;
			curPStartY = 3;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 13;
			curMinLocX = 1;
			curMinLocY = 11;
			Maze.curMaze = Maze.MAZE4;
		} else if (curMaze == 4) {
			curIndex = 4;
			_frame = new JFrame("Maze 2.0 - Level: 5");
			ImageList.walls = new ImageIcon(EmptyClass.class.getResource("wall5.png"));
			curPStartX = 8;
			curPStartY = 7;
			curPLocX = curPStartX;
			curPLocY = curPStartY;
			curPEndX = 14;
			curPEndY = 12;
			curMinLocX = 12;
			curMinLocY = 10;
			Maze.curMaze = Maze.MAZE5;
		} else {
			System.exit(0);
		}
	}

	/*
	 * This Method is used to check the players location relative to the ending, sword, Minotaur
	 * and rat
	 */
	public void checkEnd() {
		if (!hasSword && curPLocX == Maze2Frame.curMinLocX && curPLocY == Maze2Frame.curMinLocY) {
			System.out.println("End");
			JOptionPane.showMessageDialog(null, "The Monster has disembowled you", "", -1);
		} else if (curPLocX == Rat.getRats()[0].getRLocX()
				&& curPLocY == Rat.getRats()[0].getRLocY()) {
			for (int i = 0; i < Rat.getRats().length; ++i) {
				if (curPLocX == Rat.getRats()[i].getRLocX()
						&& curPLocY == Rat.getRats()[i].getRLocY()) {
					JOptionPane.showMessageDialog(null, "The Rat Has Slain You", "", -1);
				}
			}
			JOptionPane.showMessageDialog(null, "The Rat Has Slain You", "", -1);
		} else if (curPLocX == curPEndX && curPLocY == curPEndY) {
			JOptionPane.showMessageDialog(null, "You Win, Good Luck on the Next Level", "", -1);
			if (curIndex <= 4) {
				++curIndex;
				_frame.dispose();
				Maze2Main.run(false);
			} else {
				_frame.dispose();
				JOptionPane.showMessageDialog(null, null, null, -1, ImageList.gb);
				System.exit(0);
			}
		}
	}

	/*
	 * This Method is used to add all the components to the
	 * JFrame
	 */
	private void addToFrame() {
		addToBG1();
		_frame.add(background);
		_frame.pack();
		_frame.setDefaultCloseOperation(3);
		_frame.setLocationRelativeTo(null);
		_frame.setResizable(false);
		_frame.setVisible(true);
	}

	/*
	 * This method is used to add elements to the background which
	 * will be later added to the frame
	 */
	private void addToBG1() {
		_frame.addKeyListener(Listen());
		background.setSize(500, 500);
		for (int i = 0; i < LABBYS.length; ++i) {
			for (int ii = 0; ii < LABBYS[i].length; ++ii) {
				(LabPan[i][ii] = new JPanel()).setPreferredSize(new Dimension(32, 32));
				background.add(LabPan[i][ii]);
				LABBYS[i][ii] = new GameLabel(ImageList.walls);
				if (!Maze.curMaze[i][ii]) {
					LABBYS[i][ii].setImage(ImageList.path);
				} else if (Maze.curMaze[i][ii]) {
					LABBYS[i][ii].setImage(ImageList.walls);
				}
				Listen();
				LabPan[i][ii].add(LABBYS[i][ii]);
			}
		}
		LABBYS[curPEndY][curPEndX].setImage(ImageList.door);
		_m.placeMin();
		_p.placePlyr();
		Rat.placeRat();
	}

	/*
	 * This is the KeyListener to listen for the keys which will be used for moving the character
	 * and moves the character if the player is on the board
	 */
	private KeyListener Listen() {
		return new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				int kc = e.getKeyCode();
				if (kc == KeyEvent.VK_MINUS) {
					_frame.dispose();
					Maze2Main.main(new String[0]);
				} else if (kc == 92) {
					System.out.println("----------------------");
					for (int i = 0; i < Rat.getRats().length; ++i) {
						System.out.println("----------------------");
						System.out.println("Rat # " + (i + 1));
						System.out.println("Rat " + i + " Row: " + Rat.getRats()[i].getRLocY());
						System.out.println("Rat " + i + " Col: " + Rat.getRats()[i].getRLocX());
					}
					System.out.println("----------------------");
					System.out.println("PLY ROW " + curPLocY);
					System.out.println("PLY COL " + curPLocX);
					System.out.println("----------------------");
				} else if (kc == KeyEvent.VK_W || kc == KeyEvent.VK_UP) {
					if (curPLocY - 1 >= 0 && isAlive()) {
						checkEnd();
						if (!Maze.curMaze[curPLocY - 1][curPLocX]) {
							getLabbys()[curPLocY - 1][curPLocX]
									.setImage(ImageList.plyUp);
							getLabbys()[curPLocY][curPLocX].setImage(ImageList.path);
							--curPLocY;
						}
						for (int i = 0; i < Rat.getRats().length; ++i) {
							Rat.getRats()[i].moveRat();
						}
						_m.moveMin();
						checkEnd();
					}
				} else if (kc == KeyEvent.VK_D || kc == KeyEvent.VK_RIGHT) {
					if (curPLocX + 1 <= Maze.curMaze[curPLocY].length
							&& isAlive()) {
						checkEnd();
						if (!Maze.curMaze[curPLocY][curPLocX + 1]) {
							getLabbys()[curPLocY][curPLocX + 1]
									.setImage(ImageList.plyRt);
							getLabbys()[curPLocY][curPLocX].setImage(ImageList.path);
							++curPLocX;
						}
						for (int i = 0; i < Rat.getRats().length; ++i) {
							Rat.getRats()[i].moveRat();
						}
						_m.moveMin();
						checkEnd();
					}
				} else if (kc == KeyEvent.VK_S || kc == KeyEvent.VK_DOWN) {
					if (curPLocY + 1 <= Maze.curMaze.length && isAlive()) {
						checkEnd();
						if (!Maze.curMaze[curPLocY + 1][curPLocX]) {
							getLabbys()[curPLocY + 1][curPLocX]
									.setImage(ImageList.plyDn);
							getLabbys()[curPLocY][curPLocX].setImage(ImageList.path);
							++curPLocY;
						}
						for (int i = 0; i < Rat.getRats().length; ++i) {
							Rat.getRats()[i].moveRat();
						}
						_m.moveMin();
						checkEnd();
					}
				} else if ((kc == KeyEvent.VK_A || kc == KeyEvent.VK_LEFT) && curPLocX - 1 >= 0 && isAlive()) {
					checkEnd();
					if (!Maze.curMaze[curPLocY][curPLocX - 1]) {
						getLabbys()[curPLocY][curPLocX - 1].setImage(ImageList.plyLt);
						getLabbys()[curPLocY][curPLocX].setImage(ImageList.path);
						--curPLocX;
					}
					for (int i = 0; i < Rat.getRats().length; ++i) {
						Rat.getRats()[i].moveRat();
					}
					_m.moveMin();
					checkEnd();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
		};
	}

	/*
	 * This method is used to check whether the player is alive by finding if the player is on the board
	 */
	private boolean isAlive() {
		boolean alive = false;
		for (int r = 0; r < Maze.curMaze.length; ++r) {
			for (int c = 0; c < Maze.curMaze[r].length; ++c) {
				ImageIcon o = getLabbys()[r][c].getImage();
				if (o.equals(ImageList.plyUp) || o.equals(ImageList.plyDn) || o.equals(ImageList.plyLt)
						|| o.equals(ImageList.plyRt)) {
					alive = true;
				}
			}
		}
		return alive;
	}
}
