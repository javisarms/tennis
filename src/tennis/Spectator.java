/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;
/**
 * This class is a daughter class of the <code>Human</code> class a spectator.
 * It includes additional information like seat number, item, and color of item.
 * @author javiersarmiento
 */
public class Spectator extends Human {
    String seat;
    String item;
    String color;
    String ident;

    /**
     * Constructor class. The item is assigned here based on one's gender.
     * @param bln the given last name
     * @param g the gender, either "M" or "F"
     * @param cn the current name for female players
     * @param fn the given first name
     * @param nn the given nickname
     * @param bd the birth date
     * @param bp the birth place
     * @param dd the death date
     * @param nat the nationality
     * @param h the height
     * @param w the weight
     * @param col the given color if the item
     */
    public Spectator(String bln, String g, String cn, String fn, String nn, 
            String bd, String bp, String dd, String nat, double h, double w, 
            String col) {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
        color = col;
        if (g == "M") {
            item = "shirt";
        } else if (g == "F") {
            item = "glasses";
        }
    }
    
    /**
     * This method generates a reaction from the spectator based on the score
     * of the match. If the match is one-sided the spectator can boo or sleep
     * (this is rare as it happens only around less than 20%). If the match is
     * close, the spectator can applaud or shout, with a higher tendency to applaud.
     * @param scoreDiff the difference of set scores in the current match
     * @return String of the reaction of the fan
     */
    public String react(int scoreDiff) {
        String reaction = "";
        
        if (scoreDiff == 2) {
            int r = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            if (r > 9) {
                reaction = "~~" + ident + "starts sleeping at the match.~~\n";
            }
            
            else {
                reaction = "~~" + ident + "boos at the match.~~\n";
            }
            
        }
        
        else {
            int r = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            if (r > 7) {
                reaction = "~~" + ident + "shouts at the match.~~\n";
            } else {
                reaction = "~~" + ident + "applauds at the match.~~\n";
            }
        }
        
        return reaction;
    }
    
    /**
     * The method sets the seat number of the fan. It also sets
     * the <code>ident</code> field, which summarizes the spectator
     * information, for ease of use in the <code>react</code> method.
     * @param s the seat number
     */
    public void setSeat(String s) {
        seat = s;
        if (gender == "M") {
            ident = "Spectator " + firstName + " " + blastName + " wearing a "
                    + color + " " + item + " from seat " + seat + " ";
        } else if (gender == "F") {
            ident = "Spectator " + firstName + " " + blastName + " wearing "
                    + color + " " + item + " from seat " + seat + " ";
        }
    }
}
