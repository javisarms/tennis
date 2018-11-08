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
    String summary = "";
    
    public Referee (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w)
    {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
    }
    
    public void setWinner(Player win)
    {
        winner = win;
    }
    
    public void setSummary(String line)
    {
        summary = line;
    }
    
    public Player getWinner()
    {
        return winner;
    }
    
    public String getSummary()
    {
        return summary;
    }
}
