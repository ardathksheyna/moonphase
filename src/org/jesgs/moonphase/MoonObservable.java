package org.jesgs.moonphase;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public interface MoonObservable {
    public void registerObserver(MoonObserver observer);

    public void removeObserver(MoonObserver observer);

    public void notifyObservers();
}
