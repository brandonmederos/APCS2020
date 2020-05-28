
package mod;

//A REPEAT OF 'RAT' Class
public class Rat3
{
    private Position _curPos;
    private boolean _facingLeft;
    private static Position[] _poo;
    private static int q;
    private static final int RAT3_START_ROW;
    private static final int RAT3_START_COL;
    private boolean _isAlive;
    
    static {
        Rat3._poo = new Position[] { new Position(3, 1), new Position(8, 2), new Position(4, 0), new Position(5, 2) };
        Rat3.q = (int)(Math.random() * Rat3._poo.length);
        RAT3_START_ROW = Rat3._poo[Rat3.q].getRow();
        RAT3_START_COL = Rat3._poo[Rat3.q].getCol();
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
    
    public Rat3(Maze z) {
        _facingLeft = true;
        _isAlive = true;
        _curPos = new Position(Rat3.RAT3_START_ROW, Rat3.RAT3_START_COL);
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
