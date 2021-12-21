package ch.sthomas.math;

import javax.swing.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class ChangeOrder {
    public static Player[] changeOrder(Player[] players, final JFrame jframe) {
        final int changeOrderTrue = JOptionPane.showConfirmDialog(jframe, "Willst du die Reihenfolge \u00e4ndern?");
        if (changeOrderTrue == 0) {
            int newPlayerNr = 0;
            System.out.println("Bitte Reihenfolge eingeben. ");
            try {
                Player[] array;
                for (int length = (array = players).length, i = 0; i < length; ++i) {
                    final Player player = array[i];
                    try {
                        newPlayerNr = Integer.parseInt(JOptionPane.showInputDialog(jframe, "An welcher Position soll " + player.getPlayerName() + " stehen? "));
                        if (newPlayerNr < 1) {
                            throw new NumberFormatException();
                        }
                        player.setPlayerNr(newPlayerNr);
                    } catch (NumberFormatException e2) {
                        JOptionPane.showMessageDialog(jframe, String.valueOf(newPlayerNr) + " ist keine g\u00fcltige (!!!) Ganzzahl. ");
                        System.exit(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            final Map<Integer, Player> playersMap = new HashMap<Integer, Player>();
            Player[] array2;
            for (int length2 = (array2 = players).length, j = 0; j < length2; ++j) {
                final Player player2 = array2[j];
                playersMap.put(player2.getPlayerNr(), player2);
            }
            final Map<Integer, Player> sortedPlayersMap = new TreeMap<Integer, Player>();
            sortedPlayersMap.putAll(playersMap);
            for (Player player4 : sortedPlayersMap.values()) {
            }
            final Collection<Player> playersCollection = sortedPlayersMap.values();
            players = playersCollection.toArray(new Player[playersCollection.size()]);
            Player[] array3;
            for (int length3 = (array3 = players).length, k = 0; k < length3; ++k) {
                final Player player3 = array3[k];
                Player[] array4;
                for (int length4 = (array4 = players).length, l = 0; l < length4; ++l) {
                    final Player playerTwo = array4[l];
                    if (player3 != playerTwo) {
                        final int playerNr = player3.getPlayerNr();
                        final int playerTwoNr = playerTwo.getPlayerNr();
                        if (playerNr == playerTwoNr) {
                            JOptionPane.showMessageDialog(jframe, "Die beiden Spieler " + player3.getPlayerName() + " und " + playerTwo.getPlayerName() + " haben die gleiche Position. ");
                            System.exit(1);
                        }
                    }
                }
            }
        } else if (changeOrderTrue == 1) {
            JOptionPane.showMessageDialog(jframe, "OK. Then let's continue! ");
        }
        for (int iFor = 0; iFor < players.length; ++iFor) {
            JOptionPane.showMessageDialog(jframe, "An Position " + (iFor + 1) + " spielt " + players[iFor].getPlayerName());
        }
        return players;
    }
}
