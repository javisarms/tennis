/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 *
 * @author javiersarmiento
 */
public class Match {
    Player p1;
    Player p2;
    Referee ref;
    Set s;
    
    public Match(Player x, Player y, Referee r)
    {
        p1 = x;
        p2 = y;
        ref = r;
        s = new Set();
    }
}
