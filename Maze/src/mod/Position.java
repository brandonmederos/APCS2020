
package mod;
/*
 * This Class controls the position of all the entities
 */
public class Position
{
    private int _row;
    private int _col;
    
    public int getRow() {
        return _row;
    }
    
    public int getCol() {
        return _col;
    }
    
    public Position(int r,int c) {
        _row = r;
        _col = c;
    }
    
    public void setRow(int r) {
        _row = r;
    }
    
    public void setCol(int c) {
        _col = c;
    }
}
