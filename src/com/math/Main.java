package com.mathEasy;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main
{
    private static Player[] players;
    
    public static Player[] setPlayers(final JFrame jframe) {
        int playernr;
        for (playernr = 0; playernr == 0; playernr = MainMethods.setPlayersNr(jframe)) {}
        JOptionPane.showMessageDialog(jframe, "Ihr spielt mit " + playernr + " Spielern. ");
        Main.players = new Player[playernr];
        for (int i = 0; i < Main.players.length; ++i) {
            Main.players[i] = new Player(jframe);
            System.out.println("An Position " + (i + 1) + " steht " + Main.players[i].getPlayerName());
        }
        return Main.players = ChangeOrder.changeOrder(Main.players, jframe);
    }
    
    public static void main(final String[] args) {
        final JFrame MainJFrame = new JFrame("MainJFrame");
        MainJFrame.setSize(600, 250);
        MainJFrame.dispose();
        setPlayers(MainJFrame);
        final GameCategories.Categories[] cats = GameCategories.Categories.chooseCategories(MainJFrame);
        final ArrayList<GameCategories.Categories> catsList = new ArrayList<GameCategories.Categories>(Arrays.asList(cats));
        MainMethods.setCategoriesNumbers(cats, MainJFrame);
        final int numberOfRounds = MainMethods.chooseNrOfRounds(MainJFrame);
        Player[] players;
        for (int length = (players = Main.players).length, i = 0; i < length; ++i) {
            final Player player = players[i];
            player.playerTries = new Integer[numberOfRounds];
        }
        for (int round = 0; round < numberOfRounds; ++round) {
            Player[] players2;
            for (int length2 = (players2 = Main.players).length, j = 0; j < length2; ++j) {
                final Player player2 = players2[j];
                try {
                    player2.playerTries[round] = Integer.parseInt(JOptionPane.showInputDialog(MainJFrame, "Wie viele Punkte hat " + player2.getPlayerName() + " in dieser Runde erreicht? "));
                }
                catch (NumberFormatException e2) {
                    player2.playerTries[round] = Integer.parseInt(JOptionPane.showInputDialog(MainJFrame, "Bitte erneut versuchen: \nWie viele Punkte hat " + player2.getPlayerName() + " in dieser Runde erreicht? "));
                }
            }
            JOptionPane.showMessageDialog(MainJFrame, "Diese Runde ist beendet. ");
        }
        Player[] players3;
        for (int length3 = (players3 = Main.players).length, k = 0; k < length3; ++k) {
            final Player player = players3[k];
            final List<Integer> playerTriesList = new ArrayList<Integer>(Arrays.asList(player.playerTries));
            JOptionPane.showMessageDialog(MainJFrame, "Folgende Punktzahlen hat der Spieler " + player.getPlayerName() + " in diesem Match erreicht: " + playerTriesList);
        }
        if (catsList.contains(GameCategories.Categories.arithmidle)) {
            final Player[] playerWithHighestArithMiddle = GameCategories.getPlayerWithHighestArithMiddle(Main.players);
            try {
                Player[] array;
                for (int length4 = (array = playerWithHighestArithMiddle).length, l = 0; l < length4; ++l) {
                    final Player player2 = array[l];
                    player2.addPlayerPoints(GameCategories.Categories.arithmidle.getCategoryPoints());
                }
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (catsList.contains(GameCategories.Categories.highest)) {
            final Player[] PlayerWithHighest = GameCategories.getPlayerWithHighest(Main.players);
            try {
                Player[] array2;
                for (int length5 = (array2 = PlayerWithHighest).length, n = 0; n < length5; ++n) {
                    final Player player2 = array2[n];
                    player2.addPlayerPoints(GameCategories.Categories.highest.getCategoryPoints());
                }
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (catsList.contains(GameCategories.Categories.lowest)) {
            final Player[] PlayerWithLowest = GameCategories.getPlayerWithLowest(Main.players);
            try {
                Player[] array3;
                for (int length6 = (array3 = PlayerWithLowest).length, n2 = 0; n2 < length6; ++n2) {
                    final Player player2 = array3[n2];
                    player2.addPlayerPoints(GameCategories.Categories.lowest.getCategoryPoints());
                }
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (catsList.contains(GameCategories.Categories.leastSA)) {
            final Player[] PlayerWithLeastSA = GameCategories.getPlayerWithLeastSA(Main.players);
            try {
                Player[] array4;
                for (int length7 = (array4 = PlayerWithLeastSA).length, n3 = 0; n3 < length7; ++n3) {
                    final Player player2 = array4[n3];
                    player2.addPlayerPoints(GameCategories.Categories.leastSA.getCategoryPoints());
                }
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        Player[] players4;
        for (int length8 = (players4 = Main.players).length, n4 = 0; n4 < length8; ++n4) {
            final Player player = players4[n4];
            JOptionPane.showMessageDialog(MainJFrame, "Der Spieler " + player.getPlayerName() + " erreichte " + player.getPlayerPoints() + " Punkte. ");
        }
        final List<Player> winningPlayerList = new ArrayList<Player>();
        final ArrayList<Integer> playerPoints = new ArrayList<Integer>();
        Player[] players5;
        for (int length9 = (players5 = Main.players).length, n5 = 0; n5 < length9; ++n5) {
            final Player player3 = players5[n5];
            playerPoints.add(player3.getPlayerPoints());
        }
        final int winningPlayerPoints = Collections.max((Collection<? extends Integer>)playerPoints);
        Player[] players6;
        for (int length10 = (players6 = Main.players).length, n6 = 0; n6 < length10; ++n6) {
            final Player player3 = players6[n6];
            final int currentPlayerPoints = player3.getPlayerPoints();
            if (currentPlayerPoints == winningPlayerPoints) {
                winningPlayerList.add(player3);
            }
        }
        if (winningPlayerList.size() == 1) {
            JOptionPane.showMessageDialog(MainJFrame, String.valueOf(winningPlayerList.get(0).getPlayerName()) + " hat gewonnen. ");
        }
        else if (winningPlayerList.size() > 1) {
            String allWinningPlayersString = "";
            String allWinningPlayers = "";
            for (final Player player4 : winningPlayerList) {
                allWinningPlayers = String.valueOf(allWinningPlayers) + player4.getPlayerName();
                allWinningPlayers = String.valueOf(allWinningPlayers) + ", ";
                final int lastAndWrongComma = allWinningPlayers.lastIndexOf(", ");
                allWinningPlayersString = allWinningPlayers.substring(0, lastAndWrongComma);
            }
            JOptionPane.showMessageDialog(MainJFrame, String.valueOf(allWinningPlayersString) + " haben gewonnen! \n");
        }
        System.exit(0);
    }
}
