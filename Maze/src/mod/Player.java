
package mod;

public class Player
{
    private Position _curPos;
    private boolean _isAlive;
    public boolean inInventory;
    public boolean minotaurSkull;
    public boolean rathead1;
    public boolean rathead2;
    public boolean rathead3;
    
    /*
     * These methods are used as getter to get the 
     * position and whether the player is alive
     */
    public Position getPlayerPosition() {
        return _curPos;
    }
    public boolean isAlive() {
        return _isAlive;
    }
    
    /*
     * This method sets the position of the player
     */
    public void setPosition(Position p) {
        _curPos = p;
    }
    
    //This Method kills the player when called
    public void killPlayer() {
        _isAlive = false;
    }
    
    //Constructor
    public Player(Maze z) {
        _isAlive = true;
        inInventory = false;
        minotaurSkull = false;
        rathead1 = false;
        rathead2 = false;
        rathead3 = false;
        _curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
    }
    
    /*
     * This method returns a boolean value if the player can move
     */
    public boolean playerMove(Direction d, Maze z) {
        if (d == Direction.North) {
            if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
                _curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
                return true;
            }
        }
        else if (d == Direction.South) {
            if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
                _curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
                return true;
            }
        }
        else if (d == Direction.East) {
            if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length && !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
                _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
                return true;
            }
        }
        else if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
            _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
            return true;
        }
        return false;
    }
    
    /*
     * These 2 methods control the the player's sword, which can kill the minotaur and rats
     */
    public void pickUpSword(Sword a) {
        if (getPlayerPosition().getRow() == a.getSwordPosition().getRow() && getPlayerPosition().getCol() == a.getSwordPosition().getCol()) {
            inInventory = true;
        }
    }
    
    public boolean hasSword(Sword a) {
        return inInventory;
    }
    
    public void pickUpSkull(Minotaur m) {
        if (getPlayerPosition().getRow() == m.getMinotaurPosition().getRow() && getPlayerPosition().getCol() == m.getMinotaurPosition().getCol() && inInventory) {
            minotaurSkull = true;
        }
    }
    
    public boolean hasSkull(Minotaur m) {
        return minotaurSkull;
    }
    
    public void pickUpRat1(Rat r1) {
        if (getPlayerPosition().getRow() == r1.getRatPosition().getRow() && getPlayerPosition().getCol() == r1.getRatPosition().getCol() && inInventory) {
            rathead1 = true;
        }
    }
    
    public boolean hasRat1(Rat r1) {
        return rathead1;
    }
    
    public void pickUpRat2(Rat2 rr) {
        if (getPlayerPosition().getRow() == rr.getRatPosition().getRow() && getPlayerPosition().getCol() == rr.getRatPosition().getCol() && inInventory) {
            rathead2 = true;
        }
    }
    
    public boolean hasRat2(Rat2 rr) {
        return rathead2;
    }
    
    public void pickUpRat3(Rat3 rrr) {
        if (getPlayerPosition().getRow() == rrr.getRatPosition().getRow() && getPlayerPosition().getCol() == rrr.getRatPosition().getCol() && inInventory) {
            rathead3 = true;
        }
    }
    
    public boolean hasRat3(Rat3 rrr) {
        return rathead3;
    }
}
