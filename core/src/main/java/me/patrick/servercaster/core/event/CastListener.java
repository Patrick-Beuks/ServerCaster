package me.patrick.servercaster.core.event;

/**
 *
 * @author Patrick Beuks
 */
public interface CastListener {

    public void castHandler(PreCastEvent e);

    public void castPlayerHandler(PreCastPlayerEvent e);

}
