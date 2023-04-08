import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static void Solution(String args[]) {

        //Offer (add)
        //poll (remove)
        //peek (look at highest)

        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            player1.offer(cardValue(in.next())); // the n cards of player 1
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            player2.offer(cardValue(in.next())); // the m cards of player 2
        }
        int rounds = 0;
        boolean endGame = false;
        ArrayList<Integer> p1WinCards = new ArrayList<>();
        ArrayList<Integer> p2WinCards = new ArrayList<>();
        while(!endGame) {
            rounds++;
            if(player1.peek() > player2.peek()) {
                player1.offer(player1.poll());
                player1.offer(player2.poll());
            }
            else if(player1.peek() < player2.peek()) {
                player2.offer(player1.poll());
                player2.offer(player2.poll());
            }
            else if(player1.peek() == player2.peek()) {
                Integer p1card = player1.poll();
                Integer p2card = player2.poll();

                p1WinCards.add(player1.poll());
                p1WinCards.add(player1.poll());
                p1WinCards.add(player1.poll());

                p2WinCards.add(player2.poll());
                p2WinCards.add(player2.poll());
                p2WinCards.add(player2.poll());
                if(p1WinCards.contains(null) || p2WinCards.contains(null)) {
                    System.out.println("PAT " + rounds);
                    endGame = true;
                }
                boolean war = true;
                boolean firstRound = true;
                while(war) {
                    if(!firstRound) {
                        p1card = player1.poll();
                        p2card = player2.poll();
                    }


                    firstRound = false;
                    if(p1card > p2card) {
                        player1.offer(p1card);
                        for(int j : p1WinCards) player1.offer(j);
                        player1.offer(p2card);
                        for(int j : p2WinCards) player1.offer(j);
                        war = false;
                    }
                    else if(p1card < p2card) {
                        player2.offer(p1card);
                        for(int j : p1WinCards) player2.offer(j);
                        player2.offer(p2card);
                        for(int j : p2WinCards) player2.offer(j);
                        war = false;
                    }
                    else if(p1card == p2card) {
                        p1WinCards.add(p1card);
                        p2WinCards.add(p2card);
                    }
                }
            }
            if(player1.peek() == null) {
                System.out.println("2 " + rounds);
                endGame = true;
            }
            else if(player2.peek() == null) {
                System.out.println("1 " + rounds);
                endGame = true;
            }
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }

    static int cardValue(String card) {
        if(card.contains("1") && !card.contains("0")) return 1;
        if(card.contains("2")) return 2;
        if(card.contains("3")) return 3;
        if(card.contains("4")) return 4;
        if(card.contains("5")) return 5;
        if(card.contains("6")) return 6;
        if(card.contains("7")) return 7;
        if(card.contains("8")) return 8;
        if(card.contains("9")) return 9;
        if(card.contains("10")) return 10;
        if(card.contains("J")) return 11;
        if(card.contains("Q")) return 12;
        if(card.contains("K")) return 13;
        if(card.contains("A")) return 14;
        return 0;
    }
}