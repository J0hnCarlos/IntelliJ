package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {
    private appFrame appFrame;

    public GameEngineCallbackGUI(appFrame appFrame)
    {
        this.appFrame = appFrame;
    }

    public void playerDieUpdate(final Player player, final DicePair dicePair, GameEngine gameEngine)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // update rolling dices
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().update(dicePair.getDie1().getValue(), dicePair.getDie2().getValue());
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().getResult().setText("Dice 1: " + dicePair.getDie1().getValue() + ",  Dice 2: " + dicePair.getDie2().getValue() + " .. Total: " + (dicePair.getDie1().getValue() + dicePair.getDie2().getValue()));

                //update game status
                appFrame.getStatusBar().getGameStatus().setText("GAME STATUS: " + player.getPlayerName() + " ROLLING...");
            }
        });
    }

    @Override
    public void playerDieUpdate(Player player, Die die, GameEngine gameEngine) {

    }

    @Override
    public void houseDieUpdate(Die die, GameEngine gameEngine) {

    }

    @Override
    public void playerResult(final Player player, final DicePair result, final GameEngine gameEngine)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // update rolling dices
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().update(result.getDie1().getValue(), result.getDie2().getValue());
                appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().update(result.getDie1().getValue(), result.getDie2().getValue());

                // check if the selected player has rolled
                if(gameEngine.getPlayer(appFrame.getPlayerID()).getResult()!=null)
                {
                    // update rolling dices
                    appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().getResult().setText("Dice 1: " + result.getDie1() + ",  Dice 2: " + result.getDie2() + " .. Total: " + (result.getDie1().getValue() + result.getDie2().getValue()));

                    // update player rolled dices
                    appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().getResult().setText(gameEngine.getPlayer(appFrame.getPlayerID()).getResult().toString());
                }
                else
                {
                    appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().getResult().setText("Oops! Haven't rolled yet.");
                }

                // update game status
                appFrame.getStatusBar().getGameStatus().setText("GAME STATUS: " + player.getPlayerName() + " HAS FINISHED ROLLING!");
            }
        });
    }

    public void houseDieUpdate(final DicePair dicePair, GameEngine gameEngine)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // update rolling dices
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().update(dicePair.getDie1().getValue(), dicePair.getDie2().getValue());
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().getResult().setText("Dice 1: " + dicePair.getDie1().getValue() + ",  Dice 2: " + dicePair.getDie2().getValue() + " .. Total: " + (dicePair.getDie1().getValue() + dicePair.getDie2().getValue()));

                // update game status
                appFrame.getStatusBar().getGameStatus().setText("GAME STATUS: HOUSE ROLLING...");
            }
        });
    }

    @Override
    public void houseResult(final DicePair result, final GameEngine gameEngine)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // update rolling dices
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().update(result.getDie1().getValue(), result.getDie2().getValue());
                appFrame.getInfo().getCurrentPanel().getDiceRollingPanel().getResult().setText("Dice 1: " + result.getDie1().getValue() + ",  Dice 2: " + result.getDie2().getValue() + " .. Total: " + (result.getDie1().getValue() + result.getDie2().getValue()));

                //update house rolled dices
                appFrame.getInfo().getDiceResultPanel().getHouseDiceResultPanel().update(result.getDie1().getValue(), result.getDie2().getValue());
                appFrame.getInfo().getDiceResultPanel().getHouseDiceResultPanel().getResult().setText("Dice 1: " + result.getDie1().getValue() + ",  Dice 2: " + result.getDie2().getValue() + " .. Total: " + (result.getDie1().getValue() + result.getDie2().getValue()));

                // update game status
                appFrame.getStatusBar().getGameStatus().setText("GAME STATUS: HOUSE HAS FINISHED ROLLING!");
            }
        });
    }
}
