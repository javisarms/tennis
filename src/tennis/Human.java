/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * This is a parent class which makes a human (To be used in making a player,
 * referee, etc.).
 * @author Javier Sarmiento & Rafael Racela
 */
public class Human {
    
    String blastName;
    String gender;
    String currentName;
    String firstName;
    String nickName;
    String birthDate;
    String birthPlace;
    String deathDate;
    String nation;
    double height;
    double weight;
    
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
    public Human (String bln, String g, String cn, String fn, String nn, String 
            bd, String bp, String dd, String nat, double h, double w)
    {
         blastName = bln;
         gender = g;
         currentName = cn; //
         firstName = fn;
         nickName = nn;
         birthDate = bd;
         birthPlace = bp;
         deathDate = dd;
         nation = nat;
         height = h;
         weight = w;
    }
    
    /**
     * Getter for the last name.
     * @return String for the last name
     */
    public String getLastName()
    {
        return blastName;
    }
    
    /**
     * Getter for the gender.
     *
     * @return String for gender
     */
    public String getGender()
    {
        return gender;
    }
    
    /**
     * Getter for the common name.
     *
     * @return String for the common name
     */
    public String getCommonName()
    {
        return currentName;
    }
    
    /**
     * Getter for the first name.
     *
     * @return String for the first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Getter for the nick name.
     *
     * @return String for the nick name
     */
    public String getNickName()
    {
        return nickName;
    }
    
    /**
     * Setter for the current name.
     * @param cn the given current name
     */
    public void setCurrentName(String cn)
    {
        currentName = cn;
    }
    
}
