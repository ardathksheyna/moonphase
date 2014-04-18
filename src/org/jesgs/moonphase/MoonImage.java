package org.jesgs.moonphase;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class MoonImage implements MoonObserver {

    private MoonIcon moonIcon;

    @Override
    public void update() {

    }

    public MoonImage() {

    }

    public void setMoonIcon(MoonIcon icon) {
        moonIcon = icon;
    }

    public MoonIcon getMoonIcon() {
        return moonIcon;
    }

}
