/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 *
 * @author javiersarmiento
 */
public class MData {
    int totalFirstServes;
    int totalSecondServes;
    int totalDoubleFaults;
    int totalAces;
    int totalGames;
    int totalSets;
    int totalPoints;
    int totalFirstServeSpeed;
    int totalSecondServeSpeed;
    int avgFirstServeSpeed;
    int avgSecondServeSpeed;
    
    public void addFirstServe(int s) {
        totalFirstServes++;
        totalFirstServeSpeed += s;
    }
    
    public void addSecondServe(int s) {
        totalSecondServes++;
        totalSecondServeSpeed += s;
    }
    
    public void addDoubleFaults() {
        totalDoubleFaults++;
    }
    
    public void addTotalPoints() {
        totalPoints++;
    }
    
    public void addAces() {
        totalAces++;
    }
    
    public void addSets() {
        totalSets++;
    }
    
    public void addGames() {
        totalGames++;
    }
    
    public int getAvgFirst() {
        return totalFirstServeSpeed/totalFirstServes;
    }
    
    public int getAvgSecond() {
        return totalSecondServeSpeed / totalSecondServes;
    }
}
