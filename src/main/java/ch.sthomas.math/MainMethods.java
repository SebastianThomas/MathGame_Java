package ch.sthomas.math;

import javax.swing.*;
import java.util.logging.Logger;

public class MainMethods {
    private static final Logger log;
    private static String sNrOfPlayers;
    private static int nrOfPlayers;

    static {
        log = Logger.getLogger(MainMethods.class.getName());
        MainMethods.sNrOfPlayers = "";
        MainMethods.nrOfPlayers = 0;
    }

    protected static int setPlayersNr(final JFrame jframe) {
        String instruction = "Bitte Spielerzahl eingeben: ".trim();
        final String tryAgain = "Bitte erneut probieren. ".trim();
        final String insertInt = "Bitte eine Ganzzahl eingeben:".trim();

        while (true) {
            (MainMethods.sNrOfPlayers = JOptionPane.showInputDialog(jframe, instruction)).trim();
            MainMethods.log.info(MainMethods.sNrOfPlayers);
            try {
                return MainMethods.nrOfPlayers = Integer.parseInt(MainMethods.sNrOfPlayers);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jframe, tryAgain);
                if (!instruction.contains(insertInt)) {
                    instruction = insertInt + "\n" + instruction;
                }
                e.printStackTrace();
                if (MainMethods.nrOfPlayers != 0) {
                    return MainMethods.nrOfPlayers;
                }
            }
        }
    }

    protected static GameCategories.Categories[] setCategoriesNumbers(final GameCategories.Categories[] cats, final JFrame jframe) {
        final int changeBoolean = JOptionPane.showConfirmDialog(jframe, "M\u00f6chtest du die Punkte der Kategorien \u00e4ndern? ");
        if (changeBoolean == 0) {
            for (final GameCategories.Categories c : cats) {
                try {
                    c.setCategoryPoints(jframe);
                } catch (NullPointerException e) {
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

        final String instruction = "Bitte Rundenzahl eingeben: ".trim();
        final String tryAgain = "Bitte erneut probieren. ".trim();

        try {
            methodNumberOfRounds = Integer.parseInt(JOptionPane.showInputDialog(jframe, instruction));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jframe, tryAgain);
            System.exit(1);
        }

        return methodNumberOfRounds;
    }
}
