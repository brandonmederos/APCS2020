// 
// Decompiled by Procyon v0.5.36
// 

package view;

import mod.Sword;
import mod.Maze;
import mod.Rat3;
import mod.Rat2;
import mod.Rat;
import mod.Minotaur;
import mod.Player;

public class StringMap
{
    private String _map;
    
    public StringMap() {
        this._map = "";
    }
    
    public String updateMap(final Player p, final Minotaur m, final Rat r1, final Rat2 rr, final Rat3 rrr, final Maze z, final Sword a) {
        this._map = "";
        for (int r2 = 0; r2 < z.getMaze().length; ++r2) {
            for (int c = 0; c < z.getMaze()[0].length; ++c) {
                if (z.getMaze()[r2][c]) {
                    this._map = String.valueOf(this._map) + "W";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == p.getPlayerPosition().getRow() && c == p.getPlayerPosition().getCol()) {
                    this._map = String.valueOf(this._map) + "P";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == m.getMinotaurPosition().getRow() && c == m.getMinotaurPosition().getCol() && !p.hasSkull(m)) {
                    this._map = String.valueOf(this._map) + "M";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == z.getEnd().getRow() && c == z.getEnd().getCol()) {
                    this._map = String.valueOf(this._map) + "E";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == r1.getRatPosition().getRow() && c == r1.getRatPosition().getCol() && !p.hasRat1(r1)) {
                    this._map = String.valueOf(this._map) + "R";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                    else if (!r1.isAlive()) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == rr.getRatPosition().getRow() && c == rr.getRatPosition().getCol() && !p.hasRat2(rr)) {
                    this._map = String.valueOf(this._map) + "R";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                    else if (!rr.isAlive()) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == rrr.getRatPosition().getRow() && c == rrr.getRatPosition().getCol() && !p.hasRat3(rrr)) {
                    this._map = String.valueOf(this._map) + "R";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                    else if (!rrr.isAlive()) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else if (r2 == a.getSwordPosition().getRow() && c == a.getSwordPosition().getCol() && !p.hasSword(a)) {
                    this._map = String.valueOf(this._map) + "S";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
                else {
                    this._map = String.valueOf(this._map) + ":  :";
                    if (c != z.getMaze()[0].length - 1) {
                        this._map = String.valueOf(this._map) + " ";
                    }
                }
            }
            this._map = String.valueOf(this._map) + "\n";
        }
        return this._map;
    }
}
