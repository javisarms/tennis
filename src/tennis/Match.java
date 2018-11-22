/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author javiersarmiento
 */
public class Match {
    Player p1;
    Player p2;
    Referee ref;
    Spectator[] specs;
    int p1Score = 0;
    int p2Score = 0;
    int setCounter = 0;
    Set set;
    String summary = "";
    int count = 0; //Avoids repition of showing the winner
    Player winner;
    Player loser;
    MData data = new MData();
    
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
    
    public Referee playMatch() {
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
        
        return ref;
    }
    
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
    
    public void getResult(Player winner) {
        if (count == 0) {
            summary += winner.firstName + " " + winner.blastName
                    + " has won the match!\nMATCH END-------------------------";
            setSummary(summary);
        }
        
        count++;
    }
    
    private void setWinner(Player win) {
        winner = win;
    }

    private void setLoser(Player lose) {
        loser = lose;
    }

    private void setSummary(String line) {
        summary = line;
    }
    
    public Player getP1() {
        return p1;
    }
    
    public Player getP2() {
        return p2;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }
    
    public int getSpecNum() {
        return specs.length;
    }

    public String getSummary() {
        return summary;
    }
    
    private void setSeats() {
        Random r = new Random();
        for (int i = 0; i < specs.length; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            String letter = Character.toString(c);
            String seat = letter + i;
            specs[i].setSeat(seat);
        } 
    }
    
    private String specReact() {
        int r = ThreadLocalRandom.current().nextInt(0, specs.length);
        return specs[r].react(p1Score - p2Score);
    }
}
