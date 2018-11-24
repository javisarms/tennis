/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * This class plays out a set between two players.
 * It also includes several getters and setters such as getting and
 * setting the winner and loser of the set.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Set {
    /**
     * the players of the set
     */
    Player p1, p2;
    /**
     * the referee of the set
     */
    Referee ref;
    /**
     * the score of p1
     */
    int p1Score = 0;
    /**
     * the score of p2
     */
    int p2Score = 0;
    /**
     * counts how many games have been played
     */
    int gameCounter = 0;
    /**
     * a game
     */
    Game game;
    /**
     * the summary of the set
     */
    String summary = "";
    /**
     * the winner of the set
     */
    Player winner;
    /**
     * the loser of the set
     */
    Player loser;
    /**
     * the match data
     */
    MData data;
    
    /**
     * Class Constructor.
     * @param  x The first player in the set.
     * @param  y The second player in the set.
     * @param  r The referee in the set.
     * @param  d The match data.
     */
    public Set(Player x, Player y, Referee r, MData d)
    {
        p1 = x;
        p2 = y;
        ref = r; 
        data = d;
        playSet();
    }
    
    /**
     * This class plays the entire set and determines which player won.
     */
    public void playSet()
    {
        playGame();
        data.addGames();
        
        if (p1Score > 5) {
            setWinner(p1);
        }
        
        else if (p2Score > 5) {
            setWinner(p2);
        }                
    }
    
    /**
     * This method plays a game between two players until a winner is
     * determined. After a game is finished it goes back to the <code>
     * playSet</code> method.
     */
    private void playGame() {
        game = new Game(p1, p2, ref, data);
        if (p1Score <= 5 && p2Score <= 5) {

            if (gameCounter % 2 == 0) {
                game.setServer(p1);
                game.setReceiver(p2);
                gameCounter++;
                Player x = game.getWinner(); 
                //returns the winner of the game
                if (x == p1) {
                    p1Score++;
                    
                    summary += game.getResult(x) + " | " + p1.firstName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.firstName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    
                    setSummary(summary);
                    
                    playSet();
                } else if (x == p2) {
                    p2Score++;
                    summary += game.getResult(x) + " | " + p1.firstName + " "
                            + p1.blastName + ": " + p1Score + " games ● "
                            + p2.firstName + " " + p2.blastName + ": " + p2Score
                            + "\n====================================="
                            + "======================================GAME END \n";

                    setSummary(summary);
                    playSet();
                }
            } else {
                game.setServer(p2);
                game.setReceiver(p1);
                gameCounter++;
                Player x = game.getWinner(); 
                //returns the winner of the game

                if (x == p1) {
                    p1Score++;
                    summary += game.getResult(x) + " | " + p1.firstName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.firstName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    setSummary(summary);
                    playSet();
                } else if (x == p2) {
                    p2Score++;
                    summary += game.getResult(x) + " | " + p1.firstName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.firstName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    setSummary(summary);
                    playSet();
                }
            }
        }
    }
    
    /**
     * This method gets the winner of the set and returns it
     * as a String.
     * @param  winner The player who won the game.
     * @return String which displays the winning player.
     */
    public String getResult(Player winner) {
        summary += winner.firstName + " " + winner.blastName + 
            " has won the set";   
        return summary;
    }
    
    /**
     * This method sets which player won the set.
     * @param win The player that won the set. 
     */
    private void setWinner(Player win) {
        winner = win;
    }

    /**
     * This method sets which player lost the set.
     * @param lose The player that lost the set. 
     */
    private void setLoser(Player lose) {
        loser = lose;
    }

    /**
     * This method sets which String shall be displayed as the summary
     * of the set.
     * @param line The String that will be displayed as the summary. 
     */
    private void setSummary(String line) {
        summary = line;
    }

    /**
     * This method returns which player won the set. 
     * @return Player the winner.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * This method returns which player lost the set. 
     * @return Player the loser.
     */
    public Player getLoser() {
        return loser;
    }

    /**
     * This method returns the summary of the entire set. 
     * @return String of the summary of the set.
     */
    public String getSummary() {
        return summary;
    }
}

