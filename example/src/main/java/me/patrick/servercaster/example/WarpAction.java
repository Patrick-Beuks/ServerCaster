package me.patrick.servercaster.example;

import me.patrick.servercaster.core.converter.CodeAction;

/**
 *
 * @author Patrick Beuks
 */
public class WarpAction extends CodeAction {

    public WarpAction() {
        super(0); //amount of arguments this converter needs
    }

    @Override
    protected String getKeyword() {
        return "WARP";
    }

    @Override
    public void doAction(String argument) {
        getJSONSaver().command("/warp " + argument);
    }

}
