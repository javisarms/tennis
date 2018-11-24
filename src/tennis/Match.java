/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class plays out a match between two players.
 * It also includes several getters and setters such as getting and
 * setting the winner and loser of the match.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Match {
    /**
     * the players of the match
     */
    Player p1, p2;
    /**
     * the referee of the match
     */
    Referee ref;
    /**
     * the spectators of the match
     */
    Spectator[] specs;
    /**
     * the score of p1
     */
    int p1Score = 0;
    /**
     * the score of p2
     */
    int p2Score = 0;
    /**
     * how many sets have been played
     */
    int setCounter = 0;
    /**
     * a set
     */
    Set set;
    /**
     * Avoids repition of showing the winner
     */
    int count = 0;
    /**
     * the summary of the match
     */
    String summary = "";
    /**
     * the winner of the match
     */
    Player winner;
    /**
     * the loser of the match
     */
    Player loser;
    /**
     * the match data
     */
    MData data = new MData();
    
    /**
     * Class Constructor.
     * @param  x The first player in the set.
     * @param  y The second player in the set.
     * @param  r The referee in the set.
     * @param  sp The array of spectators to be used in the set.
     */
    public Match(Player x, Player y, Referee r, Spectator[] sp)
    {
        p1 = x;
        p2 = y;
        ref = r;
        specs = sp;
        summary = "MATCH START! " + p1.getFirstName() + " " + p1.getLastName() 
                + " vs. " + p2.getFirstName() + " " + p2.getLastName()
                + "------------------------------\n";
        playMatch();
    }
    
    /**
     * This class plays the entire match and determines which player won.
     */
    public void playMatch() {
        setSeats();
        if (p1Score <= 2 && p2Score <= 2) {
            set();
        }
        
        if (p1Score > 2) {
            setWinner(p1);
            setLoser(p2);
            getResult(p1);
        }
        
        else if (p2Score > 2) {
            setWinner(p2);
            setLoser(p1);
            getResult(p2);
        }        
    }
    
    /**
     * This method plays each set between two players until a winner is
     * determined. After a set is finished it goes back to the <code>
     * playMatch</code> method.
     */
    private void set() {
        if (p1Score <= 2 && p2Score <= 2) {
            set = new Set(p1, p2, ref, data);
            data.addSets();
            Player x = set.getWinner(); //returns the winner of the set
            
            //If p1 won
            if (x == p1) {
                summary += specReact();
                p1Score++;      
                summary += set.getResult(x) + " | " + p1.firstName + " " +
                        p1.blastName + ": " + p1Score + " sets ૾ " + 
                        p2.firstName + " " + p2.blastName + ": " + p2Score 
                        + "\n⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END \n";
                setSummary(summary);
                playMatch();
            } 
            
            //If p2 won
            else if (x == p2) {
                summary += specReact();
                p2Score++;
                summary += set.getResult(x) + " | " + p1.firstName + " " +
                        p1.blastName + ": " + p1Score + " sets ૾ " + 
                        p2.firstName + " " + p2.blastName + ": " + p2Score 
                        + "\n⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END \n";
                setSummary(summary);
                playMatch();
            }
        }
    }
    
    /**
     * This method gets the winner of the match and saves the winner
     * in a String.
     * @param  winner The player who won the match.
     */
    public void getResult(Player winner) {
        if (count == 0) {
            summary += winner.firstName + " " + winner.blastName
                    + " has won the match!\nMATCH END-------------------------";
            setSummary(summary);
        }
        
        count++;
    }
    
    /**
     * This method sets which player won the match.
     * @param win The player that won the match. 
     */
    private void setWinner(Player win) {
        winner = win;
    }

    /**
     * This method sets which player lost the match.
     * @param lose The player that lost the match. 
     */
    private void setLoser(Player lose) {
        loser = lose;
    }

    /**
     * This method sets which String shall be displayed as the summary
     * of the match.
     * @param line The String that will be displayed as the summary. 
     */
    private void setSummary(String line) {
        summary = line;
    }
    
    /**
     * This method returns player 1.
     * @return Player p1. 
     */
    public Player getP1() {
        return p1;
    }
    
    /**
     * This method returns player 2.
     * @return Player p2. 
     */
    public Player getP2() {
        return p2;
    }

    /**
     * This method returns which player won the match. 
     * @return Player the winner.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * This method returns which player lost the match.
     * @return Player the loser.
     */
    public Player getLoser() {
        return loser;
    }
    
    /**
     * This method returns the number of spectators present.
     * @return int of the number of spectators. 
     */
    public int getSpecNum() {
        return specs.length;
    }

    /**
     * This method returns the summary of the entire match. 
     * @return String of the summary of the match.
     */
    public String getSummary() {
        return summary;
    }
    
    /**
     * This method gives each spectator a seat number. 
     */
    private void setSeats() {
        Random r = new Random();
        for (int i = 0; i < specs.length; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            String letter = Character.toString(c);
            String seat = letter + i;
            specs[i].setSeat(seat);
        } 
    }
    
    /**
     * This method generates a reaction from the spectator in the form
     * of a String.
     * @return String of the spectator's reaction.
     */
    private String specReact() {
        int r = ThreadLocalRandom.current().nextInt(0, specs.length);
        return specs[r].react(p1Score - p2Score);
    }
}
