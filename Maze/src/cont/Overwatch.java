package cont;

import mod.Direction;
import mod.YesNo;
import mod.Rat3;
import mod.Rat2;
import mod.Rat;
import view.Window;
import view.StringMap;
import mod.Maze;
import mod.Minotaur;
import mod.Player;
import mod.Sword;

public class Overwatch
{
    private Sword _a;
    private Player _p;
    private Minotaur _m;
    private Maze _z;
    private StringMap _s;
    private Window _w;
    private Rat _r1;
    private Rat2 _rr;
    private Rat3 _rrr;
    private static final String[] BUTTONS = new String[] { "Up", "Down", "Right", "Left", "Help", "Escape" };
    private static final String[] OPTIONS = new String[] { "Yes", "No" };
    
    
    public void getPlayerMovement() {
        while (true) {
            if (!_p.isAlive()) {
                _z = new Maze();
                _s = new StringMap();
                _p = new Player(_z);
                _m = new Minotaur(_z);
                _r1 = new Rat(_z);
                _rr = new Rat2(_z);
                _rrr = new Rat3(_z);
                _a = new Sword(_z);
            }
            else {
                final int x = _w.option(Overwatch.BUTTONS, _s.updateMap(_p, _m, _r1, _rr, _rrr, _z, _a));
                move(x);
                gamecheck();
            }
        }
    }
    
    
    //Constructor
    public Overwatch() {
    	//Story Time
    	_w = new Window();
        _w.msg("Arise new champion, your tenacity remains to be tested as you will be faced with the challenge of saving your own skin");
        _w.msg("What crawls amongst this dungeon is but a few rats, but they should take the least of your turmoil.");
        _w.msg("For there is a giant beast roaming these halls and he smells the fear off of your shaking bones.");
        _w.msg("Oh you may run and cower to the exit of this Labyrinth or you can steel your nerves and hunt for the sword as to strike down the minotaur!");
        _w.msg("Be wary now, the rats will naw away at the sword once it reaches your hands, so tread carefully after retrieving it!");
        _w.msg("May the gods smile favor your victory young one");
        
        //Instantiates
        _z = new Maze();
        _s = new StringMap();
        _p = new Player(_z);
        _m = new Minotaur(_z);
        _a = new Sword(_z);
        _r1 = new Rat(_z);
        _rr = new Rat2(_z);
        _rrr = new Rat3(_z);
        
        //Gets the Players Movement when the game Starts
        getPlayerMovement();
    }
    
    /*
     * This mothod moves the Player and the entities by removing them and reconstructing them
     */
    public void move(int x) {
        if (!_p.playerMove(getPlayerDirection(x), _z)) {
            _w.msg("A wall challenges your path!");
            _r1.amoveHoriz(_z);
            _rr.amoveHoriz(_z);
            _rrr.amoveHoriz(_z);
            _m.minotaurMove(_z.getMaze(), _p);
        }
        else {
            _r1.amoveHoriz(_z);
            _rr.amoveHoriz(_z);
            _rrr.amoveHoriz(_z);
            _m.minotaurMove(_z.getMaze(), _p);
        }
    }
    
    /*
     * This method Checks for the 'End Game'
     * whether it be:
     * Win
     * Lose
     * Clash With a Wall, Rat and/or minotaur
     */
    public void gamecheck() {
        if (_p.getPlayerPosition().getRow() == _a.getSwordPosition().getRow() && _p.getPlayerPosition().getCol() == _a.getSwordPosition().getCol() && !_p.inInventory) {
            _w.msg("You found your shard of courage, now slay!");
            _p.inInventory = true;
        }
        if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow() && _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && !_p.inInventory) {
            _p.killPlayer();
            _w.msg("You have fallen to the hand of the Minotaur!");
        }
        if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow() && _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && _p.inInventory) {
            _m.killMinotaur();
            _p.inInventory = false;
            _w.msg("You have survived fellow victor!");
            _w.option(Overwatch.OPTIONS, "Would you care to test your courage once more?");
        }
        if (_p.getPlayerPosition().getRow() == _r1.getRatPosition().getRow() && _p.getPlayerPosition().getCol() == _r1.getRatPosition().getCol() && _p.inInventory) {
            _r1.killRat();
            _p.inInventory = false;
            _w.msg("Down goes the feeble creature, along with your fragile blade. Was that trade in your favor?");
        }
        if (_p.getPlayerPosition().getRow() == _rr.getRatPosition().getRow() && _p.getPlayerPosition().getCol() == _rr.getRatPosition().getCol() && _p.inInventory) {
            _rr.killRat();
            _p.inInventory = false;
            _w.msg("Down goes the feeble creature, along with your fragile blade. Was that trade in your favor?");
        }
        if (_p.getPlayerPosition().getRow() == _rrr.getRatPosition().getRow() && _p.getPlayerPosition().getCol() == _rrr.getRatPosition().getCol() && _p.inInventory) {
            _rrr.killRat();
            _p.inInventory = false;
            _w.msg("Down goes the feeble creature, along with your fragile blade. Was that trade in your favor?");
        }
        if (_p.getPlayerPosition().getRow() == _z.getEnd().getRow() && _p.getPlayerPosition().getCol() == _z.getEnd().getCol()) {
            _p.killPlayer();
            _w.msg("You have survived fellow victor!");
            _w.option(Overwatch.OPTIONS, "Would you care to test your courage once more?");
        }
    }
    
    
    /*
     * This method records the player's input for a Game Restart or ending
     */
    public YesNo getOption(int y) {
        if (y == 0) {
            new StringMap();
        }
        else {
            System.exit(0);
        }
        return null;
    }
    
    /*
     * This method Gets the direction of the player and returns the player's location
    */
    public Direction getPlayerDirection(int x) {
        if (x == 0) {
            return Direction.North;
        }
        if (x == 1) {
            return Direction.South;
        }
        if (x == 2) {
            return Direction.East;
        }
        if (x == 3) {
            return Direction.West;
        }
        if (x == 4) {
            _w.msg("Aquire the Shard (S) as it will give you the strength to slay the Minotaur (M), but be weary as the Rats (R) will yank that shiny speckle from your graps if you walk upon them. \n You need not kill the Minotaur (M) to escape, stick to the shadows and mind your wit, as reaching the exit (E) will spare your cowardice.");
            return null;
        }
        System.exit(0);
        return null;
    }
}
