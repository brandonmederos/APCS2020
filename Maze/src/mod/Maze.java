
package mod;

public class Maze {

	private boolean[][] _maze;
	private Position _start;
	private Position _end;
	private static Position[] _posarr = new Position[] { new Position(4, 9), new Position(9, 7), new Position(0, 6),
			new Position(9, 2), new Position(9, 4), new Position(9, 8), new Position(8, 9), new Position(0, 3),
			new Position(0, 1) };
	private static int q = (int) (Math.random() * Maze._posarr.length);
	private static int k = (int) (Math.random() * _posarr.length) / 2;
	private static final int PLAYER_START_ROW = _posarr[q].getRow();
	private static final int PLAYER_START_COL = _posarr[q].getCol();
	private static final int PLAYER_END_ROW = _posarr[k].getRow();
	private static final int PLAYER_END_COL = _posarr[k].getCol();

	// Getters
	public Position getStart() {
		return _start;
	}

	public Position getEnd() {
		return _end;
	}

	public boolean[][] getMaze() {
		return _maze;
	}

	// Maze Constructor
	public Maze() {
		boolean[][] maze = { { true, false, true, false, true, true, false, false, false, true },
				{ true, false, true, false, true, true, false, false, false, true },
				{ true, false, true, false, false, true, false, true, true, true },
				{ true, false, false, false, false, false, false, false, false, true },
				{ false, false, false, true, true, true, true, true, false, false },
				{ false, true, false, false, false, false, true, true, false, true },
				{ false, true, false, true, true, false, false, false, false, true },
				{ true, true, false, true, true, false, true, true, false, true },
				{ true, true, false, false, false, false, true, true, false, false },
				{ true, true, false, true, false, true, true, false, false, true } };
		_maze = maze;
		_start = new Position(Maze.PLAYER_START_ROW, Maze.PLAYER_START_COL);
		_end = new Position(Maze.PLAYER_END_ROW, Maze.PLAYER_END_COL);
	}
}
