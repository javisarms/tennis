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
public class Referee extends Human {
    Player winner;
    Player loser;
    String summary = "";
    Player p1;
    Player p2;
    
    public Referee (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w)
    {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
    }
    
    public void setWinner(Player win)
    {
        winner = win;
    }
    
    public void setLoser(Player lose)
    {
        loser = lose;
    }
    
    public void setSummary(String line)
    {
        summary = line;
    }
    
    public void setP1(Player p)
    {
        p1 = p;
    }
    
    public void setP2(Player p)
    {
        p2 = p;
    }
    
    public Player getWinner()
    {
        return winner;
    }
    
    public Player getLoser()
    {
        return loser;
    }
    
    public Player getP1()
    {
        return p1;
    }
    
    public Player getP2()
    {
        return p2;
    }
    
    public String getSummary()
    {
        return summary;
    }
}
