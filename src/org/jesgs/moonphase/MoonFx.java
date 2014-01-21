/**
 * (c) 2013 Jess Green / JesGs Development
 *
 * Licensed under the GNU General Public License, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jesgs.moonphase;

import java.util.Calendar;
import java.util.Date;
import java.lang.Math;

/**
 * MoonFx Class
 *
 * @author Jess Green <jgreen at psy-dreamer.com>
 */
public class MoonFx {

    /**
     * Pi in radians
     */
    public static final double PI_RADIANS = 2 * Math.PI;

    /**
     * Earth's radius in miles
     */
    public static final long EARTH_RADIUS_MI = 3959;

    /**
     * Day constant
     */
    public static final long ONE_DAY = 86400000;

    /**
     * Moon's Synodic Period (Days)
     */
    public static final double SYNODIC_PERIOD = 29.530589;

    /**
     * Date to check moon properties
     */
    protected Date moonDate;

    /**
     * Set the date
     *
     * @param date Date to process
     * @return
     */
    public MoonFx setDate(Date date) {
        this.moonDate = date;

        return this;
    }

    /**
     * Get the date
     *
     * @return Calendar
     */
    public Date getDate() {
        if (moonDate == null) {
            moonDate = Calendar.getInstance().getTime();
        }

        return this.moonDate;
    }

    /**
     * Get current synodic phase of the moon
     *
     * @return Moon's age in days (number of days from New Moon)
     */
    public double getSynodicPhase() {
        double moonsAge = _normalize((this.getJulianDate() - 2451550.1) / MoonFx.SYNODIC_PERIOD) * MoonFx.SYNODIC_PERIOD;

        return moonsAge;
    }

    /**
     * Distance from anomalistic phase
     *
     * @return Distance in Earth radii
     */
    public double getDistanceInEarthRadii() {
        double distanceInRadians = _normalize((getJulianDate() - 2451562.2) / 27.55454988) * MoonFx.PI_RADIANS;
        double synodicPhaseinRadians = getSynodicPhase() * MoonFx.PI_RADIANS;

        double distance = 60.4 - 3.3 * Math.cos(distanceInRadians) - .6
                        * Math.cos(2 * synodicPhaseinRadians - distanceInRadians) - .5
                        * Math.cos(2 * synodicPhaseinRadians);

        return distance;
    }

    /**
     * Get position of Moon
     *
     * @return Moon's ecliptic latitude
     */
    public double getEclipticLatitude() {
        double value = _normalize((getJulianDate() - 2451565.2) / 27.212220817);
        double eclipticLatitude = 5.1 * Math.sin(value * MoonFx.PI_RADIANS);

        return eclipticLatitude;
    }

    /**
     * Get position of Moon
     *
     * @return Moon's ecliptic longitude
     */
    public double getEclipticLongitude() {
        double synodicPhase          = getSynodicPhase(),
               synodicPhaseInRadians = synodicPhase * MoonFx.PI_RADIANS,
               distanceInRadians     = _normalize((getJulianDate() - 2451562.2) / 27.55454988) * MoonFx.PI_RADIANS,
               value                 = _normalize((getJulianDate() - 2451555.8) / 27.321582241),
               eclipticLongitude = 360 * value + 6.3 + Math.sin(distanceInRadians) + 1.3
                                        * Math.sin(2 * synodicPhaseInRadians - distanceInRadians)
                                        + 0.7 * Math.sin(2 * synodicPhaseInRadians);

        return eclipticLongitude;
    }

    /**
     * Get the Julian Date for the date specified by setDate()
     *
     * @return single
     */
    public double getJulianDate() {

        Calendar gregorianDateCalendar = Calendar.getInstance();
        long timeZoneOffset = gregorianDateCalendar.getTimeZone().getRawOffset();
        gregorianDateCalendar.setTime(new Date(getDate().getTime() - timeZoneOffset));

        int month = gregorianDateCalendar.get(Calendar.MONTH) + 1,
            day   = gregorianDateCalendar.get(Calendar.DAY_OF_MONTH),
            year  = gregorianDateCalendar.get(Calendar.YEAR),
            hour  = gregorianDateCalendar.get(Calendar.HOUR_OF_DAY);

        double minute = (double)gregorianDateCalendar.get(Calendar.MINUTE);

        double ut = hour + (minute / 60);

        double julianDate = 367 * year - (7 * (year + (month + 9) / 12 ) ) / 4 + (275 * month) / 9
                          + day + 1721013.5 + (ut / 24)
                          - 0.5 * Math.signum(100 * year + month - 190002.5) + 0.5;

        return julianDate;
    }

    /**
     * Return the approximate phase angle of the moon
     *
     * @param synodicAge Current age of moon
     * @return
     */
    public double getPhaseAngle(double synodicAge) {
        double phaseAngle = synodicAge * 13;

        if (phaseAngle > 360) {
            phaseAngle = phaseAngle - 360;
        }

        return Math.abs(phaseAngle);
    }

    /**
     * Get Illuminated ratio of moon according to synodic age
     *
     * @param synodicAge
     * @return
     */
    public double getIlluminatedRatio(double synodicAge) {
        double phaseAngle = getPhaseAngle(synodicAge),
               ofCosine   = (1 - Math.cos(Math.toRadians(phaseAngle))),
               ratioOfIllumination = ofCosine * 0.5;

        return ratioOfIllumination;

    }

    /**
     * Normalize values
     *
     * @param value
     * @return
     */
    private double _normalize(double value) {

        value = value - (int)value;

        if (value < 0){
            value = value + 1;
        }

        return value;
    }
}