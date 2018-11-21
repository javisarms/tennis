/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author javiersarmiento
 */
public class Spectator extends Human {
    String seat;
    String item;
    String color;
    String ident;
    
    public Spectator(String bln, String g, String cn, String fn, String nn, 
            String bd, String bp, String dd, String nat, double h, double w, 
            String col) {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
        color = col;
        if (g == "M") {
            item = "shirt";
            ident = "Spectator " + firstName + " " + blastName + " wearing a "
                    + color + " " + item + " ";
        } else if (g == "F") {
            item = "glasses";
            ident = "Spectator " + firstName + " " + blastName + " wearing "
                    + color + " " + item + " ";
        }
    }
    
    public String react(int scoreDiff) {
        String reaction = "";
        
        if (scoreDiff == 2) {
            int r = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            if (r > 9) {
                reaction = ident + "starts sleeping at the match.";
            }
            
            else {
                reaction = ident + "boos at the match.";
            }
            
        }
        
        else {
            int r = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            if (r > 7) {
                reaction = ident + "shouts at the match.";
            } else {
                reaction = ident + "applauds at the match.";
            }
        }
        
        return reaction;
    }
}
