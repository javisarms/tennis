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
    
    public Player service(int f) {
        int faultCount = f;
        float chance = r.nextFloat(); //generates a random float
        Player winner;
        
        //50% chance of winning
        if (chance <= 0.5f) {
            winner = ser;
        }
        
        //Service fault
        else {
            winner =  rec;
        }
        
        return winner;
    }
        
    public void getResult(Player winner) {
        String result;
        
        result = winner.nickName + " " + winner.blastName + 
                " has won the exchange";
        
        
        System.out.println(result);
    }
}
