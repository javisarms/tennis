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
    
    public Exchange(Player x, Player y, Referee r) {
        ser = x;
        rec = y;
        ref = r;
    }
    
    public Referee service(int f) {
        int faultCount = f;
        float chance = r.nextFloat(); //generates a random float
        
        //Chance of winning
        if (chance <= 0.5f) {
            ref.setWinner(ser);
        }
        
        //Service fault
        else {
            ref.setWinner(rec);
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
        
        return ref;
    }
    
    //Displays the outcome of the exchange
    public String getResult(Player winner) {
        String result;
        
        result = winner.nickName + " " + winner.blastName + 
                " has won the exchange";
        
        
        return result;
    }
}
