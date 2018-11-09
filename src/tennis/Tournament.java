/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author javiersarmiento
 */
public class Tournament {
    String name;
    String surface;
    Player[] males;
    Player[] females;
    Referee[] refs;
    
    Referee maleWinner;
    Referee[] hunnaRefs; //results for round of 128 mens
    Referee[] sixtsRefs; //64
    Referee[] thirtRefs; //32
    Referee[] sixteenRefs; //16
    Referee[] quartRefs; //quarters
    Referee[] semiRefs; //semis
   
    Referee femaleWinner;
    Referee[] whunnaRefs; //results for round of 128 womens
    Referee[] wsixtsRefs; //64
    Referee[] wthirtRefs; //32
    Referee[] wsixteenRefs; //16
    Referee[] wquartRefs; //quarters
    Referee[] wsemiRefs; //semis
    
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
                break;
            case 2:
                name = "French Open";
                break;
            case 3:
                name = "Wimbledon";
                break;
            case 4:
                name = "US Open";
                break;
        }
    }
    
    //MALES
    public Referee[] play128()
    {
        Referee[] results = new Referee[64];
        //Round of 128
        for (int i = 0; i < 64; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player p1 = males[i];
            Player p2 = males[males.length-1-i];
            Match mat = new Match(p1, p2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        //set the hunnaRefs here
        //setMale128Winners(results);
        
        return results;
    }
    
    public void play64()
    {
        Referee[] results = new Referee[32];
        //Round of 64
        for (int i = 0; i < 32; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = hunnaRefs[i].getWinner();
            Player win2 = hunnaRefs[hunnaRefs.length-1-i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        setMale64Winners(results);
    }
    
    public void play32()
    {
        Referee[] results = new Referee[16];
        //Round of 32        
        for (int i = 0; i < 16; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = sixtsRefs[i].getWinner();
            Player win2 = sixtsRefs[sixtsRefs.length-1-i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        setMale32Winners(results);
    }
    
    public void play16()
    {
        Referee[] results = new Referee[8];
        //Round of 16
        for (int i = 0; i < 8; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = thirtRefs[i].getWinner();
            Player win2 = thirtRefs[thirtRefs.length-1-i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        setMale16Winners(results);
    }
    
    public void playQuarters()
    {
        Referee[] results = new Referee[4];
        //Quarters
        for (int i = 0; i < 4; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = sixteenRefs[i].getWinner();
            Player win2 = sixteenRefs[sixteenRefs.length -1 - i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        setMale8Winners(results);

    }
    
    public void playSemis()
    {
        Referee[] results = new Referee[2];
        //Semis
        for (int i = 0; i < 2; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = quartRefs[i].getWinner();
            Player win2 = quartRefs[quartRefs.length-1 - i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            results[i] = mat.playMatch();
        }
        tournamentProgress++;
        setMale4Winners(results);
    }
    
    public void playFinals()
    {
        //Finals
        int r = ThreadLocalRandom.current().nextInt(0, 12);
        Referee fin = refs[r];
        Player win1 = semiRefs[0].getWinner();
        Player win2 = semiRefs[1].getWinner();
        Match mat = new Match(win1, win2, fin);
        fin = mat.playMatch();
        tournamentProgress++;
        setMaleWinner(fin);
    }
    
    //Sets the winners
    public void setMale128Winners(Referee[] results) {
        hunnaRefs = results;
    }
    
    public void setMale64Winners(Referee[] results) {
        sixtsRefs = results;
    }
    
    public void setMale32Winners(Referee[] results) {
        thirtRefs = results;
    }
    
    public void setMale16Winners(Referee[] results) {
        sixteenRefs = results;
    }
    
    public void setMale8Winners(Referee[] results) {
        quartRefs = results;
    }
    
    public void setMale4Winners(Referee[] results) {
        semiRefs = results;
    }
    
    public void setMaleWinner(Referee result) {
        maleWinner = result;
    }
    
    //Get Winners
    public Referee[] getMale128Winners() {
        return hunnaRefs;
    }

    public Referee[] getMale64Winners() {
        return sixtsRefs;
    }

    public Referee[] getMale32Winners() {
        return thirtRefs;
    }

    public Referee[] getMale16Winners() {
        return sixteenRefs;
    }

    public Referee[] getMale8Winners() {
        return quartRefs;
    }

    public Referee[] getMale4Winners() {
        return semiRefs;
    }

    public Referee getMaleWinner() {
        return maleWinner;
    }
    
    //Getters
    public int getYear() {
        return tourYear;
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
