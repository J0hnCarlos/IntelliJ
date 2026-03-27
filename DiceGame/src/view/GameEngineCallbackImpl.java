package view;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 *
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
    private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

    public GameEngineCallbackImpl() {
        // FINE shows rolling output, INFO only shows result
        logger.setLevel(Level.FINE);
    }

    @Override
    public void playerDieUpdate(Player player, Die die, GameEngine gameEngine) {
        // intermediate results logged at Level.FINE
        logger.log(Level.FINE, String.format("%s die %s" + " rolled to %s", player.getPlayerName(), die.getNumber(), die.toString()));
    }

    @Override
    public void houseDieUpdate(Die die, GameEngine gameEngine) {
        logger.log(Level.FINE, String.format("House die %s" + " rolled to %s", die.getNumber(), die.toString()));
    }

    @Override
    public void playerResult(Player player, DicePair result, GameEngine gameEngine) {
        // final results logged at Level.INFO
        logger.log(Level.INFO, String.format("Player: id=%s" + ", name=%s" + ", bet=%s" + ", points=%s" + ", RESULT .. %s"
                , player.getPlayerId(), player.getPlayerName(), player.getBet(), player.getPoints(), result.toString()));
    }

    @Override
    public void houseResult(DicePair result, GameEngine gameEngine) {
        logger.log(Level.INFO, String.format("House *RESULT*: " + result.toString()));
        logger.log(Level.INFO, String.format("FINAL PLAYER RESULT"));

        String message = "";
        Collection<Player> allPlayer = gameEngine.getAllPlayers();
        for (Iterator<Player> iterator = allPlayer.iterator(); iterator.hasNext(); ) {
            Player play = iterator.next();
            message += play.toString() + "\n";
        }

        logger.log(Level.INFO, String.format(message));
    }
}
