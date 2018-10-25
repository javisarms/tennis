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
public class Player extends Human {
    String hand;
    String sponsor;
    int ranking;
    String coach;
    
    public Player (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w, 
            String han, String spon, int rank, String co)
    {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
        hand = han;
        sponsor = spon;
        ranking = rank;
        coach = co; 
    }
    
    //Getters
    public String getHand()
    {
        return hand;
    }
    
    public String getSponsor()
    {
        return sponsor;
    }
    
    public int getRanking()
    {
        return ranking;
    }
    
    public String getCoach()
    {
        return coach;
    }
    
    //Setters
    public void setHand(String h)
    {
        hand = h;
    }
    
    public void setSponsor(String s) 
    {
        sponsor = s;
    }
    
    public void setRanking(int r)
    {
        ranking = r;
    }
    
    public void setCoach(String c)
    {
        coach = c;
    }
}
