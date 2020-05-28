
package mod;

public class Minotaur {
	private Position _curPos;
	private static Position[] _posarr = new Position[] { new Position(6, 5), new Position(6, 6), new Position(6, 7),
			new Position(6, 8), new Position(5, 3), new Position(5, 4), new Position(2, 4), new Position(4, 2),
			new Position(3, 4), new Position(3, 5) };
	private static int l = (int) (Math.random() * _posarr.length);;
	private static final int MINOTAUR_START_ROW = _posarr[l].getRow();
	private static final int MINOTAUR_START_COL = _posarr[l].getCol();
	private boolean _isAlive;

	public Position getMinotaurPosition() {
		return _curPos;
	}

	/*
	 * This constructor gets a maze object and creates the functions of the minotaur
	 */
	public Minotaur(Maze z) {
		_isAlive = true;
		_curPos = new Position(MINOTAUR_START_ROW, MINOTAUR_START_COL);
	}
	/*
	 * These methods get the private variables
	 */
	public int getMinotaurRow() {
		return _curPos.getRow();
	}
	public int getMinotaurCol() {
		return _curPos.getCol();
	}
	public boolean isAlive() {
		return _isAlive;
	}

	/*
	 * This method kills the minotaur by setting it's alive value to false
	 */
	public void killMinotaur() {
		_isAlive = false;
	}

	public void minotaurMove(boolean[][] maze, Player p) {
		int distRow = _curPos.getRow() - p.getPlayerPosition().getRow();
		int distCol = _curPos.getCol() - p.getPlayerPosition().getCol();
		if (distRow > 0) {
			if (!maze[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() - 1);
			} else if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos.setCol(_curPos.getCol() - 1);
			} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos.setCol(_curPos.getCol() + 1);
			} else if (!maze[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos.setCol(_curPos.getCol() - 1);
			} else {
				_curPos.setRow(_curPos.getRow() + 1);
			}
		} else if (distRow == 0) {
			if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos.setCol(_curPos.getCol() - 1);
			} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos.setCol(_curPos.getCol() + 1);
			} else if (!maze[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() + 1);
			} else if (!maze[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() - 1);
			} else {
				_curPos.setCol(_curPos.getCol() - 1);
			}
		} else if (!maze[_curPos.getRow() + 1][_curPos.getCol()]) {
			_curPos.setRow(_curPos.getRow() + 1);
		} else if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
			_curPos.setCol(_curPos.getCol() - 1);
		} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
			_curPos.setCol(_curPos.getCol() + 1);
		} else if (!maze[_curPos.getRow()][_curPos.getCol() - 1]) {
			_curPos.setCol(_curPos.getCol() - 1);
		} else {
			_curPos.setRow(_curPos.getRow() - 1);
		}
	}
}
