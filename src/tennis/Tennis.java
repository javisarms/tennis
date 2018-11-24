/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Scanner;

/**
 * The main method of the project
 * @author Javier Sarmiento and Rafael Racela
 */
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        /**
         * a new generate
         */
        Generate g = new Generate();
        /**
         * the male players
         */
        Player[] males = new Player[128];
        /**
         * the female players
         */
        Player[] females = new Player[128];
        /**
         * the referees
         */
        Referee[] refs = new Referee[64];

        for (int i = 0; i < 128; i++) {
            males[i] = g.generateMalePlayer();
            females[i] = g.generateFemalePlayer();
        }
        for (int i = 0; i < 12; i++) {
            refs[i] = g.generateReferee();
        }
        
        Operations main = new Operations(males,females,refs);
        
        //Main Menu
        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;
        String choice;
        while (true) {
            System.out.println("\nTennis! " + main.year);
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
