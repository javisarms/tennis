/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author javiersarmiento
 */
public class Exchange {
    Player ser;
    Player rec;
    Referee ref;
    Random r = new Random();
    String summary;
    Player winner;
    Player loser;
    int faultCount;
    
    public Exchange(Player x, Player y, Referee r, int i) {
        ser = x;
        rec = y;
        ref = r;
        faultCount = i;
        service();
    }
    
    public void service() {
        double chance = r.nextDouble(); //generates a random double
        double bonus = getBonus();
        double faultChance = getFaultChance();
        double favChance = 0.5 + bonus;
        
        if (faultCount == 0) {
            int speed = ThreadLocalRandom.current().nextInt(160, 180);
            ser.addFirstService(speed);
        }
        
        else {
            int speed = ThreadLocalRandom.current().nextInt(140, 165);
            ser.addSecondService(speed);
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
            }
        }
        
        else if (faultChance <= chance && chance <= favChance+faultChance) {
            String result = ser.firstName + " " + ser.blastName
                    + " has won the exchange";
            setSummary(result);
            setWinner(ser);
        }
        
        else {
            String result = rec.firstName + " " + rec.blastName
                    + " has won the exchange";
            setSummary(result);
            setWinner(rec);
        }
        
    }
    
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
    
    //Displays the outcome of the exchange
    public String getSummary(Player winner) {        
        return summary;
    }
    
    private void setWinner(Player win) {
        winner = win;
    }

    private void setLoser(Player lose) {
        loser = lose;
    }

    private void setSummary(String line) {
        summary = line;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public String getSummary() {
        return summary;
    }
}
