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
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double height = 168.8;
        double weight = 60.2;
        Player a = new Player("Doe", "M", "Doe", "John", "John", "01/11/98", "",
                "None", "PHI", height, weight, "R", "Coke", 1, "Steve");
        Player b = new Player("Doe", "M", "Doe", "Jake", "Jake", "01/11/98", "",
                "None", "PHI", height, weight, "R", "Coke", 1, "Steve");
        Referee ref = new Referee("Doe", "M", "Doe", "Javi", "Javi", "01/11/98",
                "", "None", "PHI", height, weight);
        Set ex = new Set(a, b, ref);
        ex.playSet();
    }
    
}
