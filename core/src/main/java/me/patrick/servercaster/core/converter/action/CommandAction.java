package me.patrick.servercaster.core.converter.action;

import me.patrick.servercaster.core.converter.CodeAction;

/**
 *
 * @author Patrick Beuks
 */
public class CommandAction extends CodeAction {

    public CommandAction() {
        super(1);
    }

    @Override
    protected String getKeyword() {
        return "COMMAND";
    }

    @Override
    public void doAction(String argument) {
        getJSONSaver().command("/" + argument);
    }
}
