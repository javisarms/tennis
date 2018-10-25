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
    //Random r = new Random();

    public Game(Player x, Player y, Referee r) {
        ser = x;
        rec = y;
        ref = r;
        ex = new Exchange(ser, rec, ref);
    }
    
    public Player playGame() {
        
        Player winner = null;
        exchange();
        if (p1Score > 3) {
            winner = ser;
        }
        
        else if (p2Score > 3) {
            winner = rec;
        }
        
        return winner;
    }
    
    private void exchange() {
        if (p1Score <= 3 && p2Score <= 3) {
            Player x = ex.service(0); //returns the winner of the exchange
            ex.getResult(x);
            //If server won
            if (x == ser) {
                p1Score++;
                //System.out.println("p1:" + p1Score);
                playGame();
            } else if (x == rec) {
                p2Score++;
                //System.out.println("p2:" + p2Score);
                playGame();
            }

        }
    }
    
    
    public void getResult(Player winner) {
        String result;
        
        result = winner.nickName + " " + winner.blastName + 
        " has won the game";

        System.out.println(result);
    }
    
    public void setServer(Player p1) {
        ser = p1;
    }

    public void setReceiver(Player p1) {
        rec = p1;
    }
    
}
