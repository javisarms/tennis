/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;

/**
 *
 * @author javiersarmiento
 */
public class TData {
    Match[] finals = new Match[1];
    //Referee[] hunnaRefs; //results for round of 128 mens
    Match[] hunna = new Match[64];
    Match[] sixts; //64
    Match[] thirt; //32
    Match[] sixteen; //16
    Match[] quart; //quarters
    Match[] semi; //semis
    
    public void setWinners(Match[] results, int tp){
        switch(tp) {
            case 0:
                hunna = results;
                break;
            case 1:
                sixts = results;
                break;
            case 2:
                thirt = results;
                break;
            case 3:
                sixteen = results;
                break;
            case 4:
                quart = results;
                break;
            case 5:
                semi = results;
                break;
            case 6:
                finals[0] = results[0];
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
    
}
