///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tennis;
//
///**
// *
// * @author javiersarmiento
// */
//public class Match {
//    Player p1;
//    Player p2;
//    Referee ref;
//    int p1Score = 0;
//    int p2Score = 0;
//    int setCounter = 0;
//    Set set;
//    
//    public Match(Player x, Player y, Referee r)
//    {
//        p1 = x;
//        p2 = y;
//        ref = r; 
//    }
//    
//    public Player playMatch() {
//        
//        Player winner = null;
//        if (p1Score <= 2 && p2Score <= 2) {
//            set();
//        }
//        
//        if (p1Score > 2) {
//            winner = p1;
//        }
//        
//        else if (p2Score > 2) {
//            winner = p2;
//        }
//        
//        return winner;
//    }
//    
//    private void set() {
//        System.out.println("SET START ⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
//                + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟");
//        System.out.println();
//        if (p1Score <= 2 && p2Score <= 2) {
//            set = new Set(p1, p2, ref);
//            Player x = set.playSet(); //returns the winner of the set
//            
//            //If p1 won
//            if (x == p1) {
//                p1Score++;
//                System.out.printf("%s | %s %s: %s sets ૾ %s %s: %s sets", 
//                        set.getResult(x), p1.nickName, p1.blastName, 
//                        p1Score, p2.nickName, p2.blastName, 
//                        p2Score);
//                System.out.println();
//                System.out.println("⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
//                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END");
//                System.out.println();
//                playMatch();
//            } 
//            
//            //If p2 won
//            else if (x == p2) {
//                p2Score++;
//                System.out.printf("%s | %s %s: %s sets ૾ %s %s: %s sets", 
//                        set.getResult(x), p1.nickName, p1.blastName, 
//                        p1Score, p2.nickName, p2.blastName, 
//                        p2Score);
//                System.out.println();
//                System.out.println("⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟"
//                        + "⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟⍟ SET END");
//                System.out.println();
//                playMatch();
//            }
//        }
//    }
//}
