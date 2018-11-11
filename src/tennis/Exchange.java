/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Random;

/**
 *
 * @author javiersarmiento
 */
public class Exchange {
    Player ser;
    Player rec;
    Referee ref;
    Random r = new Random();
    String summary;
    Player winner;
    Player loser;
    
    public Exchange(Player x, Player y, Referee r, int i) {
        ser = x;
        rec = y;
        ref = r;
        service(i);
    }
    
    public void service(int f) {
        int faultCount = f;
        float chance = r.nextFloat(); //generates a random float
        
        //Chance of winning
        if (chance <= 0.5f) {
            setWinner(ser);
        }
        
        //Service fault
        else {
            setWinner(rec);
//            if(faultCount == 0) {
//                faultCount ++;
//                winner = null;
//                service(faultCount);
//            }
//            
//            else {
//                winner = rec;
//            }
        }
        
    }
    
    //Displays the outcome of the exchange
    public String getResult(Player winner) {
        String result;
        
        result = winner.nickName + " " + winner.blastName + 
                " has won the exchange";
        
        
        return result;
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
