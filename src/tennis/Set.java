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
//public class Set {
//    Player p1, p2;
//    int p1Score = 0;
//    int p2Score = 0;
//    int gameCounter = 0;
//    Referee ref;
//    Game game;
//    
//    public Set(Player x, Player y, Referee r)
//    {
//        p1 = x;
//        p2 = y;
//        ref = r; 
//    }
//    
//    public Player playSet()
//    {
//        Player winner = null;
//        
//        playGame();
//        
//        if (p1Score > 5) {
//            winner = p1;
//        }
//        
//        else if (p2Score > 5) {
//            winner = p2;
//        }
//                
//        return winner;
//    }
//    
//    private void playGame() {
//        game = new Game(p1, p2, ref);
//        if (p1Score <= 5 && p2Score <= 5) {
//
//            if (gameCounter % 2 == 0) {
//                game.setServer(p1);
//                game.setReceiver(p2);
//                gameCounter++;
//                Player x = game.playGame(); //returns the winner of the game
//                if (x == p1) {
//                    p1Score++;
//                    System.out.printf("%s | %s %s: %s games ● %s %s: %s games",
//                            game.getResult(x), p1.nickName, p1.blastName,
//                            p1Score, p2.nickName, p2.blastName,
//                            p2Score);
//                    System.out.println("\n");
//                    System.out.println("====================================="
//                            + "======================================GAME END");
//                    System.out.println();
//                    playSet();
//                } else if (x == p2) {
//                    p2Score++;
//                    System.out.printf("%s | %s %s: %s games ● %s %s: %s games",
//                            game.getResult(x), p1.nickName, p1.blastName,
//                            p1Score, p2.nickName, p2.blastName,
//                            p2Score);
//                    System.out.println("\n");
//                    System.out.println("====================================="
//                            + "======================================GAME END");
//                    System.out.println();
//                    playSet();
//                }
//            } else {
//                game.setServer(p2);
//                game.setReceiver(p1);
//                gameCounter++;
//                Player x = game.playGame(); //returns the winner of the game
//
//                if (x == p1) {
//                    p1Score++;
//                    System.out.printf("%s | %s %s: %s games ● %s %s: %s games",
//                            game.getResult(x), p1.nickName, p1.blastName,
//                            p1Score, p2.nickName, p2.blastName,
//                            p2Score);
//                    System.out.println("\n");
//                    System.out.println("====================================="
//                            + "======================================GAME END");
//                    System.out.println();
//                    playSet();
//                } else if (x == p2) {
//                    p2Score++;
//                    System.out.printf("%s | %s %s: %s games ● %s %s: %s games",
//                            game.getResult(x), p1.nickName, p1.blastName,
//                            p1Score, p2.nickName, p2.blastName,
//                            p2Score);
//                    System.out.println("\n");
//                    System.out.println("====================================="
//                            + "======================================GAME END");
//                    System.out.println();
//                    playSet();
//                }
//            }
//        }
//    }
//    
//    public String getResult(Player winner) {
//        String result;
//        
//        result = winner.nickName + " " + winner.blastName + 
//        " has won the set";
//
//        return result;
//    }
//}
//
