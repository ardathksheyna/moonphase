package org.jesgs.moonphase;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public interface Moon {
    
    /**
     * New Moon
     */
    public static final int NEW_MOON = 0;
    
    /**
     * First Quarter Moon
     */
    public static final int FIRST_QUARTER_MOON = 7;
    
    /**
     * Full Moon
     */
    public static final int FULL_MOON = 14;
    
    /**
     * Last Quarter Moon
     */
    public static final int LAST_QUARTER_MOON = 21;
    
    void setAge(double moonAge);
    double getAge();
}
