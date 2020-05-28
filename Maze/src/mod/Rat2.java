
package mod;

//A REPEAT OF 'RAT' Class
public class Rat2
{
    private Position _curPos;
    private boolean _facingLeft;
    private static Position[] _poo;
    private static int q;
    private static final int RAT2_START_ROW;
    private static final int RAT2_START_COL;
    private boolean _isAlive;
    
    static {
        Rat2._poo = new Position[] { new Position(1, 8), new Position(1, 6), new Position(1, 7) };
        Rat2.q = (int)(Math.random() * Rat2._poo.length);
        RAT2_START_ROW = Rat2._poo[Rat2.q].getRow();
        RAT2_START_COL = Rat2._poo[Rat2.q].getCol();
    }
    
    public Position getRatPosition() {
        return _curPos;
    }
    
    public boolean isAlive() {
        return _isAlive;
    }
    
    public void killRat() {
        _isAlive = false;
    }
    
    public Rat2(Maze z) {
        _facingLeft = true;
        _isAlive = true;
        _curPos = new Position(Rat2.RAT2_START_ROW, Rat2.RAT2_START_COL);
    }
    
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
