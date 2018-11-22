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
    
    public Match[] getMale128Winners() {
        return hunna;
    }
    
    public Match[] getMale64Winners() {
        return sixts;
    }
    
    public Match[] getMale32Winners() {
        return thirt;
    }
    
    public Match[] getMale16Winners() {
        return sixteen;
    }
    
    public Match[] getMaleQuartersWinners() {
        return quart;
    }
    
    public Match[] getMaleSemisWinners() {
        return semi;
    }
    
    public Match[] getMaleWinner() {
        return finals;
    }
    
    public Match[] getFemale128Winners() {
        return whunna;
    }

    public Match[] getFemale64Winners() {
        return wsixts;
    }

    public Match[] getFemale32Winners() {
        return wthirt;
    }

    public Match[] getFemale16Winners() {
        return wsixteen;
    }

    public Match[] getFemaleQuartersWinners() {
        return wquart;
    }

    public Match[] getFemaleSemisWinners() {
        return wsemi;
    }

    public Match[] getFemaleWinner() {
        return wfinals;
    }
    
    //Statistic Related Methods
    
    public int getAvgSpec() {
        return totalSpec/totalMatches;
    }
    
    public int getHats() {
        return totalHats;
    }
    
    public int getBalls() {
        return totalBalls;
    }
    
    public int getBottles() {
        return totalBottles;
    }
    
    public void addSpec(int s) {
        totalSpec += s;
    }
    
    public void addMatch() {
        totalMatches ++;
    }
    
}
