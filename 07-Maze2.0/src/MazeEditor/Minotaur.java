
package MazeEditor;

import setup.Maze2Frame;
import Images.ImageList;

/*
 * This class houses the start positions of the Minotaur
 */
public class Minotaur {
	public static final int MIN_STARTX_1 = 9;
	public static final int MIN_STARTY_1 = 8;
	public static final int MIN_STARTX_2 = 6;
	public static final int MIN_STARTY_2 = 8;
	public static final int MIN_STARTX_3 = 9;
	public static final int MIN_STARTY_3 = 6;
	public static final int MIN_STARTX_4 = 1;
	public static final int MIN_STARTY_4 = 11;
	public static final int MIN_STARTX_5 = 12;
	public static final int MIN_STARTY_5 = 10;
//	public static int minRow = Maze2Frame.curMinLocY;
//	public static int minCol = Maze2Frame.curMinLocX;

	// Constructor
	public Minotaur() {

	}

	/*
	 * This Method is used to place the Minotaur in
	 */
	public void placeMin() {
		Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX].setImage(ImageList.minUp);
	}

	/*
	 * This method is used to move the minotaur randomly
	 */
	public void moveMin() {
		if (Maze2Frame.curPLocY < Maze2Frame.curMinLocY && Maze2Frame.curMinLocY - 1 >= 0
				&& !Maze.curMaze[Maze2Frame.curMinLocY - 1][Maze2Frame.curMinLocX]) {
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY - 1][Maze2Frame.curMinLocX].setImage(ImageList.minUp);
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX].setImage(ImageList.path);
			--Maze2Frame.curMinLocY;
			return;
		}
		if (Maze2Frame.curPLocX > Maze2Frame.curMinLocX && Maze2Frame.curMinLocX + 1 < Maze.curMaze.length
				&& !Maze.curMaze[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX + 1]) {
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX + 1].setImage(ImageList.minRt);
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX].setImage(ImageList.path);
			++Maze2Frame.curMinLocX;
			return;
		}
		if (Maze2Frame.curPLocY > Maze2Frame.curMinLocY && Maze2Frame.curMinLocY + 1 < Maze.curMaze[Maze2Frame.curMinLocY].length
				&& !Maze.curMaze[Maze2Frame.curMinLocY + 1][Maze2Frame.curMinLocX]) {
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY + 1][Maze2Frame.curMinLocX].setImage(ImageList.minDn);
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX].setImage(ImageList.path);
			++Maze2Frame.curMinLocY;
			return;
		}
		if (Maze2Frame.curPLocX < Maze2Frame.curMinLocX && Maze2Frame.curMinLocX - 1 >= 0
				&& !Maze.curMaze[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX - 1]) {
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX - 1].setImage(ImageList.minLt);
			Maze2Frame.getLabbys()[Maze2Frame.curMinLocY][Maze2Frame.curMinLocX].setImage(ImageList.path);
			--Maze2Frame.curMinLocX;
		}
	}
}
