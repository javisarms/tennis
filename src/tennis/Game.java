/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
//import java.util.Random;

/**
 *
 * @author javiersarmiento
 */
public class Game {
    Player ser;
    Player rec;
    Referee ref;
    int p1Score = 0; //increments of 1
    int p2Score = 0;
    Exchange ex;
    String summary = "";

    public Game(Player x, Player y, Referee r) {
        ser = x;
        rec = y;
        ref = r;
    }
    
    public Referee playGame() {
        
        exchange();
        
        if (p1Score > 3) {
            ref.setWinner(ser);
        }
        
        else if (p2Score > 3) {
            ref.setWinner(rec);
        }
        
        return ref;
    }
    
    private void exchange() {
        if (p1Score <= 3 && p2Score <= 3) {
            ex = new Exchange(ser, rec, ref);
            Player x = ex.service(0).getWinner(); 
            //returns the winner of the exchange
            
            //If server won
            if (x == ser) {
                p1Score++;
                summary += ex.getResult(x) + " | [" + ser.nickName + " " +
                        ser.blastName + ": " + getP1TScore() + "]  [" + 
                        rec.nickName + " " + rec.blastName + ": " + 
                        getP2TScore() + "] \n";
                ref.setSummary(summary);
                playGame();
            } 
            //If receiver won
            else if (x == rec) {
                p2Score++;
                summary += ex.getResult(x) + " | [" + ser.nickName + " " +
                        ser.blastName + ": " + getP1TScore() + "]  [" + 
                        rec.nickName + " " + rec.blastName + ": " + 
                        getP2TScore() + "] \n";
                ref.setSummary(summary);
                playGame();
            }
        }
    }
    
    //This gets the equivalent of p1score as a tennis score (0,15,30, etc.)
    private String getP1TScore() {
        String p1TScore = null;
        
        switch (p1Score) {
            case 0:
                p1TScore = "0";
                break;
            case 1:
                p1TScore = "15";
                break;
            case 2:
                p1TScore = "30";
                break;
            case 3:
                p1TScore = "40";
                break;
            case 4:
                p1TScore = "WINNER";
                break;
            default:
                break;
        }
            
        
        return p1TScore;
    }
    
    //This gets the equivalent of p2score as a tennis score (0,15,30, etc.)
    private String getP2TScore() {
        String p2TScore = null;
        
        switch (p2Score) {
            case 0:
                p2TScore = "0";
                break;
            case 1:
                p2TScore = "15";
                break;
            case 2:
                p2TScore = "30";
                break;
            case 3:
                p2TScore = "40";
                break;
            case 4:
                p2TScore = "WINNER";
                break;

            default:
                break;
        }
        
        return p2TScore;
    }
    
    public String getResult(Player winner) {
         summary += winner.nickName + " " + winner.blastName + 
            " has won the game";   
        return summary;
    }
    
    public void setServer(Player p1) {
        ser = p1;
    }

    public void setReceiver(Player p1) {
        rec = p1;
    }
    
}
