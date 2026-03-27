package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

    private String id, name;
    private int points, bet;
    private DicePair result;

    // Constructor
    public SimplePlayer(String id, String playerName, int initialPoints) {
        this.id = id;
        this.name = playerName;
        this.points = initialPoints;
    }

    // gives player name
    @Override
    public String getPlayerName() {
        return name;
    }

    // sets player's name
    @Override
    public void setPlayerName(String playerName) {
        this.name = playerName;
    }

    // gives player points
    @Override
    public int getPoints() {
        return points;
    }

    // sets player's points
    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    // gives player id
    @Override
    public String getPlayerId() {
        return id;
    }

    // sets player's id
    @Override
    public boolean setBet(int bet) {
        if (bet > 0 && bet <= points){
            // if bet is valid
            this.bet = bet;
            return true;
        } else {
            // if bet is invalid
            return false;
        }
    }

    // gives player bet
    @Override
    public int getBet() {
        return bet;
    }

    // resets bet placed
    @Override
    public void resetBet() {
        this.bet = 0;
    }

    // gives result
    @Override
    public DicePair getResult() {
        return result;
    }

    // sets result
    @Override
    public void setResult(DicePair rollResult) {
        this.result = rollResult;
    }

    // displaying player data
    @Override
    public String toString(){
        return String.format("Player: id = %s, Name = %s, Bet = %d, Points = %d, RESULT .. Dice 1: %d, Dice 2: %d .. Total: %d",
                id, name, bet, points, result.getDie1().getValue(),
                result.getDie2().getValue(), result.getTotal());
    }
}
