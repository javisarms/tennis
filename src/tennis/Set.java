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
public class Set {
    Player p1, p2;
    int p1Score = 0;
    int p2Score = 0;
    int gameCounter = 0;
    String summary = "";
    Referee ref;
    Game game;
    Player winner;
    Player loser;
    
    
    public Set(Player x, Player y, Referee r)
    {
        p1 = x;
        p2 = y;
        ref = r; 
        playSet();
    }
    
    public Referee playSet()
    {
        playGame();
        
        if (p1Score > 5) {
            setWinner(p1);
        }
        
        else if (p2Score > 5) {
            setWinner(p2);
        }
                
        return ref;
    }
    
    private void playGame() {
        game = new Game(p1, p2, ref);
        if (p1Score <= 5 && p2Score <= 5) {

            if (gameCounter % 2 == 0) {
                game.setServer(p1);
                game.setReceiver(p2);
                gameCounter++;
                Player x = game.getWinner(); 
                //returns the winner of the game
                if (x == p1) {
                    p1Score++;
                    
                    summary += game.getResult(x) + " | " + p1.nickName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.nickName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    
                    setSummary(summary);
                    
                    playSet();
                } else if (x == p2) {
                    p2Score++;
                    summary += game.getResult(x) + " | " + p1.nickName + " "
                            + p1.blastName + ": " + p1Score + " games ● "
                            + p2.nickName + " " + p2.blastName + ": " + p2Score
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
                    summary += game.getResult(x) + " | " + p1.nickName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.nickName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    setSummary(summary);
                    playSet();
                } else if (x == p2) {
                    p2Score++;
                    summary += game.getResult(x) + " | " + p1.nickName + " " +
                        p1.blastName + ": " + p1Score + " games ● " + 
                        p2.nickName + " " + p2.blastName + ": " + p2Score 
                        + "\n====================================="
                        + "======================================GAME END \n";
                    setSummary(summary);
                    playSet();
                }
            }
        }
    }
    
    public String getResult(Player winner) {
        summary += winner.nickName + " " + winner.blastName + 
            " has won the set";   
        return summary;
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

