
package MazeEditor;

import java.util.ArrayList;

public class Maze {
	/*
	 * All the mazes
	 */
	public static final boolean[][] MAZE1;
	public static final boolean[][] MAZE2;
	public static final boolean[][] MAZE3;
	public static final boolean[][] MAZE4;
	public static final boolean[][] MAZE5;

	//The current maze that the player will play
	public static boolean[][] curMaze;
	
	//list of all the mazes availble
	private static ArrayList<boolean[][]> _mazes = new ArrayList<boolean[][]>();

	//Instantiates all the mazes
	static {
		MAZE1 = new boolean[][] {
				{ true, true, true, true, true, true, true, true, true, true, false, false, false, true, true },
				{ true, true, false, false, false, false, false, true, true, true, false, true, false, true, true },
				{ true, true, false, true, true, true, false, true, true, true, false, true, false, true, true },
				{ true, false, false, false, true, true, false, false, true, true, false, true, false, true, true },
				{ true, false, true, false, false, true, false, false, false, false, false, true, false, true, true },
				{ true, false, true, true, false, true, false, true, false, true, true, true, false, true, true },
				{ true, false, false, false, false, true, false, true, false, true, false, false, false, false, true },
				{ false, false, true, true, true, false, false, true, false, false, false, true, true, false, true },
				{ false, true, false, false, false, false, true, true, false, false, false, true, true, false, true },
				{ false, true, false, true, true, false, true, true, false, false, true, true, true, false, true },
				{ false, false, false, true, false, false, false, false, false, true, true, true, true, false, true },
				{ true, true, true, true, false, true, false, false, false, false, true, false, false, false, false },
				{ true, false, false, false, false, true, true, false, false, true, true, false, true, false, false },
				{ true, false, true, true, false, false, false, false, true, true, true, false, true, true, true },
				{ true, false, true, true, true, true, true, true, true, true, true, false, true, true, true } };
		MAZE2 = new boolean[][] {
				{ true, true, true, true, true, false, false, false, true, true, true, false, true, false, true },
				{ false, false, true, true, true, false, true, false, true, true, true, false, true, false, false },
				{ true, false, false, false, false, false, true, false, true, true, true, false, true, false, false },
				{ true, false, false, true, true, false, true, false, true, true, true, false, false, false, false },
				{ false, false, false, false, false, false, true, false, true, false, true, false, true, false, true },
				{ false, true, true, false, true, true, true, false, false, false, false, false, true, true, true },
				{ true, true, true, false, true, true, true, false, true, false, true, false, true, true, true },
				{ true, true, true, false, true, false, false, false, true, true, true, false, true, true, true },
				{ true, true, true, false, true, false, false, false, false, true, true, false, true, true, true },
				{ false, false, false, false, true, false, false, true, false, true, true, false, true, true, true },
				{ false, true, true, false, false, false, true, true, false, true, true, false, true, true, true },
				{ false, true, true, false, true, false, false, false, false, true, false, false, false, false, false },
				{ false, true, true, false, true, true, false, false, true, false, false, true, true, true, true },
				{ false, false, false, false, false, false, true, false, false, false, true, true, true, true, true },
				{ true, true, true, true, true, false, true, false, false, true, true, true, true, true, true } };
		MAZE3 = new boolean[][] {
				{ true, true, true, true, true, true, false, false, false, false, false, true, true, true, true },
				{ true, true, true, false, false, false, false, true, false, true, false, false, true, true, true },
				{ false, false, true, false, false, false, false, true, true, true, false, true, false, false, true },
				{ true, false, false, false, false, true, true, true, true, false, false, true, false, false, true },
				{ true, false, false, true, false, true, true, true, true, false, false, false, false, false, true },
				{ true, false, true, false, false, true, true, true, true, false, true, true, true, false, true },
				{ true, false, true, true, false, false, false, false, false, false, true, true, true, false, true },
				{ true, false, true, false, false, false, true, true, true, true, true, true, true, false, true },
				{ true, false, true, true, true, false, true, true, false, true, true, true, false, false, true },
				{ true, false, true, true, true, false, true, false, false, true, true, false, false, false, true },
				{ false, false, false, true, true, false, false, false, false, false, true, false, false, false, true },
				{ false, false, false, false, false, false, true, false, false, false, true, false, false, true, true },
				{ false, false, true, true, true, true, true, false, false, false, true, true, false, false, true },
				{ false, true, true, true, true, true, true, true, true, false, true, true, true, false, false },
				{ false, true, true, true, true, true, true, true, true, false, true, false, false, false, false } };
		MAZE4 = new boolean[][] {
				{ true, false, true, false, false, false, false, true, true, true, true, false, false, false, false },
				{ false, false, false, false, false, true, false, false, true, true, true, false, true, false, false },
				{ true, true, true, true, false, true, true, false, false, true, true, false, true, true, false },
				{ true, true, true, true, false, true, true, true, false, false, false, false, true, true, false },
				{ true, true, true, true, false, true, true, true, false, true, true, true, true, true, true },
				{ false, false, true, false, false, false, false, false, false, true, false, true, true, false, false },
				{ false, false, false, false, true, true, false, true, false, true, false, true, true, false, false },
				{ false, true, false, false, true, true, false, true, false, true, false, false, false, false, false },
				{ false, true, false, false, false, false, false, false, false, true, true, true, false, true, true },
				{ false, true, false, true, true, true, false, false, false, true, true, true, false, true, true },
				{ false, true, false, false, false, false, false, true, false, true, true, true, false, true, true },
				{ false, false, false, false, false, true, false, false, false, false, false, false, false, true,
						true },
				{ false, true, true, true, true, true, false, true, true, true, true, true, true, true, true },
				{ false, false, false, false, false, false, false, false, false, false, false, true, true, false,
						false },
				{ false, false, true, true, true, false, false, true, true, true, false, false, false, false, true } };
		MAZE5 = new boolean[][] {
				{ true, true, true, true, true, true, true, true, false, false, false, false, false, true, true },
				{ false, false, false, false, false, true, true, true, false, false, false, true, false, false, false },
				{ false, false, false, true, false, false, false, false, false, true, false, true, false, false,
						false },
				{ false, false, false, true, false, false, false, false, false, true, false, false, false, true,
						false },
				{ false, true, true, true, true, true, true, true, true, true, true, false, false, true, false },
				{ false, true, true, true, true, true, true, true, false, false, false, false, false, false, false },
				{ false, true, true, true, true, true, true, true, false, true, false, true, false, false, true },
				{ false, true, true, true, false, false, false, true, false, true, false, true, false, true, true },
				{ false, false, false, false, false, false, false, true, true, true, false, true, false, true, true },
				{ false, true, false, true, false, false, false, false, false, false, false, true, false, true, true },
				{ false, true, false, true, false, false, true, true, false, false, false, true, false, true, true },
				{ false, true, false, true, false, false, true, true, true, true, true, true, false, true, true },
				{ false, false, false, true, false, false, true, true, true, true, true, true, false, false, false },
				{ true, true, false, false, false, false, false, false, false, false, false, false, false, true, true },
				{ true, true, true, false, false, true, true, true, true, true, true, true, true, true, true } };
	}

	/*
	 * This method is used to add all the mazes to the list
	 */
	public void addMaze() {
		_mazes.add(MAZE1);
		_mazes.add(MAZE2);
		_mazes.add(MAZE3);
		_mazes.add(MAZE4);
		_mazes.add(MAZE5);
	}

	/*
	 * This method is used as a getter for the maze array
	 */
	public ArrayList<boolean[][]> getMazes() {
		return _mazes;
	}

	/*
	 * This method is used to set the current maze to the parameter
	 */
	public void setMaze(boolean[][] b) {
		curMaze = b;
	}

	//Constructor adds all the mazes to list to be used
	public Maze() {
		addMaze();
	}
}
