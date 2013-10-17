package org.jesgs.moonphase;

/**
 * Enum class containing moon phase values
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public enum MoonPhases {
    /**
     * Approximate synodic age of New Moon
     */
    NEW_MOON(0),

    /**
     * Approximate synodic age of First Quarter
     */
    FIRST_QUARTER(7),

    /**
     * Approximate synodic age of Full Moon
     */
    FULL_MOON(14),

    /**
     * Approximate synodic age of Last Quarter
     */
    LAST_QUARTER(21),

    /**
     * Approximate synodic age of Waning Moon
     */
    WANING(28);

    private int value;
    private MoonPhases(int value) {
        this.value = value;
    }
}
