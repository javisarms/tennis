/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author javiersarmiento
 */
public class Tournament {
    Scanner input = new Scanner(System.in);
    TData data = new TData();
    String name;
    String place;
    String surface;
    Player[] males;
    Player[] females;
    Referee[] refs;
    
    int tournamentProgress = 0; //indicates which stage the tournament is in
    //0 = 128, 1 = 64, 2 = 32, 3 = 16, 4 = 8, 5 = 4, 6 = 2, 7 = finished
    
    //Keep track of the year of tournament
    int tourYear;

    
    public Tournament(int choice, Player[] m, Player[] w, Referee[] r, int year) {
        males = m;
        females = w;
        refs = r;
        tourYear = year;
        
        switch(choice) {
            case 1:
                name = "Australian Open";
                place = "Melbourne";
                surface = "Plexicushion";
                break;
            case 2:
                name = "Roland Garros";
                place = "Paris";
                surface = "Clay";
                break;
            case 3:
                name = "Wimbledon";
                place = "London";
                surface = "Grass";
                break;
            case 4:
                name = "US Open";
                place = "New York";
                surface = "Decoturf";
                break;
        }
    }
    
    //=========================================================================
    //PLAYING THE TOURNAMENT
    //=========================================================================
    
    public void playTournament() {
        switch(tournamentProgress) {
            case 0:
                play128();
                break;
            case 1:
                playRound(data.getMale128Winners(), data.getFemale128Winners());
                break;
            case 2:
                playRound(data.getMale64Winners(), data.getFemale64Winners());
                break;
            case 3:
                playRound(data.getMale32Winners(), data.getFemale32Winners());
                break;
            case 4:
                playRound(data.getMale16Winners(), data.getFemale16Winners());
                break;
            case 5:
                playRound(data.getMaleQuartersWinners(), 
                        data.getFemaleQuartersWinners());
                break;
            case 6:
                playRound(data.getMaleSemisWinners(), 
                        data.getFemaleSemisWinners());
                System.out.println("THE TOURNAMENT HAS CONCLUDED");
                break;
            case 7:
                System.out.println("The tournament has concluded already.");
                break;
        }
    }
    
    //MALES
    public void play128() {
        //males
        Player[] matches = males;
        Player[] halfOne = new Player[64];
        Player[] halfTwo = new Player[64];
        Match[] results = new Match[64];
        
        for (int i = 0; i < 64; i++) {
            halfOne[i] = matches[i];
            halfTwo[i] = matches[64+i];
        }
        
        for (int i = 0; i < 64; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player p1 = halfOne[i];
            Player p2 = halfTwo[i];
            Match result = new Match(p1, p2, refs[r]);
            result.getWinner().addWin();
            result.getLoser().addLoss();
            results[i] = result;
        }
        
        //females
        Player[] wmatches = females;
        Player[] whalfOne = new Player[64];
        Player[] whalfTwo = new Player[64];
        Match[] wresults = new Match[64];

        for (int i = 0; i < 64; i++) {
            whalfOne[i] = wmatches[i];
            whalfTwo[i] = wmatches[64 + i];
        }

        for (int i = 0; i < 64; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player p1 = whalfOne[i];
            Player p2 = whalfTwo[i];
            Match result = new Match(p1, p2, refs[r]);
            result.getWinner().addWin();
            result.getLoser().addLoss();
            wresults[i] = result;
        }
        
        data.setWinners(results, wresults, tournamentProgress);
        tournamentProgress++;
    }
    
    public void playRound(Match[] winners, Match[] woWinners) {
        //males
        int resLength = winners.length/2;
        Match[] results = new Match[resLength];
        
        Player[] halfOne = new Player[64];
        Player[] halfTwo = new Player[64];
        for (int i = 0; i < resLength; i++) {
            halfOne[i] = winners[i].getWinner();
            halfTwo[i] = winners[resLength+i].getWinner();
        }
        
        for (int i = 0; i < resLength; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player p1 = halfOne[i];
            Player p2 = halfTwo[i];
            Match result = new Match(p1, p2, refs[r]);
            result.getWinner().addWin();
            result.getLoser().addLoss();
            results[i] = result;
        }
        
        //females
        Match[] wresults = new Match[resLength];

        Player[] whalfOne = new Player[64];
        Player[] whalfTwo = new Player[64];
        for (int i = 0; i < resLength; i++) {
            whalfOne[i] = woWinners[i].getWinner();
            whalfTwo[i] = woWinners[resLength + i].getWinner();
        }

        for (int i = 0; i < resLength; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player p1 = whalfOne[i];
            Player p2 = whalfTwo[i];
            Match result = new Match(p1, p2, refs[r]);
            result.getWinner().addWin();
            result.getLoser().addLoss();
            wresults[i] = result;
        }
        
        data.setWinners(results, wresults, tournamentProgress);
        tournamentProgress++;
    }
    
    //Getters
    public int getYear() {
        return tourYear;
    }
    
