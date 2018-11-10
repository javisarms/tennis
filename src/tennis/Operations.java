/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javiersarmiento
 */
public class Operations {
    //This class does all the operations so that the main method isn't as
    //cluttered
    
    int year = 2018;
    Player[] males;
    Player[] females;
    Referee[] refs;
    ArrayList<Tournament> currentTournaments = new ArrayList<Tournament>();
    ArrayList<Tournament> pastTournaments = new ArrayList<Tournament>();
    Scanner input = new Scanner(System.in);
    
    public Operations(Player[] m, Player[] f, Referee[] r) {
        males = m;
        females = f;
        refs = r;
        generateCurrentTournaments();
    }
    
    //=========================================================================
    //TOURNAMENTS
    //=========================================================================
    
    public void tourMode() {
        //If the year's tours are done, make for the new year
        if (currentTournaments.isEmpty()) {
            System.out.printf("That's it for %s, welcome to the new year!"
                    , year);
            year++;
            generateCurrentTournaments();
        }
        System.out.printf("\nTOURNAMENTS - %s\n", year);
        System.out.println("1 - View Current Tournament");
        System.out.println("2 - View Future Tournaments");
        System.out.println("3 - View Past Tournaments");
        System.out.println("4 - Exit");
        System.out.print("\nEnter Your Choice: ");
        String choice = input.next();

        switch(choice) {
            case "1":
                currTournament();
                break;
            case "2":
                viewFutureTournaments();
                break;
            case "3":
                viewPastTournaments();
                break;
            case "4":
                return;
            default:
                System.out.println("This is not a valid Menu Option!");
                break;
        }
    }
    
    //Displays data about the current tournament in play
    private void currTournament() {
        //Select the tournament
        Tournament t = null;
        for (int i = 0; i < currentTournaments.size(); i++) {
            if (currentTournaments.get(i) != null) {
                t = currentTournaments.get(i);
                break;
            }
        }
        System.out.println("\nCurrent Tournament");
        System.out.printf("%s %s\n", t.name, year);
        System.out.printf("Status: %s\n", t.getStatus());
        System.out.println("1 - Play the round");
        System.out.println("2 - View results");
        System.out.println("3 - Exit");
        System.out.print("\nEnter Your Choice: ");
        String choice = input.next();

        switch (choice) {
            case "1":
                t.playTournament();
                if (t.getProg() == 7) {
                    //If the finals are done, remove the tournament from 
                    //currentTournaments and put into the past
                    currentTournaments.remove(t);
                    pastTournaments.add(t);
                }
                break;
            case "2":
                t.viewResults();
                break;
            case "3":
                return;
            default:
                System.out.println("This is not a valid Menu Option!");
                break;
        }
    }
    
    //VIEW FUTURE TOURNAMENTS FOR THE YEAR  
    private void viewFutureTournaments() {
        System.out.println("");
        for (int i = 0; i < currentTournaments.size(); i++) {
            if (currentTournaments.get(i).getYear() == year) {
                System.out.printf("%s %s\n", currentTournaments.get(i).name,
                        year);
            }
        }
    }
    
    //VIEW PAST TOURNAMENTS AND ITS SUMMARY/RESULTS 
    private void viewPastTournaments() {
        System.out.println("");
        for (int i = 0; i < pastTournaments.size(); i++) {
            System.out.printf("%s - %s %s\n", i+1, year, 
            pastTournaments.get(i).name);
        }
        System.out.println("\nInput tournament number to view details");
        System.out.println("Input '00' to return");
        int tourChoice = input.nextInt();
        if (tourChoice == 00) {
            return;
        } else {
            viewPastTournament(tourChoice);
        }
    }
    
    private void viewPastTournament(int i) {
        Tournament t = pastTournaments.get(i-1);
        System.out.printf("\n%s %s", t.getYear(), t.name);
        System.out.printf("\nFinals: %s def. %s",
        t.getMaleWinner()[0].getWinner().blastName, 
        t.getMaleWinner()[0].getLoser().blastName );
        System.out.println("--------------------------------------\n");
        t.viewResults();
        
    }
    
    //generates tournaments for the year
    private void generateCurrentTournaments() {
        Tournament a = new Tournament(1, males, females, refs, year);
        Tournament b = new Tournament(2, males, females, refs, year);
        Tournament c = new Tournament(3, males, females, refs, year);
        Tournament d = new Tournament(4, males, females, refs, year);
        currentTournaments.add(0, a);
        currentTournaments.add(1, b);
        currentTournaments.add(2, c);
        currentTournaments.add(3, d);
    }
    
    
    //=========================================================================
    //VIEWING PLAYERS
    //=========================================================================
    
    public void viewPlayers() {
        System.out.println("\nPLAYERS");
        System.out.println("1 - Males");
        System.out.println("2 - Females");
        System.out.println("3 - Exit");
        System.out.print("\nEnter Your Choice: ");
        String choice = input.next();
        
        switch(choice) {
            case "1":
                System.out.println("\nMALE PLAYERS");
                for (int i = 0; i < males.length; i++) {
                    System.out.printf("%s - %s %s\n", males[i].getRank(),
                        males[i].getFirstName(), males[i].getLastName());
                }
                System.out.println("\nInput player rank to view player");
                System.out.println("Input '00' to return");
                int playerChoice = input.nextInt();
                if (playerChoice == 00) {
                    return;
                }
                else {
                    viewPlayer(playerChoice, males);
                }
                break;
                
            case "2":
                System.out.println("\nFEMALE PLAYERS");
                for (int i = 0; i < females.length; i++) {
                    System.out.printf("%s - %s %s\n", females[i].getRank(),
                        females[i].getFirstName(), females[i].getLastName());
                }
                System.out.println("\nInput player rank to view player");
                System.out.println("Input '00' to return");
                playerChoice = input.nextInt();
                if (playerChoice == 00) {
                    return;
                } else {
                    viewPlayer(playerChoice, females);
                }
                break;

            case "3":
                return;//

            default:
                System.out.println("This is not a valid Menu Option!");
                break;
        }
    }
    
    //Insertion sort method
    private void rankPlayers() {
        Player temp;
        for (int i = 1; i < males.length; i++) {
            for (int j = i; j > 0; j--) {
                if (males[j].getRank() < males[j - 1].getRank()) {
                    temp = males[j];
                    males[j] = males[j - 1];
                    males[j - 1] = temp;
                }
            }
        }
        
        Player temp2;
        for (int i = 1; i < females.length; i++) {
            for (int j = i; j > 0; j--) {
                if (females[j].getRank() < females[j - 1].getRank()) {
                    temp2 = females[j];
                    females[j] = females[j - 1];
                    females[j - 1] = temp2;
                }
            }
        }
    }
    
    private void viewPlayer(int rank, Player[] players) {
        Player player = players[rank-1];
        System.out.printf("\nRank: %s", rank);
        System.out.printf("\nName: %s %s", player.getFirstName(), player.getLastName());
        System.out.printf("\nNickname: %s", player.getNickName());
        System.out.printf("\nBirthdate: %s", player.birthDate);
        System.out.printf("\nBirthplace: %s", player.birthPlace);
        System.out.printf("\nCountry: %s", player.nation);
        System.out.printf("\nHeight: %s", player.height);
        System.out.printf("\nWeight: %s", player.weight);
        System.out.printf("\nHand: %s", player.getHand());
        System.out.printf("\nSponsor: %s", player.getSponsor());
        System.out.printf("\nCoach: %s", player.getCoach());
        
        System.out.print("\nEnter any key to return: ");

        String choice = input.next();

        switch (choice) {
            default:
                return;
        }
    }
    
}
