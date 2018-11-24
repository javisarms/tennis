/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
//import java.util.Random;

/**
* This class plays out a game between two players.
 * It also includes several getters and setters such as getting and
 * setting the winner and loser of the game.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Game {
    /**
     * the server of the game
     */
    Player ser;
    /**
     * the receiver of the game
     */
    Player rec;
    /**
     * the referee of the game
     */
    Referee ref;
    /**
     * the score of ser
     */
    int p1Score = 0; //increments of 1
    /**
     * the score of rec
     */
    int p2Score = 0;
    /**
     * An exchange
     */
    Exchange ex;
    /**
     * the summary of the game
     */
    String summary = "";
    /**
     * the winner of the game
     */
    Player winner;
    /**
     * the loser of the game
     */
    Player loser;
    /**
     * the match data
     */
    MData data;

    /**
     * Class Constructor.
     * @param x The first player in the Game.
     * @param y The second player in the Game.
     * @param r The referee in the Game.
     * @param d The match data.
     */
    public Game(Player x, Player y, Referee r, MData d) {
        ser = x;
        rec = y;
        ref = r;
        data = d;
        playGame();
    }
    
    /**
     * This class plays an entire game and determines which player has won.
     */
    public void playGame() {
        
        exchange();
        data.addTotalPoints();

        if (p1Score > 3) {
            setWinner(ser);
        }
        
        else if (p2Score > 3) {
            setWinner(rec);
        }
    }
    
    /**
     * This method plays each exchange between two players until a winner is
     * determined. After an exchange is finished it goes back to the <code>
     * playGame</code> method.
     */
    private void exchange() {
        if (p1Score <= 3 && p2Score <= 3) {
            //determine the server alternate
            if ((p1Score+p2Score)%2 == 0) {
                ex = new Exchange(ser, rec, ref, data, 0);
            }
            
            else {
                ex = new Exchange(rec, ser, ref, data, 0);
            }
            
            Player x = ex.getWinner(); 
            //returns the winner of the exchange
            
            //If server won
            if (x == ser) {
                p1Score++;
                summary += ex.getSummary(ser) + " | [" + ser.firstName + " " +
                        ser.blastName + ": " + getP1TScore() + "]  [" + 
                        rec.firstName + " " + rec.blastName + ": " + 
                        getP2TScore() + "] \n";
                setSummary(summary);
                playGame();
            } 
            //If receiver won
            else if (x == rec) {
                p2Score++;
                summary += ex.getSummary(rec) + " | [" + ser.firstName + " " +
                        ser.blastName + ": " + getP1TScore() + "]  [" + 
                        rec.firstName + " " + rec.blastName + ": " + 
                        getP2TScore() + "] \n";
                setSummary(summary);
                playGame();
            }
        }
    }
    
    /**
     * This method converts P1's score into a tennis score (0,15,30, etc.)/
     * @return String of P1's score in the tennis format.
     */
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
    
    /**
     * This method converts P2's score into a tennis score (0,15,30, etc.)/
     * @return String of P2's score in the tennis format.
     */
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
    
    /**
     * This method gets the winner of the game and returns it
     * as a String.
     * @param  winner The player who won the game.
     * @return String which displays the winning player.
     */
    public String getResult(Player winner) {
         summary += winner.firstName + " " + winner.blastName + 
            " has won the game";   
        return summary;
    }
    
    /**
     * This method sets which player will serve during the game.
     * @param p1 The player that has been chosen as the server. 
     */
    public void setServer(Player p1) {
        ser = p1;
    }

    /**
     * This method sets which player will receive during the game.
     * @param p1 The player that has been chosen as the receiver. 
     */
    public void setReceiver(Player p1) {
        rec = p1;
    }
    
    /**
     * This method sets which player won the game.
     * @param win The player that won the game. 
     */
    private void setWinner(Player win) {
        winner = win;
    }

    /**
     * This method sets which player lost the game.
     * @param lose The player that lost the game. 
     */
    private void setLoser(Player lose) {
        loser = lose;
    }

    /**
     * This method sets which String shall be displayed as the summary
     * of the game.
     * @param line The String that will be displayed as the summary. 
     */
    private void setSummary(String line) {
        summary = line;
    }

    /**
     * This method returns which player won the game. 
     * @return Player the winner
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * This method returns which player lost the game. 
     * @return Player the loser
     */
    public Player getLoser() {
        return loser;
    }

    /**
     * This method returns the summary of the entire game.
     * @return String of the summary of the game. 
     */
    public String getSummary() {
        return summary;
    }
    
}
