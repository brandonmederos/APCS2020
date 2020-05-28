
package mod;

public class Rat
{
    private Position _curPos;
    private boolean _facingLeft;
    private static Position[] _posarr = new Position[] { new Position(0, 6), new Position(0, 7), new Position(0, 8) };
    private static int q = (int)(Math.random() * _posarr.length);
    private static final int RAT_START_ROW = _posarr[q].getRow();
    private static final int RAT_START_COL = _posarr[q].getCol();
    private boolean _isAlive;
    
    
    /*
     * Getters for the position, and if the rat is alive
     */
    public Position getRatPosition() {
        return _curPos;
    }
    public boolean isAlive() {
        return _isAlive;
    }
    public void killRat() {
        _isAlive = false;
    }
    
    //Constructor
    public Rat(Maze z) {
        _facingLeft = true;
        _isAlive = true;
        _curPos = new Position(RAT_START_ROW, RAT_START_COL);
    }
    
    /*
     * This Method moves the rats randomly back and forth
     */
    public void amoveHoriz(Maze z) {
        if (_facingLeft) {
            if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
                _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
            }
            else {
                _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
                _facingLeft = false;
            }
        }
        else if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length && !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
            _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
        }
        else {
            _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
            _facingLeft = true;
        }
    }
}
