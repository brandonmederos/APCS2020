
package mod;

public class Sword
{
    private Position _curPos;
    private static Position[] _pee;
    private static int q;
    private static final int SWORD_START_ROW;
    private static final int SWORD_START_COL;
    
    static {
        Sword._pee = new Position[] { new Position(6, 5), new Position(6, 6), new Position(6, 7), new Position(6, 8), new Position(5, 3), new Position(5, 4), new Position(2, 4), new Position(4, 2), new Position(3, 4), new Position(3, 5) };
        Sword.q = (int)(Math.random() * Sword._pee.length);
        SWORD_START_ROW = Sword._pee[Sword.q].getRow();
        SWORD_START_COL = Sword._pee[Sword.q].getCol();
    }
    
    public Position getSwordPosition() {
        return _curPos;
    }
    
    public Sword(Maze z) {
        _curPos = new Position(Sword.SWORD_START_ROW, Sword.SWORD_START_COL);
    }
}
