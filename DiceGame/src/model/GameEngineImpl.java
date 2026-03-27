package model;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

import java.util.*;

public class GameEngineImpl implements GameEngine {

    private boolean stop;

    private ArrayList<GameEngineCallback> gameEngineCollection = new ArrayList<GameEngineCallback>();
    private HashMap<String, Player> collectionPlayer = new HashMap<String, Player>();

    // roll player dice
    @Override
    public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2){
        checkDelay(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
        stop = false;
        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        addGameEngineCallback(gameEngineCallback);
        DicePairImpl dicePlayer = new DicePairImpl();
        while (stop == false) {
            DicePairImpl dicePlayerLoading = new DicePairImpl();
            if (initialDelay1 < finalDelay1) {
                initialDelay1 += delayIncrement1;
                gameEngineCollection.get(0).playerDieUpdate(getPlayer(player.getPlayerId()), dicePlayerLoading.getDie1(), GameEngineImpl.this);
            }
            if (initialDelay2 < finalDelay2) {
                initialDelay2 += delayIncrement2;
                gameEngineCollection.get(0).playerDieUpdate(getPlayer(player.getPlayerId()), dicePlayerLoading.getDie2(), GameEngineImpl.this);
            }
            if (initialDelay1 >= finalDelay1 && initialDelay2 >= finalDelay2) {
                stop = true;
            }
            dicePlayer = dicePlayerLoading;
        }

        player.setResult(dicePlayer);
        gameEngineCollection.get(0).playerResult(getPlayer(player.getPlayerId()), dicePlayer, GameEngineImpl.this);
        removeGameEngineCallback(gameEngineCallback);
    }

    // roll house dice
    @Override
    public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) {
        checkDelay(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
        stop = false;
        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        addGameEngineCallback(gameEngineCallback);
        DicePairImpl diceHouse = new DicePairImpl();
        while (stop == false) {
            DicePairImpl diceHouseLoading = new DicePairImpl();
            if (initialDelay1 < finalDelay1) {
                initialDelay1 += delayIncrement1;
                gameEngineCollection.get(0).houseDieUpdate(diceHouseLoading.getDie1(), GameEngineImpl.this);
            }
            if (initialDelay2 < finalDelay2) {
                initialDelay2 += delayIncrement2;
                gameEngineCollection.get(0).houseDieUpdate(diceHouseLoading.getDie2(), GameEngineImpl.this);
            }
            if (initialDelay1 >= finalDelay1 && initialDelay2 >= finalDelay2) {
                stop = true;
            }
            diceHouse = diceHouseLoading;
        }

        // run applyWinLoss to player
        Collection<Player> data = collectionPlayer.values();
        for (Iterator<Player> i = data.iterator(); i.hasNext();) {
            Player p = i.next();
            applyWinLoss(p, diceHouse);
        }

        // display result
        gameEngineCollection.get(0).houseResult(diceHouse, GameEngineImpl.this);

        for (Iterator<Player> dataSet = data.iterator(); dataSet.hasNext();) {
            Player p = dataSet.next();
            p.resetBet();
        }
        removeGameEngineCallback(gameEngineCallback);
    }

    // code to check if player win or lose bet and modify points
    @Override
    public void applyWinLoss(Player player, DicePair houseResult) {
//        if (player.getResult().compareTo(houseResult) > 0){
//            player.setPoints(player.getPoints() + player.getBet());
//        } else if (player.getResult().compareTo(houseResult) < 0){
//            player.setPoints(player.getPoints() - player.getBet());
//        }

        if (player.getResult().getTotal() > houseResult.getTotal()){
            player.setPoints(player.getPoints() + player.getBet());
        } else if (player.getResult().getTotal() < houseResult.getTotal()){
            player.setPoints(player.getPoints() - player.getBet());
        } else {}
    }

    // add new player
    @Override
    public void addPlayer(Player player) {
        collectionPlayer.put(player.getPlayerId(), player);
    }

    // return player
    @Override
    public Player getPlayer(String id) {
        return collectionPlayer.get(id);
    }

    // remove a player
    @Override
    public boolean removePlayer(Player player) {
        return collectionPlayer.remove(player.getPlayerId(), player);
    }

    // placing a bet
    @Override
    public boolean placeBet(Player player, int bet) {
        return player.setBet(bet);
    }

    // adding new gameEngineCallback
    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
        gameEngineCollection.add(gameEngineCallback);
    }

    // remove gameEngineCallback
    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
        return this.gameEngineCollection.remove(gameEngineCallback);
    }

    // return all player
    @Override
    public Collection<Player> getAllPlayers() {
        return Collections.unmodifiableCollection(collectionPlayer.values());
    }

    // check if delay meet criteria
    private void checkDelay(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2){
        if (initialDelay1 < 0 || initialDelay2 < 0 || delayIncrement1 < 0 || delayIncrement2 < 0 || finalDelay1 < 0 || finalDelay2 < 0){
            throw new IllegalArgumentException("Delay parameter can't be < 0");
        }

        if (finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2) {
            throw new IllegalArgumentException("Final Delay can't be < Initial Delay");
        }

        if (delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2)){
            throw new IllegalArgumentException("Delay Increment > (final Delay - Initial Delay)");
        }
    }
}