    //=========================================================================
    //VIEWING RESULTS
    //=========================================================================
    public void viewResults() {
        resultsMenu();
        switch (tournamentProgress) {
            case 0:
                break;
            case 1:
                System.out.print("\nEnter Your Choice: ");
                String choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 2:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(), 
                                data.getFemale64Winners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 3:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(),
                                data.getFemale64Winners());
                        break;
                    case "3":
                        viewRound(data.getMale32Winners(),
                                data.getFemale32Winners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 4:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(), 
                                data.getFemale64Winners());
                        break;
                    case "3":
                        viewRound(data.getMale32Winners(),
                                data.getFemale32Winners());
                        break;
                    case "4":
                        viewRound(data.getMale16Winners(),
                                data.getFemale16Winners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 5:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(), 
                                data.getFemale64Winners());
                        break;
                    case "3":
                        viewRound(data.getMale32Winners(),
                                data.getFemale32Winners());
                        break;
                    case "4":
                        viewRound(data.getMale16Winners(),
                                data.getFemale16Winners());
                        break;
                    case "5":
                        viewRound(data.getMaleQuartersWinners(), 
                                data.getFemaleQuartersWinners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 6:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(), 
                                data.getFemale64Winners());
                        break;
                    case "3":
                        viewRound(data.getMale32Winners(),
                                data.getFemale32Winners());
                        break;
                    case "4":
                        viewRound(data.getMale16Winners(),
                                data.getFemale16Winners());
                        break;
                    case "5":
                        viewRound(data.getMaleQuartersWinners(),
                                data.getFemaleQuartersWinners());
                        break;
                    case "6":
                        viewRound(data.getMaleSemisWinners(),
                                data.getFemaleSemisWinners());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
            case 7:
                System.out.print("\nEnter Your Choice: ");
                choice = input.next();
                switch (choice) {
                    case "1":
                        viewRound(data.getMale128Winners(),
                                data.getFemale128Winners());
                        break;
                    case "2":
                        viewRound(data.getMale64Winners(),
                                data.getFemale64Winners());
                        break;
                    case "3":
                        viewRound(data.getMale32Winners(),
                                data.getFemale32Winners());
                        break;
                    case "4":
                        viewRound(data.getMale16Winners(),
                                data.getFemale16Winners());
                        break;
                    case "5":
                        viewRound(data.getMaleQuartersWinners(), 
                                data.getFemaleQuartersWinners());
                        break;
                    case "6":
                        viewRound(data.getMaleSemisWinners(),
                                data.getFemaleSemisWinners());
                        break;
                    case "7":
                        viewRound(data.getMaleWinner(),
                                data.getFemaleWinner());
                        break;
                    case "00":
                        return;
                    default:
                        System.out.println("This is not a valid Menu Option!");
                        break;
                }
        }
    }
    
    private void resultsMenu() {
        System.out.println("");
        switch(tournamentProgress) {
            case 0:
                System.out.println("VIEW RESULTS");
                System.out.println("No round has been played yet.");
                break;
            case 1:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("00 - Exit");
                break;
            case 2:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("00 - Exit");
                break;
            case 3:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("3 - Round of 32");
                System.out.println("00 - Exit");
                break;
            case 4:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("3 - Round of 32");
                System.out.println("4 - Round of 16");
                System.out.println("00 - Exit");
                break;
            case 5:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("3 - Round of 32");
                System.out.println("4 - Round of 16");
                System.out.println("5 - Quarters");
                System.out.println("00 - Exit");
                break;
            case 6:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("3 - Round of 32");
                System.out.println("4 - Round of 16");
                System.out.println("5 - Quarters");
                System.out.println("6 - Semis");
                System.out.println("00 - Exit");
                break;
            case 7:
                System.out.println("VIEW RESULTS");
                System.out.println("1 - Round of 128");
                System.out.println("2 - Round of 64");
                System.out.println("3 - Round of 32");
                System.out.println("4 - Round of 16");
                System.out.println("5 - Quarters");
                System.out.println("6 - Semis");
                System.out.println("7 - Finals");
                System.out.println("00 - Exit");
                break;
        }
    }
        
    private void viewRound(Match[] matches, Match[] wmatches) {
        System.out.println("VIEW RESULTS");
        System.out.println("1 - Males");
        System.out.println("2 - Females");
        System.out.println("00 - Exit");
        System.out.print("\nEnter Your Choice: ");
        String choice = input.next();
        
        switch (choice) {
            case "1":
                for (int i = 0; i < matches.length; i++) {
                    System.out.printf("\nMatch %s - %s %s def. %s %s", i + 1,
                            matches[i].getWinner().firstName, matches[i].getWinner().blastName,
                            matches[i].getLoser().firstName, matches[i].getLoser().blastName);
                }
                System.out.println("\nInput match number to view summary");
                System.out.println("Input '00' to return");
                int matchChoice = input.nextInt();
                if (matchChoice == 00) {
                    viewResults();
                } else {
                    matchSum(matchChoice, matches);
                }
                break;
            case "2":
                for (int i = 0; i < wmatches.length; i++) {
                    System.out.printf("\nMatch %s - %s %s def. %s %s", i + 1,
                            wmatches[i].getWinner().firstName, wmatches[i].getWinner().blastName,
                            wmatches[i].getLoser().firstName, wmatches[i].getLoser().blastName);
                }
                System.out.println("\nInput match number to view summary");
                System.out.println("Input '00' to return");
                matchChoice = input.nextInt();
                if (matchChoice == 00) {
                    viewResults();
                } else {
                    matchSum(matchChoice, wmatches);
                }
                break;
            case "00":
                return;
            default:
                System.out.println("This is not a valid Menu Option!");
                break;
        }
    }
    
    private void matchSum(int i, Match[] matches) {
        System.out.println(matches[i-1].getSummary());
        viewResults();
    }
    
    public String getStatus() {
        String prog = "";
        
        switch(tournamentProgress) {
            case 0:
                prog = "Round of 128";
                break;
            case 1:
                prog = "Round of 64";
                break;
            case 2:
                prog = "Round of 32";
                break;
            case 3:
                prog = "Round of 16";
                break;
            case 4:
                prog = "Quarter Finals";
                break;
            case 5:
                prog = "Semi Finals";
                break;
            case 6:
                prog = "Finals";
                break;
            case 7:
                prog = "FINISHED";
                break;
        }
        
        return prog;
    }
    
    public int getProg() {
        return tournamentProgress;
    }
}