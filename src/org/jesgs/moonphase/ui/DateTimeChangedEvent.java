package org.jesgs.moonphase.ui;

import java.util.Date;
import java.util.EventObject;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class DateTimeChangedEvent extends EventObject {

    private Date date;

    public DateTimeChangedEvent(Object source, Date date) {
        super(source);

        this.date = date;
    }
}
