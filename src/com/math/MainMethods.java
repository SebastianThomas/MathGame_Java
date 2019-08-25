package com.mathEasy;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.logging.Logger;

public class MainMethods
{
    private static final Logger log;
    private static String sNrOfPlayers;
    private static int nrOfPlayers;
    
    static {
        log = Logger.getLogger(MainMethods.class.getName());
        MainMethods.sNrOfPlayers = "";
        MainMethods.nrOfPlayers = 0;
    }
    
    protected static int setPlayersNr(final JFrame jframe) {
        String instruction = "Bitte Spielerzahl eingeben: ";
        instruction.trim();
        final String tryAgain = "Bitte erneut probieren. ";
        tryAgain.trim();
        final String insertInt = "Bitte eine Ganzzahl eingeben:";
        insertInt.trim();
        while (true) {
            (MainMethods.sNrOfPlayers = JOptionPane.showInputDialog(jframe, instruction)).trim();
            MainMethods.log.info(MainMethods.sNrOfPlayers);
            try {
                return MainMethods.nrOfPlayers = Integer.parseInt(MainMethods.sNrOfPlayers);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jframe, tryAgain);
                if (!instruction.contains(insertInt)) {
                    instruction = String.valueOf(insertInt) + "\n" + instruction;
                }
                e.printStackTrace();
                if (MainMethods.nrOfPlayers != 0) {
                    return MainMethods.nrOfPlayers;
                }
                continue;
            }
        }
    }
    
    protected static GameCategories.Categories[] setCategoriesNumbers(final GameCategories.Categories[] cats, final JFrame jframe) {
        final int changeBoolean = JOptionPane.showConfirmDialog(jframe, "M\u00f6chtest du die Punkte der Kategorien \u00e4ndern? ");
        if (changeBoolean == 0) {
            for (final GameCategories.Categories c : cats) {
                try {
                    c.setCategoryPoints(jframe);
                }
                catch (NullPointerException e) {
                    System.out.println("This one is null and I don't know how to filter it out... ");
                }
            }
            return cats;
        }
        if (changeBoolean == 1) {
            return cats;
        }
        if (changeBoolean == 2) {
            System.exit(1);
            return cats;
        }
        return cats;
    }
    
    protected static int chooseNrOfRounds(final JFrame jframe) {
        int methodNumberOfRounds = 0;
        final String instruction = "Bitte Rundenzahl eingeben: ";
        instruction.trim();
        final String tryAgain = "Bitte erneut probieren. ";
        tryAgain.trim();
        final String insertInt = "Bitte eine Ganzzahl eingeben:";
        insertInt.trim();
        try {
            methodNumberOfRounds = Integer.parseInt(JOptionPane.showInputDialog(jframe, instruction));
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jframe, tryAgain);
            System.exit(1);
        }
        return methodNumberOfRounds;
    }
}
