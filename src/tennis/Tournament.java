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
    Player[] players; //Generate random players and then arrange them by rank
    Referee[] refs; //Generate random refs
    Referee[] hunnaRefs = new Referee[64]; //results for round of 128
    Referee[] sixtsRefs = new Referee[32]; //64
    Referee[] thirtRefs = new Referee[16]; //32
    Referee[] sixteenRefs = new Referee[8]; //16
    Referee[] quartRefs = new Referee[4]; //quarters
    Referee[] semiRefs = new Referee[2]; //semis


    
    public Tournament(String n) {
        name = n;
    }
    
    public void playTournament() {
        //Sort array of players by rank
        
        //Round of 128
        for (int i = 0; i < 64; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Match mat = new Match(players[i], players[players.length-i], refs[r]);
            
            //Add to array of referees sixstsRefs which acts as the data
            //storage of the matches played
            hunnaRefs[i] = mat.playMatch();
        }
        
        //Round of 64
        for (int i = 0; i < 32; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = hunnaRefs[i].getWinner();
            Player win2 = hunnaRefs[sixtsRefs.length-i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            sixtsRefs[i] = mat.playMatch();
        }
        
        //Round of 32        
        for (int i = 0; i < 16; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = sixtsRefs[i].getWinner();
            Player win2 = sixtsRefs[sixtsRefs.length-i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            thirtRefs[i] = mat.playMatch();
        }
        
        //Round of 16
        for (int i = 0; i < 8; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = thirtRefs[i].getWinner();
            Player win2 = thirtRefs[thirtRefs.length - i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            sixteenRefs[i] = mat.playMatch();
        }
        
        //Quarters
        for (int i = 0; i < 4; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = sixteenRefs[i].getWinner();
            Player win2 = sixteenRefs[sixteenRefs.length - i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            quartRefs[i] = mat.playMatch();
        }
        
        //Semis
        for (int i = 0; i < 2; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 12 + 1); // this
            // generates a random number from 0-12 to pick a referee
            Player win1 = quartRefs[i].getWinner();
            Player win2 = quartRefs[quartRefs.length - i].getWinner();
            Match mat = new Match(win1, win2, refs[r]);
            quartRefs[i] = mat.playMatch();
        }
        
        //Finals
        int r = ThreadLocalRandom.current().nextInt(0, 12 + 1);
        Referee fin = refs[r];
        Player win1 = semiRefs[0].getWinner();
        Player win2 = semiRefs[1].getWinner();
        Match mat = new Match(win1, win2, fin);
        fin = mat.playMatch();
    }
    
}
