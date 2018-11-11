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
    int p1Score = 0;
    int p2Score = 0;
    int setCounter = 0;
    Set set;
    String summary = "";
    int count = 0; //Avoids repition of showing the winner
    Player winner;
    Player loser;
    
    public Match(Player x, Player y, Referee r)
    {
        p1 = x;
        p2 = y;
        ref = r;
        summary = "MATCH START! " + p1.blastName + " vs. " + p2.blastName 
                + "------------------------------\n";
        playMatch();
    }
    
    public Referee playMatch() {
        
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
            set = new Set(p1, p2, ref);
            Player x = set.getWinner(); //returns the winner of the set
            
            //If p1 won
            if (x == p1) {
                p1Score++;      
                summary += set.getResult(x) + " | " + p1.nickName + " " +
                        p1.blastName + ": " + p1Score + " sets ૾ " + 
                        p2.nickName + " " + p2.blastName + ": " + p2Score 
                        + "\n⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END \n";
                setSummary(summary);
                playMatch();
            } 
            
            //If p2 won
            else if (x == p2) {
                p2Score++;
                summary += set.getResult(x) + " | " + p1.nickName + " " +
                        p1.blastName + ": " + p1Score + " sets ૾ " + 
                        p2.nickName + " " + p2.blastName + ": " + p2Score 
                        + "\n⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END \n";
                setSummary(summary);
                playMatch();
            }
        }
    }
    
    public void getResult(Player winner) {
        if (count == 0) {
            summary += winner.nickName + " " + winner.blastName
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

    public String getSummary() {
        return summary;
    }
}
