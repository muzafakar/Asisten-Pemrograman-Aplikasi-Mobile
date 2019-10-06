package com.muzadev.asistenpemrogramanaplikasimobile.model;

public class PlayerModel {
    private String playerName;
    private String playerPosition;
    private int playerNumber;

    public PlayerModel(String playerName, String playerPosition, int playerNumber) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
