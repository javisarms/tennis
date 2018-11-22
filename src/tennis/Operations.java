/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class helps the main method making the code neater for the coders.
 * It is in charge of all the operations of the program.
 * @author javiersarmiento
 */
public class Operations {
    
    int year = 2018;
    Player[] males;
    Player[] females;
    Referee[] refs;
    Spectator[] specs;
    ArrayList<Tournament> currentTournaments = new ArrayList<Tournament>();
    ArrayList<Tournament> pastTournaments = new ArrayList<Tournament>();
    Scanner input = new Scanner(System.in);
    
    /**
     * Class Constructor.
     * @param m the array of male players to be used in the program
     * @param f the array of female players to be used in the program
     * @param r the array of referees to be used in the program
     */
    public Operations(Player[] m, Player[] f, Referee[] r) {
        males = m;
        females = f;
        refs = r;
        generateCurrentTournaments();
    }
    
    //=========================================================================
    //TOURNAMENTS
    //=========================================================================
    
    /**
     * Acts as the main menu of the tournament mode wherein the user can choose
     * multiple options regarding all things regarding a tournament. This public
     * method is being used in the main method.
     */
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
    
    /**
     * This chooses the current tournament being played and shows all its
     * necessary info. It also acts as the menu for the tournament, leaving the
     * user to choose between playing or viewing the results of the tournament.
     */
    
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
        System.out.printf("%s - %s\n", t.place, t.surface);
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
    
    /**
     * This shows the upcoming tournaments for the remainder of the year.
     * There is a maximum of 4 tournaments per year (Grand Slam tournaments),
     * and of course, a minimum of one.
     */ 
    private void viewFutureTournaments() {
        System.out.println("");
        for (int i = 0; i < currentTournaments.size(); i++) {
            if (currentTournaments.get(i).getYear() == year) {
                System.out.printf("%s %s\n", currentTournaments.get(i).name,
                        year);
            }
        }
    }
    
    /**
     * Shows all the completed tournaments so far in the program. The user
     * can then opt to view more details about a particular tournament.
     */
    
    private void viewPastTournaments() {
        System.out.println("");
        for (int i = 0; i < pastTournaments.size(); i++) {
            System.out.printf("%s - %s %s\n", i+1, year, 
            pastTournaments.get(i).name);
        }
        System.out.println("Input tournament number to view details");
        System.out.println("Input '00' to return");
        int tourChoice = input.nextInt();
        if (tourChoice == 00) {
            return;
        } else {
            viewPastTournament(tourChoice);
        }
    }
    
    /**
     * This shows the summary and details of the past tournament chosen in
     * the <code>viewPastTournaments</code> method.
     * @param i the number of the tournament chosen, to be used to get the index
     */
    private void viewPastTournament(int i) {
        Tournament t = pastTournaments.get(i-1);
        System.out.printf("\n%s %s", t.getYear(), t.name);
        System.out.printf("\n%s - %s", t.place, t.surface);
        System.out.printf("\nMen's Finals: %s def. %s",
        t.data.getMaleWinner()[0].getWinner().blastName, 
        t.data.getMaleWinner()[0].getLoser().blastName );
        System.out.printf("\nWomen's Finals: %s def. %s",
                t.data.getFemaleWinner()[0].getWinner().blastName,
                t.data.getFemaleWinner()[0].getLoser().blastName);
        System.out.printf("\nAverage attendance: %s", t.data.getAvgSpec());
        System.out.printf("\nTotal balls used: %s", t.data.getBalls());
        System.out.printf("\nTotal hats sold: %s", t.data.getHats());
        System.out.printf("\nTotal drinks sold: %s", t.data.getBottles());
        System.out.println("\n--------------------------------------");
        t.viewResults();
        
    }
    
    /**
     * Once a year is completed, this method generates all the four Grand Slam
     * events for the playing year.
     */
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
    
    /**
     * This public method shows all the players in the program. The user can
     * choose between viewing the male or female players. The user can then
     * choose a specific player to view his/her personal details/statistics.
     */
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
    
    /**
     * The method simply makes sure that the players' arrays are arranged by
     * rank using an insertion sort algorithm.
     */
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
    
    /**
     * Shows the details of a particular player chosen from the <code>
     * viewPlayers</code> method.
     * @param rank the chosen rank of the player the user wishes to use
     * @param players the array of players, either males or females
     */
    private void viewPlayer(int rank, Player[] players) {
        Player player = players[rank-1];
        System.out.printf("\nName: %s %s", player.getFirstName(), player.getLastName());
        System.out.printf("\nPrize money: USD %s", player.prizeMoney);
        System.out.printf("\nTournaments: %s", player.tournaments);
        System.out.printf("\nRank: %s | Wins: %s | Losses: %s", rank
        , player.getWins(), player.getLosses());
        System.out.printf("\nNickname: %s", player.getNickName());
        System.out.printf("\nBirthdate: %s", player.birthDate);
        System.out.printf("\nBirthplace: %s", player.birthPlace);
        System.out.printf("\nCountry: %s", player.nation);
        System.out.printf("\nHeight: %s", player.height);
        System.out.printf("\nWeight: %s", player.weight);
        System.out.printf("\nAverage first serve: %s kph", 
                player.getAverageFirstServe());
        System.out.printf("\nAverage second serve: %s kph",
                player.getAverageSecondServe());
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
