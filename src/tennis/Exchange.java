/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * This class plays out an exchange between two players.
 * It also includes several getters and setters such as getting and
 * setting the winner and loser of the exchange.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Exchange {
    /**
     * the server of the exchange
     */
    Player ser;
    /**
     * the receiver of the exchange
     */
    Player rec;
    /**
     * the referee of the exchange
     */
    Referee ref;
    /**
     * produces random properites
     */
    Random r = new Random();
    /**
     * the summary of the exchange
     */
    String summary;
    /**
     * the winner of the exchange
     */
    Player winner;
    /**
     * the loser of the exchange
     */
    Player loser;
    /**
     * counts if there has already
     * been a fault
     */
    int faultCount;
    /**
     * the match data
     */
    MData data;
    
    /**
     * Class Constructor.
     * @param x The first player in the exchange.
     * @param y The second player in the exchange.
     * @param r The referee in the exchange.
     * @param d The match data.
     * @param i The number of times a player has committed a fault.
     */
    public Exchange(Player x, Player y, Referee r, MData d, int i) {
        ser = x;
        rec = y;
        ref = r;
        faultCount = i;
        data = d;
        service();
    }
    
    /**
     * This method plays out the exchange between the two players.
     */
    public void service() {
        double chance = r.nextDouble(); //generates a random double
        double bonus = getBonus();
        double faultChance = getFaultChance();
        double favChance = 0.5 + bonus;
        
        if (faultCount == 0) {
            int speed = ThreadLocalRandom.current().nextInt(160, 180);
            ser.addFirstService(speed);
            data.addFirstServe(speed);
        }
        
        else {
            int speed = ThreadLocalRandom.current().nextInt(140, 165);
            ser.addSecondService(speed);
            data.addSecondServe(speed);
        }
        
        //Chance of fault
        if (chance <= faultChance) {
            if (faultCount == 0) {
                setSummary("FAULT");
                faultCount++;
                service();
            } else {
                String result = "DOUBLE FAULT! " + rec.firstName + " "
                        + rec.blastName + " has won the exchange";
                setSummary(result);
                setWinner(rec);
                data.addDoubleFaults();
            }
        }
        
        else if (faultChance <= chance && chance <= favChance+faultChance) {
            String result = ser.firstName + " " + ser.blastName
                    + " has won the exchange";
            setSummary(result);
            setWinner(ser);
            
            //So that not every point won by the server is an ace (rarer)
            int r = ThreadLocalRandom.current().nextInt(0, 10);
            if (r > 8) {
                data.addAces();
            }
        }
        
        else {
            String result = rec.firstName + " " + rec.blastName
                    + " has won the exchange";
            setSummary(result);
            setWinner(rec);
        }
        
    }
    
    /**
     * This method calculates and returns the bonus points that the higher
     * ranked player will receive towards their chances of winning.
     * 
     * @return double of the bonus percentage points that a higher
     * ranked Player will receive.
     */
    private double getBonus() {
        int rd = ser.getRank() - rec.getRank();
        int rankDiff = Math.abs(rd);
        double fbon = 0;

        //get the favorite's bonus
        if (0 < rankDiff && rankDiff <= 8) {
            fbon = 0;
        } else if (8 < rankDiff && rankDiff <= 16) {
            fbon = 0.02;
        } else if (16 < rankDiff && rankDiff <= 32) {
            fbon = 0.04;
        } else if (32 < rankDiff && rankDiff <= 48) {
            fbon = 0.06;
        } else if (48 < rankDiff && rankDiff <= 64) {
            fbon = 0.08;
        } else if (64 < rankDiff && rankDiff <= 80) {
            fbon = 0.10;
        } else if (80 < rankDiff && rankDiff <= 96) {
            fbon = 0.12;
        } else if (96 < rankDiff && rankDiff <= 112) {
            fbon = 0.14;
        } else if (112 < rankDiff && rankDiff <= 128) {
            fbon = 0.16;
        }

        return fbon;
    }
    
    /**
     * This method calculates and returns the probability of a player
     * committing a fault. It again depends on the rank of a player.
     * @return double of the fault probability of a Player.
     */
    private double getFaultChance() {
        int rank = ser.getRank();
        double fchance = 0;

        //get the favorite's bonus
        if (0 < rank && rank <= 8) {
            fchance = 0.05;
        } else if (8 < rank && rank <= 16) {
            fchance = 0.1;
        } else if (16 < rank && rank <= 32) {
            fchance = 0.15;
        } else if (32 < rank && rank <= 48) {
            fchance = 0.20;
        } else if (48 < rank && rank <= 64) {
            fchance = 0.25;
        } else if (64 < rank && rank <= 80) {
            fchance = 0.3;
        } else if (80 < rank && rank <= 96) {
            fchance = 0.35;
        } else if (96 < rank && rank <= 112) {
            fchance = 0.4;
        } else if (112 < rank && rank <= 128) {
            fchance = 0.45;
        }

        return fchance;
    }
    
    /**
     * This method displays the outcome of the exchange.
     * @param winner The winning Player of the exchange.
     * @return String of the outcome of the exchange.
     */
    public String getSummary(Player winner) {        
        return summary;
    }
    
    /**
     * This method sets which Player won the exchange.
     * @param win The winning Player of the exchange.
     */
    private void setWinner(Player win) {
        winner = win;
    }

    /**
     * This methods sets which Player lost the exchange.
     * @param lose The losing Player of the exchange.
     */
    private void setLoser(Player lose) {
        loser = lose;
    }

    /**
     * This method saves a String that will display which
     * Player won the exchange
     * @param line The String that displays which player won.
     */
    private void setSummary(String line) {
        summary = line;
    }

    /**
     * This method gets the winner of the exchange and
     * returns it.
     * @return Player who won the exchange.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * This method gets the loser of the exchange and
     * returns it.
     * @return Player who lost the exchange.
     */
    public Player getLoser() {
        return loser;
    }
}
