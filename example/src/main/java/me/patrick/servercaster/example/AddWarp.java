package me.patrick.servercaster.example;

import me.patrick.servercaster.core.converter.CodeConverter;

/**
 *
 * @author Patrick Beuks
 */
public class AddWarp {

    public AddWarp() {
        CodeConverter.addCodeAction(new WarpAction());
    }
}
