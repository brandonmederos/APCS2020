
package MazeEditor;

import setup.Maze2Frame;
import Images.ImageList;

public class Rat {

	/*----------------------------------*/
	private static final int rat_amt = 3;
	/*----------------------------------*/

	/****************\
	**	Locations	** 
	\****************/
	private int curRLocY;
	private int curRLocX;

	/****************\
	**	Variables	** 
	\****************/
	private boolean canMove;
	private static Rat[] rats = new Rat[rat_amt];

	//Constructor
	public Rat() {
		this.setLocation();
	}
		
	/************\
	**	Getters	** 
	\************/
	public int getRLocY() {
		return curRLocY;
	}
	public int getRLocX() {
		return this.curRLocX;
	}
	public static Rat[] getRats() {
		return rats;
	}

	/*
	 * This method is used to randomly set the location the amount of given
	 * rats on the board on a random valid square
	 */
	public void setLocation() {
		do {
			int rows = (int) (Math.random() * Maze.curMaze.length);
			int cols = (int) (Math.random() * Maze.curMaze[rows].length);
			curRLocY = rows;
			curRLocX = cols;
		} while (Maze.curMaze[curRLocY][curRLocX] && curRLocY != Maze2Frame.curPLocY && curRLocX != Maze2Frame.curPLocX
				&& curRLocY != Maze2Frame.curMinLocY && curRLocX != Maze2Frame.curMinLocX
				&& curRLocY + 1 != Maze2Frame.curPLocY && curRLocY - 1 != Maze2Frame.curPLocY
				&& curRLocX + 1 != Maze2Frame.curPLocX && curRLocX - 1 != Maze2Frame.curPLocX);
	}

	/*
	 * This method is used to place the rats on the valid squares given
	 */
	public static void placeRat() {
		for (int i = 0; i < rats.length; ++i) {
			rats[i] = new Rat();
			if (!Maze.curMaze[rats[i].getRLocY()][rats[i].getRLocX()]
					&& rats[i].getRLocY() != Maze2Frame.curPEndY && rats[i].getRLocX() != Maze2Frame.curPEndX) {
				Maze2Frame.getLabbys()[rats[i].getRLocY()][rats[i].getRLocX()].setImage(ImageList.ratDn);
			}
		}
	}

	/*
	 * This method is used to set the location of the rat to an immovable square
	 */
	private void setLoc(int x) {
		curRLocY = 0;
		curRLocX = 0;
	}

	/*
	 * This method is used to move the given rat to the 
	 * 'death' location
	 */
	public void killRat(int x) {
		rats[x].setLoc(x);
	}

	/*
	 * This method is used to move the rats back and forth
	 */
	public void moveRat() {
		this.canMove = true;
		final int rand = (int) (Math.random() * 4.0);
		if (rand == 0 && this.canMove && this.curRLocY - 1 > 0 && !Maze.curMaze[this.curRLocY - 1][this.curRLocX]) {
			Maze2Frame.getLabbys()[this.curRLocY - 1][this.curRLocX].setImage(ImageList.ratUp);
			if (!Maze.curMaze[this.curRLocY][this.curRLocX] && this.curRLocX != Maze2Frame.curPEndX
					&& this.curRLocY != Maze2Frame.curPEndY) {
				Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX].setImage(ImageList.path);
			}
			--this.curRLocY;
			return;
		}
		if (rand == 1 && this.canMove && this.curRLocX + 1 < Maze.curMaze[this.curRLocY].length
				&& !Maze.curMaze[this.curRLocY][this.curRLocX + 1]) {
			Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX + 1].setImage(ImageList.ratRt);
			if (!Maze.curMaze[this.curRLocY][this.curRLocX] && this.curRLocX != Maze2Frame.curPEndX
					&& this.curRLocY != Maze2Frame.curPEndY) {
				Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX].setImage(ImageList.path);
			}
			++this.curRLocX;
			return;
		}
		if (rand == 2 && this.canMove && this.curRLocY + 1 < Maze.curMaze[this.curRLocY].length
				&& !Maze.curMaze[this.curRLocY + 1][this.curRLocX]) {
			Maze2Frame.getLabbys()[this.curRLocY + 1][this.curRLocX].setImage(ImageList.ratDn);
			if (!Maze.curMaze[this.curRLocY][this.curRLocX] && this.curRLocX != Maze2Frame.curPEndX
					&& this.curRLocY != Maze2Frame.curPEndY) {
				Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX].setImage(ImageList.path);
			}
			++this.curRLocY;
			return;
		}
		if (rand == 3 && this.canMove && this.curRLocX - 1 > 0 && !Maze.curMaze[this.curRLocY][this.curRLocX - 1]) {
			Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX - 1].setImage(ImageList.ratLt);
			if (!Maze.curMaze[this.curRLocY][this.curRLocX] && this.curRLocX != Maze2Frame.curPEndX
					&& this.curRLocY != Maze2Frame.curPEndY) {
				Maze2Frame.getLabbys()[this.curRLocY][this.curRLocX].setImage(ImageList.path);
			}
			--this.curRLocX;
		}
	}
}
