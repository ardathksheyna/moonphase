package org.jesgs.moonphase.ui;

import java.util.ResourceBundle;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public abstract class MoonPhaseNames extends Object {
    /**
     * New Moon
     */
    public static final int AGE_NEW_MOON = 0;

    /**
     * First Quarter Moon
     */
    public static final int AGE_FIRST_QUARTER_MOON = 7;

    /**
     * Full Moon
     */
    public static final int AGE_FULL_MOON = 14;

    /**
     * Last Quarter Moon
     */
    public static final int AGE_LAST_QUARTER_MOON = 21;

    public static final String NEW_MOON        = "NewMoon";
    public static final String WAXING_CRESCENT = "WaxingCrescent";
    public static final String FIRST_QUARTER   = "FirstQuarter";
    public static final String WAXING_GIBBOUS  = "WaxingGibbous";
    public static final String FULL_MOON       = "FullMoon";
    public static final String WANING_GIBBOUS  = "WaningGibbous";
    public static final String LAST_QUARTER    = "LastQuarter";
    public static final String WANING_CRESCENT = "WaningCrescent";

    public static String getPhaseName(double synodicAge) {
        String phaseName;

        if (synodicAge >= AGE_NEW_MOON && synodicAge < 1) {
            // New Moon
            phaseName = NEW_MOON;
        } else if (synodicAge >= 1 && synodicAge < AGE_FIRST_QUARTER_MOON) {
            // Waxing Crescent
            phaseName = WAXING_CRESCENT;
        } else if (synodicAge >= AGE_FIRST_QUARTER_MOON && synodicAge < (AGE_FIRST_QUARTER_MOON + 1)) {
            // First Quarter Moon
            phaseName = FIRST_QUARTER;
        } else if (synodicAge > (AGE_FIRST_QUARTER_MOON + 1) && synodicAge < AGE_FULL_MOON) {
            // Waxing Gibbous
            phaseName = WAXING_GIBBOUS;
        } else if (synodicAge >= AGE_FULL_MOON && synodicAge < (AGE_FULL_MOON + 1)) {
            // Full Moon
            phaseName = FULL_MOON;
        } else if (synodicAge >= (AGE_FULL_MOON + 1) && synodicAge < AGE_LAST_QUARTER_MOON) {
            // Waning Gibbous
            phaseName = WANING_GIBBOUS;
        } else if (synodicAge >= AGE_LAST_QUARTER_MOON && synodicAge < (AGE_LAST_QUARTER_MOON + 1)) {
            // Last Quarter Moon
            phaseName = LAST_QUARTER;
        } else {
            // Waning Crescent
            phaseName = WANING_CRESCENT;
        }

        return ResourceBundle.getBundle("org/jesgs/moonphase/ui/Bundle").getString("MoonPhase." + phaseName);
    }
}
