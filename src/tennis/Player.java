/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.ArrayList;
/**
 *
 * @author javiersarmiento
 */
public class Player extends Human {
    String hand;
    String sponsor;
    int ranking;
    String coach;
    int wins = 0;
    int losses = 0;
    int tournaments;
    int prizeMoney;
    ArrayList<Integer> firstServices = new ArrayList<Integer>();
    ArrayList<Integer> secondServices = new ArrayList<Integer>();
    
    
    public Player (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w, 
            String han, String spon, String co, int ra)
    {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
        hand = han;
        sponsor = spon;
        coach = co; 
        ranking = ra;
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
    
    public int getRank()
    {
        return ranking;
    }
    
    public String getCoach()
    {
        return coach;
    }
    
    public int getWins()
    {
        return wins;
    }
    
    public int getLosses()
    {
        return losses;
    }
    
    public int getAverageFirstServe() {
        int all = 0;
        for (int i = 0; i < firstServices.size(); i++) {
            all += firstServices.get(i);
        }
        
        return all/firstServices.size();
    }
    
    public int getAverageSecondServe() {
        int all = 0;
        for (int i = 0; i < secondServices.size(); i++) {
            all += secondServices.get(i);
        }

        return all / secondServices.size();
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
    
    public void addWin() {
        wins++;
    }
    
    public void addLoss() {
        losses++;
    }
    
    public void addFirstService(Integer serve) {
        firstServices.add(serve);
    }
    
    public void addSecondService(Integer serve) {
        secondServices.add(serve);
    }
    
    public void addTournaments() {
        tournaments++;
    }
    
    public void addPrizeMoney(String w) {
        if (w == "win") {
            prizeMoney += 5000;
        }
        
        else {
            prizeMoney += 2500;
        }
        
    }
}
