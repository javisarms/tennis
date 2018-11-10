/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Scanner;

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
        
        //TODO
        //Generate random players, referees, and spectators
        Generate g = new Generate();
        Player[] males = new Player[128];
        Player[] females = new Player[128];
        Referee[] refs = new Referee[12];
        for (int i = 0; i < 128; i++) {
            males[i] = g.generateMalePlayer();
            females[i] = g.generateFemalePlayer();
        }
        
        for (int i = 0; i < 12; i++) {
            refs[i] = g.generateReferee();
        }
        
        Operations main = new Operations(males,females,refs);
        
        //Menu
        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;
        String choice;
        while (true) {
            System.out.println("\nTennis!");
            System.out.print("1.) Tournaments \n");
            System.out.print("2.) Players \n");
            System.out.print("3.) Exit \n");
            System.out.print("\nEnter Your Choice: ");

            choice = input.next();

            switch (choice) {

                case "1":
                    main.tourMode();
                    break;
                    
                case "2":
                    main.viewPlayers();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("This is not a valid Menu Option!");
                    break;

            }
        }
    }
}
