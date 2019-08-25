package com.mathEasy;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.logging.Logger;
import java.util.TreeMap;

public class GameCategories
{
    public static double arithMiddle(final Player player) {
        final Integer[] tries = player.playerTries;
        double aMPoints = 0.0;
        double numbersPoints = 0.0;
        Integer[] array;
        for (int length = (array = tries).length, j = 0; j < length; ++j) {
            final double i = array[j];
            numbersPoints += i;
        }
        aMPoints = numbersPoints / tries.length;
        return aMPoints;
    }
    
    public static Player[] getPlayerWithHighestArithMiddle(final Player[] players) {
        final TreeMap<Double, Player> playerArithMiddleSet = new TreeMap<Double, Player>();
        final Player[] targetPlayers = new Player[players.length];
        for (final Player player : players) {
            playerArithMiddleSet.put(arithMiddle(player), player);
        }
        final Double maxArithMiddle = playerArithMiddleSet.lastKey();
        int iFillTargetPlayers = 0;
        for (final Player player2 : players) {
            if (arithMiddle(player2) == maxArithMiddle) {
                targetPlayers[iFillTargetPlayers] = player2;
                ++iFillTargetPlayers;
            }
        }
        return targetPlayers;
    }
    
    public static double leastSA(final Player player) {
        final Integer[] tries = player.playerTries;
        double leastSAPoints = 0.0;
        double numbersPoints = 0.0;
        final double aM = arithMiddle(player);
        Integer[] array;
        for (int length = (array = tries).length, j = 0; j < length; ++j) {
            final double i = array[j];
            final double thisBracket = (aM - i) * (aM - i);
            numbersPoints += thisBracket;
        }
        numbersPoints /= tries.length;
        leastSAPoints = Math.sqrt(numbersPoints);
        return leastSAPoints;
    }
    
    public static Player[] getPlayerWithLeastSA(final Player[] players) {
        final TreeMap<Double, Player> playerLeastSASet = new TreeMap<Double, Player>();
        final Player[] targetPlayers = new Player[players.length];
        for (final Player player : players) {
            playerLeastSASet.put(leastSA(player), player);
        }
        final Double leastSA = playerLeastSASet.firstKey();
        int iFillTargetPlayers = 0;
        for (final Player player2 : players) {
            if (leastSA(player2) == leastSA) {
                targetPlayers[iFillTargetPlayers] = player2;
                ++iFillTargetPlayers;
            }
        }
        return targetPlayers;
    }
    
    public static double highest(final Player player) {
        final Integer[] tries = player.playerTries;
        double highest = 0.0;
        Integer[] array;
        for (int length = (array = tries).length, j = 0; j < length; ++j) {
            final double i = array[j];
            if (i > highest) {
                highest = i;
            }
        }
        return highest;
    }
    
    public static Player[] getPlayerWithHighest(final Player[] players) {
        final TreeMap<Double, Player> playerHighestSet = new TreeMap<Double, Player>();
        final Player[] targetPlayers = new Player[players.length];
        for (final Player player : players) {
            playerHighestSet.put(highest(player), player);
        }
        final Double highest = playerHighestSet.lastKey();
        int iFillTargetPlayers = 0;
        for (final Player player2 : players) {
            if (highest(player2) == highest) {
                targetPlayers[iFillTargetPlayers] = player2;
                ++iFillTargetPlayers;
            }
        }
        return targetPlayers;
    }
    
    public static double lowest(final Player player) {
        final Integer[] tries = player.playerTries;
        double lowest = 0.0;
        Integer[] array;
        for (int length = (array = tries).length, j = 0; j < length; ++j) {
            final double i = array[j];
            if (i < lowest) {
                lowest = i;
            }
        }
        return lowest;
    }
    
    public static Player[] getPlayerWithLowest(final Player[] players) {
        final TreeMap<Double, Player> playerLowestSet = new TreeMap<Double, Player>();
        final Player[] targetPlayers = new Player[players.length];
        for (final Player player : players) {
            playerLowestSet.put(lowest(player), player);
        }
        final Double lowest = playerLowestSet.firstKey();
        int iFillTargetPlayers = 0;
        for (final Player player2 : players) {
            if (lowest(player2) == lowest) {
                targetPlayers[iFillTargetPlayers] = player2;
                ++iFillTargetPlayers;
            }
        }
        return targetPlayers;
    }
    
