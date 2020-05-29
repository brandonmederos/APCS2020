
package MazeEditor;

import setup.Maze2Frame;
import Images.ImageList;
import javax.swing.JLabel;
/*
 * This Class houses all the start locations of the players 
 */
@SuppressWarnings("serial")
public class Player extends JLabel {
	public static final int PLYR_STARTX_1 = 1;
	public static final int PLYR_STARTY_1 = 14;
	public static final int PLYR_STARTX_2 = 0;
	public static final int PLYR_STARTY_2 = 5;
	public static final int PLYR_STARTX_3 = 9;
	public static final int PLYR_STARTY_3 = 14;
	public static final int PLYR_STARTX_4 = 14;
	public static final int PLYR_STARTY_4 = 3;
	public static final int PLYR_STARTX_5 = 8;
	public static final int PLYR_STARTY_5 = 7;
	public static final int PLYR_ENDX_1 = 11;
	public static final int PLYR_ENDY_1 = 14;
	public static final int PLYR_ENDX_2 = 14;
	public static final int PLYR_ENDY_2 = 11;
	public static final int PLYR_ENDX_3 = 11;
	public static final int PLYR_ENDY_3 = 14;
	public static final int PLYR_ENDX_4 = 14;
	public static final int PLYR_ENDY_4 = 13;
	public static final int PLYR_ENDX_5 = 14;
	public static final int PLYR_ENDY_5 = 12;
	public int SD_X;
	public int SD_Y;

	/*
	 * This method is used to find the sword of the player and if the player with sword and minotaur match
	 * the minotaur is slain
	 */
	public void findSword() {
		do {
			int y = (int) (Math.random() * Maze.curMaze.length);
			int x = (int) (Math.random() * Maze.curMaze[y].length);
			SD_X = x;
			SD_Y = y;
		} while (Maze.curMaze[SD_Y][SD_X] && SD_Y != Maze2Frame.curPLocY
				&& SD_X != Maze2Frame.curPLocX && SD_Y != Maze2Frame.curMinLocY && SD_X != Maze2Frame.curMinLocX);
	}

	//Constructor
	public Player() {
	}

	/*
	 * This method places the player on its corresponding player start position (x,y)
	 */
	public void placePlyr() {
		Maze2Frame.getLabbys()[Maze2Frame.curPStartY][Maze2Frame.curPStartX].setImage(ImageList.plyUp);
	}

	/*
	 * This places the sword in its corresponding position
	 */
	public void placeSword() {
		findSword();
		Maze2Frame.getLabbys()[SD_Y][SD_X].setImage(ImageList.sword);
	}
}
