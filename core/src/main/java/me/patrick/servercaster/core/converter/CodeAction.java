package me.patrick.servercaster.core.converter;

import java.util.Collection;
import mkremins.fanciful.FancyMessage;
import org.bukkit.entity.Player;

/**
 * This class can be used to add actions when extended.
 *
 * @author Patrick Beuks
 */
public abstract class CodeAction {

    private FancyMessage fm;
    private int arguments;
    private int argumentsLeft;
    private Player[] players;

    /**
     *
     * @param arguments The amount of arguments this code needs (how many sets
     * of brackets it needs)
     */
    public CodeAction(int arguments) {
        this.arguments = arguments;
        this.argumentsLeft = arguments;
    }

    /**
     *
     * @return String that represents the code word that needs to be found in
     * the config.yml
     */
    protected abstract String getKeyword();

    /**
     * When the text within a pair of brackets is totally read, doAction is
     * called
     *
     * @param argument The text inside a bracket (is KeyWord found when
     * arguments are 0)
     */
    public abstract void doAction(String argument);

    String getCode() {
        return getKeyword().toLowerCase();
    }

    boolean hasArgumentsLeft() {
        return argumentsLeft != 0;
    }

    boolean isEnd(String argument) {
        doAction(argument);
        argumentsLeft--;
        if (!hasArgumentsLeft()) {
            if (!reset()) {
                argumentsLeft = arguments;
            }
            return true;
        } else {
            return false;
        }
    }

    void setBuilders(FancyMessage fm, Collection<? extends Player> players) {
        this.fm = fm;
    }

    boolean isEndChar(char c) {
        return c == '}';
    }

    /**
     *
     * @return The JSON lib handler
     */
    protected FancyMessage getJSONSaver() {
        return fm;
    }

    /**
     *
     * @return The players where this message is going to be send to.
     */
    protected Player[] getPlayers() {
        return players;
    }

    /**
     * With this function you can set the amount of arguments used in this
     * action code
     *
     * @param arguments How many arguments this action should have
     * @param reset If the remaining arguments should be reset to the given
     * amount
     */
    protected void setArguments(int arguments, boolean reset) {
        this.arguments = arguments;
        if (reset) {
            if (!reset()) {
                argumentsLeft = arguments;
            }
        }
    }

    /**
     * When an action has no arguments left the class won't make a new instance.
     * The number of arguments are automatically set back, but if there are any
     * more steps to take before it is reset, then you can specify them here.
     *
     * @return Return true if you don't want to reset argumentsLeft, default is
     * false.
     */
    protected boolean reset() {
        return false;
    }
}
