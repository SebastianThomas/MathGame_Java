package com.mathEasy;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

class Player
{
    private String playerName;
    private int playerNr;
    private int playerPoints;
    protected Integer[] playerTries;
    
    public Player(final JFrame jframe) {
        this.playerName = "";
        this.setPlayerName(JOptionPane.showInputDialog(jframe, "Bitte Namen f\u00fcr den n\u00e4chsten Spieler eingeben. "));
        JOptionPane.showMessageDialog(jframe, "N\u00e4chster Spieler hei\u00dft " + this.getPlayerName());
    }
    
    public int getPlayerNr() {
        return this.playerNr;
    }
    
    public void setPlayerNr(final int newNumber) {
        this.playerNr = newNumber;
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public void setPlayerName(final String playerName) {
        this.playerName = playerName;
    }
    
    public int getPlayerPoints() {
        return this.playerPoints;
    }
    
    public void addPlayerPoints(final int toAddPlayerPoints) {
        this.playerPoints += toAddPlayerPoints;
    }
}
