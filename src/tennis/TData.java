/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class stores the data of a tournament. The 
 * rounds' winners are stored, as well as other tournament
 * statistics such as total matches, balls, hats, bottles, etc.
 * This also allows for a cleaner code as the tournament class
 * already has plenty of lines.
 * @author javiersarmiento
 */
public class TData {
    Match[] finals = new Match[1];
    Match[] hunna = new Match[64];
    Match[] sixts; //64
    Match[] thirt; //32
    Match[] sixteen; //16
    Match[] quart; //quarters
    Match[] semi; //semis
    
    //Womens'
    Match[] wfinals = new Match[1];
    Match[] whunna = new Match[64];
    Match[] wsixts; //64
    Match[] wthirt; //32
    Match[] wsixteen; //16
    Match[] wquart; //quarters
    Match[] wsemi; //semis
    
    //Statistics
    int totalSpec;
    int totalMatches;
    int totalBalls = ThreadLocalRandom.current().nextInt(68000, 72000);
    int totalHats = ThreadLocalRandom.current().nextInt(20000, 45000);
    int totalBottles = ThreadLocalRandom.current().nextInt(100000, 200000);
    
    /**
     * Sets the winners of a round of the tournament based on the 
     * tournament progress.
     * @param results the results of the mens' matches
     * @param wresults the results of the womens' matches
     * @param tp the tournament progress
     */
    public void setWinners(Match[] results, Match[] wresults, int tp){
        switch(tp) {
            case 0:
                hunna = results;
                whunna = wresults;
                break;
            case 1:
                sixts = results;
                wsixts = wresults;
                break;
            case 2:
                thirt = results;
                wthirt = wresults;
                break;
            case 3:
                sixteen = results;
                wsixteen = wresults;
                break;
            case 4:
                quart = results;
                wquart = wresults;
                break;
            case 5:
                semi = results;
                wsemi = wresults;
                break;
            case 6:
                finals[0] = results[0];
                wfinals[0] = wresults[0];
                break;
        }
    }
    
    /**
     * Getter for the results of the Mens' Round of 128
     * @return Match[] array of results
     */
    public Match[] getMale128Winners() {
        return hunna;
    }
    
    /**
     * Getter for the results of the Mens' Round of 64
     * @return Match[] array of results
     */
    public Match[] getMale64Winners() {
        return sixts;
    }
    
    /**
     * Getter for the results of the Mens' Round of 32
     * @return Match[] array of results
     */
    public Match[] getMale32Winners() {
        return thirt;
    }
    
    /**
     * Getter for the results of the Mens' Round of 16
     * @return Match[] array of results
     */
    public Match[] getMale16Winners() {
        return sixteen;
    }
    
    /**
     * Getter for the results of the Mens' Quarters
     * @return Match[] array of results
     */
    public Match[] getMaleQuartersWinners() {
        return quart;
    }
    
    /**
     * Getter for the results of the Mens' Semis
     * @return Match[] array of results
     */
    public Match[] getMaleSemisWinners() {
        return semi;
    }
    
    /**
     * Getter for the results of the Mens' Finals
     * @return Match[] array of results
     */
    public Match[] getMaleWinner() {
        return finals;
    }
    
    /**
     * Getter for the results of the Womens' Round of 128
     * @return Match[] array of results
     */
    public Match[] getFemale128Winners() {
        return whunna;
    }

    /**
     * Getter for the results of the Womens' Round of 64
     * @return Match[] array of results
     */
    public Match[] getFemale64Winners() {
        return wsixts;
    }

    /**
     * Getter for the results of the Womens' Round of 32
     * @return Match[] array of results
     */
    public Match[] getFemale32Winners() {
        return wthirt;
    }

    /**
     * Getter for the results of the Womens' Round of 16
     * @return Match[] array of results
     */
    public Match[] getFemale16Winners() {
        return wsixteen;
    }

    /**
     * Getter for the results of the Womens' Quarters
     * @return Match[] array of results
     */
    public Match[] getFemaleQuartersWinners() {
        return wquart;
    }

    /**
     * Getter for the results of the Womens' Semis
     * @return Match[] array of results
     */
    public Match[] getFemaleSemisWinners() {
        return wsemi;
    }

    /**
     * Getter for the results of the Womens' Finals
     * @return Match[] array of results
     */
    public Match[] getFemaleWinner() {
        return wfinals;
    }
    
    //Statistic Related Methods
    
    /**
     * Getter for the average spectators of the tournament
     * @return int of the average spectators
     */
    public int getAvgSpec() {
        return totalSpec/totalMatches;
    }
    
    /**
     * Getter for the total hats sold
     * @return int of hats sold
     */
    public int getHats() {
        return totalHats;
    }
    
    /**
     * Getter for the total balls used
     * @return int of balls used
     */
    public int getBalls() {
        return totalBalls;
    }
    
    /**
     * Getter for the total drinks sold
     * @return int of drinks sold
     */
    public int getBottles() {
        return totalBottles;
    }
    
    /**
     * Adds to the total spectators who watched in the tournament
     * @param s total number of spectators for a match
     */
    public void addSpec(int s) {
        totalSpec += s;
    }
    
    /**
     * Adds to the total matches played in the tournament by one
     */
    public void addMatch() {
        totalMatches ++;
    }
    
}
