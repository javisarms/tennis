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
    
    public String getLastName()
    {
        return blastName;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getCommonName()
    {
        return currentName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getNickName()
    {
        return nickName;
    }
    
    public void setCurrentName(String cn)
    {
        currentName = cn;
    }
    
}
