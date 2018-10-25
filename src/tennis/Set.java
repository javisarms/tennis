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
    Referee ref;
    Game game;
    
    public Set(Player x, Player y, Referee r)
    {
        p1 = x;
        p2 = y;
        ref = r; 
    }
    
    public Player playSet()
    {
        game = new Game(p1, p2, ref);
        Player winner = null;
        if (p1Score <= 5 && p2Score <= 5) {
            
            if (gameCounter % 2 == 0) {
                game.setServer(p1);
                game.setReceiver(p2);
                gameCounter++;
                Player x = game.playGame(); //returns the winner of the game
                game.getResult(x);
                if (x == p1) {
                    p1Score++;
                    System.out.println("p1:" + p1Score);
                    playSet();
                }
                else if (x == p2) {
                    p2Score++;
                    System.out.println("p2:" + p2Score);
                    playSet();
                }
            }
            else {
                game.setServer(p2);
                game.setReceiver(p1);
                gameCounter++;
                Player x = game.playGame(); //returns the winner of the game
                game.getResult(x);
                if (x == p1) {
                    p1Score++;
                    System.out.println("p1:" + p1Score);
                    playSet();
                }
                else if (x == p2) {
                    p2Score++;
                    System.out.println("p2:" + p2Score);
                    playSet();
                }
            }
        }
        
        else if (p1Score > 5) {
            winner = p1;
            getResult(winner);
            p1Score = 0;
            p2Score = 0; 
        }
        
        else if (p2Score > 5) {
            winner = p2;
            getResult(winner);
            p1Score = 0;
            p2Score = 0;
        }
                
        return winner;
    }
    
    public void getResult(Player winner) {
        String result;
        
        result = winner.nickName + " " + winner.blastName + 
        " has won the set";

        System.out.println(result);
    }
}