    public enum Categories
    {
        highest("highest", 0, "H\u00f6chster Wert", 50), 
        lowest("lowest", 1, "Niedrigster Wert", -20), 
        leastSA("leastSA", 2, "Niedrigste Standardabweichung", 150), 
        arithmidle("arithmidle", 3, "H\u00f6chstes arithmetisches Mittel", 85);
        
        public String germanName;
        private int CategoryPoints;
        private static final Logger log;
        
        static {
            log = Logger.getLogger(GameCategories.class.getName());
        }
        
        private Categories(final String name, final int ordinal, final String gN, final int CategoryPoints) {
            this.germanName = gN;
            this.CategoryPoints = CategoryPoints;
        }
        
        public int getCategoryPoints() {
            return this.CategoryPoints;
        }
        
        public void setCategoryPoints(final JFrame jframe) {
            final String newPoints = JOptionPane.showInputDialog(jframe, "Wie viele Punkte soll die Kategorie " + this.germanName + " geben?");
            this.CategoryPoints = Integer.parseInt(newPoints.trim());
        }
        
        public static Categories[] getSelectedCategories() {
            return null;
        }
        
        private static Categories[] chooseCats(final JFrame jframe) {
            final Categories[] gc = new Categories[values().length];
            final JPanel jpanel = new JPanel();
            jpanel.setBackground(Color.LIGHT_GRAY);
            final JLabel jlabel = new JLabel("Bitte Kategorien ausw\u00e4hlen: ");
            jpanel.add(jlabel);
            final JCheckBox checkboxAM = new JCheckBox("Arithmetisches Mittel");
            final JCheckBox checkboxhighest = new JCheckBox("H\u00f6chster Wert");
            final JCheckBox checkboxlowest = new JCheckBox("Niedrigster Wert");
            final JCheckBox checkboxLeastSA = new JCheckBox("Niedrigste Standardabweichung");
            jpanel.add(checkboxAM);
            jpanel.add(checkboxhighest);
            jpanel.add(checkboxlowest);
            jpanel.add(checkboxLeastSA);
            final JButton OK = new JButton("OK");
            jpanel.add(OK);
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    int i = 0;
                    if (checkboxAM.isSelected()) {
                        gc[i] = Categories.arithmidle;
                        ++i;
                    }
                    if (checkboxhighest.isSelected()) {
                        gc[i] = Categories.highest;
                        ++i;
                    }
                    if (checkboxlowest.isSelected()) {
                        gc[i] = Categories.lowest;
                        ++i;
                    }
                    if (checkboxLeastSA.isSelected()) {
                        gc[i] = Categories.leastSA;
                        ++i;
                    }
                    jframe.dispose();
                }
            });
            jframe.add(jpanel);
            jframe.setVisible(true);
            jframe.setLocationRelativeTo(null);
            return gc;
        }
        
        private static void showChosenCats(final Categories[] cats, final JFrame jframe) {
            final ArrayList<String> catsGNList = new ArrayList<String>();
            for (final Categories c : cats) {
                catsGNList.add(c.germanName);
            }
            final int confirmed = JOptionPane.showConfirmDialog(jframe, "Folgende Kategorien sind ausgew\u00e4hlt: " + catsGNList);
            switch (confirmed) {
                case 1: {
                    Categories.log.info("not confirmed");
                    JOptionPane.showMessageDialog(jframe, "Exit the game. ");
                    System.exit(0);
                }
                case 2: {
                    Categories.log.info("break");
                    JOptionPane.showMessageDialog(jframe, "Exit the game. ");
                    System.exit(0);
                    break;
                }
            }
        }
        
        private static void waitUntilCatsAreChosen(final Categories[] cats) {
            do {
                System.out.println();
            } while (cats[0] == null);
        }
        
        public static Categories[] chooseCategories(final JFrame jframe) {
            jframe.setSize(500, 100);
            final Categories[] gc = chooseCats(jframe);
            waitUntilCatsAreChosen(gc);
            jframe.setSize(600, 250);
            final Categories[] nonNullgc = ArrayWithNull.unnull(gc);
            final int nonNullLength = nonNullgc.length;
            Categories.log.fine("nonNullLength: " + Integer.valueOf(nonNullLength).toString());
            showChosenCats(nonNullgc, jframe);
            return nonNullgc;
        }
    }
}
