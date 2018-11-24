/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * This class handles the various statistics of each match such as
 * serve speed, total serves, total points, total games, etc.
 * This also allows for a cleaner code as the match class
 * already has plenty of lines.
 * @author Javier Sarmiento and Rafael Racela
 */
public class MData {
    /**
     * the total first serves
     */
    int totalFirstServes;
    /**
     * the total second serves
     */
    int totalSecondServes;
    /**
     * the total double faults
     */
    int totalDoubleFaults;
    /**
     * the total aces
     */
    int totalAces;
    /**
     * the total games
     */
    int totalGames;
    /**
     * the total sets
     */
    int totalSets;
    /**
     * the total points
     */
    int totalPoints;
    /**
     * the total first serve speeds
     */
    int totalFirstServeSpeed;
    /**
     * the total second serves speeds
     */
    int totalSecondServeSpeed;
    /**
     * the average first serve speed
     */
    int avgFirstServeSpeed;
    /**
     * the average second serve speed
     */
    int avgSecondServeSpeed;
    
    /**
     * This method adds to amount of first serves 
     * in a particular match.
     * @param s The speed of the serve.
     */
    public void addFirstServe(int s) {
        totalFirstServes++;
        totalFirstServeSpeed += s;
    }
    
    /**
     * This method adds to amount of second serves 
     * in a particular match.
     * @param s The speed of the serve.
     */
    public void addSecondServe(int s) {
        totalSecondServes++;
        totalSecondServeSpeed += s;
    }
    
    /**
     * This method adds to the amount of double faults
     * in a particular match.
     */
    public void addDoubleFaults() {
        totalDoubleFaults++;
    }
    
    /**
     * This method adds to the amount of points 
     * in a particular match.
     */
    public void addTotalPoints() {
        totalPoints++;
    }
    
    /**
     * This method adds to the amount of aces
     * in a particular match.
     */
    public void addAces() {
        totalAces++;
    }
    
    /**
     * This method adds to the amount of sets played
     * in a particular match.
     */
    public void addSets() {
        totalSets++;
    }
    
    /**
     * This method adds to the amount of games played
     * in a particular match.
     */
    public void addGames() {
        totalGames++;
    }
    
    /**
     * This method gets the average speed of all the first
     * serves in a particular match.
     * @return int the average first serve speed
     */
    public int getAvgFirst() {
        int avg = 0;
        
        if (totalFirstServes == 0) {
            
        }
        
        else {
            avg = totalFirstServeSpeed / totalFirstServes;
        }
        return avg;
    }
    
    /**
     * This method gets the average speed of all the second
     * serves in a particular match.
     * @return int the average second serve speed
     */
    public int getAvgSecond() {
        int avg = 0;

        if (totalSecondServes == 0) {

        } 
        
        else {
            avg = totalSecondServeSpeed / totalSecondServes;
        }
        return avg;
    }
}
