package org.jesgs.moonphase.ui;

import java.util.EventListener;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public interface DateTimeChangedListener extends EventListener {
    public void dateChanged(DateTimeChangedEvent dte);
}
