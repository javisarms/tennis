/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.ArrayList;
/**
 * This class is a daughter class of the <code>Human</code> class. It also 
 * contains player information and statistics.
 * @author Javier Sarmiento & Rafael Racela
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
    
    /**
     * 
     * @param bln the given last name
     * @param g the gender, either "M" or "F"
     * @param cn the current name for female players
     * @param fn the given first name
     * @param nn the given nickname
     * @param bd the birth date
     * @param bp the birth place
     * @param dd the death date
     * @param nat the nationality
     * @param h the height
     * @param w the weight
     * @param han the playing hand, either "L" or "R"
     * @param spon the sponsor of the player
     * @param co the coach
     * @param ra the preliminary ranking of the player
     */
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

    /**
     * Getter for the playing hand.
     * @return String for the playing
     */
    public String getHand()
    {
        return hand;
    }
    
    /**
     * Getter for the sponsor.
     * @return String for the sponsor
     */
    public String getSponsor()
    {
        return sponsor;
    }
    
    /**
     * Getter for the player's rank.
     * @return int of the player's rank
     */
    public int getRank()
    {
        return ranking;
    }
    
    /**
     * Getter for the coach.
     * @return String for the coach
     */
    public String getCoach()
    {
        return coach;
    }
    
    /**
     * Getter for the player's wins.
     * @return int of the player's number of wins
     */
    public int getWins()
    {
        return wins;
    }
    
    /**
     * Getter for the player's losses.
     * @return int of the player's number of losses
     */
    public int getLosses()
    {
        return losses;
    }
    
    /**
     * Getter for the player's average first serve speed.
     * @return int of the player's average first serve speed
     */
    public int getAverageFirstServe() {
        int all = 0;
        for (int i = 0; i < firstServices.size(); i++) {
            all += firstServices.get(i);
        }
        
        return all/firstServices.size();
    }
    
    /**
     * Getter for the player's average first serve speed.
     * @return int of the player's average second serve speed
     */
    public int getAverageSecondServe() {
        int all = 0;
        for (int i = 0; i < secondServices.size(); i++) {
            all += secondServices.get(i);
        }

        return all / secondServices.size();
    }
    
    //Setters
    /**
     * Sets the player's hand
     * @param h the playing hand
     */
    public void setHand(String h)
    {
        hand = h;
    }
    
    /**
     * Sets the player's sponsor
     * @param s the given sponsor
     */
    public void setSponsor(String s) 
    {
        sponsor = s;
    }
    
    /**
     * Sets the player's rankning
     * @param r the new rank
     */
    public void setRanking(int r)
    {
        ranking = r;
    }
    
    /**
     * Sets the player's coach
     * @param c the given coach
     */
    public void setCoach(String c)
    {
        coach = c;
    }
    
    /**
     * Adds to the player's total wins by 1
     */
    public void addWin() {
        wins++;
    }
    
    /**
     * Adds to the player's total losses by 1
     */
    public void addLoss() {
        losses++;
    }
    
    /**
     * Adds a serve speed the arraylist of first services' speed
     * @param serve the first serve speed
     */
    public void addFirstService(Integer serve) {
        firstServices.add(serve);
    }
    
    /**
     * Adds a serve speed the arraylist of second services' speed
     * @param serve the second serve speed
     */
    public void addSecondService(Integer serve) {
        secondServices.add(serve);
    }
    
    /**
     * Adds to the player's total tournaments by 1
     */
    public void addTournaments() {
        tournaments++;
    }
    
    /**
     * Adds to the player's total prize money depending
     * if he/she has won the game or not.
     * @param w determines if the player has won or lost
     */
    public void addPrizeMoney(String w) {
        if (w == "win") {
            prizeMoney += 5000;
        }
        
        else {
            prizeMoney += 2500;
        }
        
    }
}
