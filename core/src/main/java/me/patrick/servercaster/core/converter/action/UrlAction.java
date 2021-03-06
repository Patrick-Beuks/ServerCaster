package me.patrick.servercaster.core.converter.action;

import me.patrick.servercaster.core.converter.CodeAction;

/**
 *
 * @author Patrick Beuks
 */
public class UrlAction extends CodeAction {

    public UrlAction() {
        super(1);
    }

    @Override
    protected String getKeyword() {
        return "URL";
    }

    @Override
    public void doAction(String argument) {
        getJSONSaver().link(argument.substring(1, argument.length() - 1));
    }

}
