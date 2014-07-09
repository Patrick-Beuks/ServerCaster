package me.patrick.servercaster.core.converter.action;

import me.patrick.servercaster.core.converter.CodeAction;

/**
 *
 * @author Patrick Beuks
 */
public class SuggestAction extends CodeAction {

    public SuggestAction() {
        super(1);
    }

    @Override
    protected String getKeyword() {
        return "SUGGEST";
    }

    @Override
    public void doAction(String argument) {
        getJSONSaver().suggest(argument);
    }
}
