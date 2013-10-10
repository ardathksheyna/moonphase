package org.jesgs.moonphase.ui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class ButtonCommands {
    public static final int FRAME_MOON_AGE = 0;
    public static final int FRAME_CALENDAR = 1;
    public static final int FRAME_CHART    = 2;

    private static Map<String, Integer> commands = new HashMap<String, Integer>();

    public ButtonCommands() {
        commands.put("getMoonAge", FRAME_MOON_AGE);
        commands.put("getCalendar", FRAME_CALENDAR);
        commands.put("getChart", FRAME_CHART);
    }

    public int getCommandId(String commandId) {
        return commands.get(commandId);
    }
}
