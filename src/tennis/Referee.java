/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * This class is a daughter class of the <code>Human</code> class for referees.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Referee extends Human {
    
    /**
     * Class Constructor.
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
     */
    public Referee (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w)
    {
        super(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
    }
    
}
