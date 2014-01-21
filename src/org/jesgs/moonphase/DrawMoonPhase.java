package org.jesgs.moonphase;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
final public class DrawMoonPhase extends JComponent {

    private MoonIcon moonIcon;

    public DrawMoonPhase() {}

    /**
     * Set Preferred panel size
     * @param dmnsn
     */
    @Override
    public final void setPreferredSize(Dimension dmnsn) {
        super.setPreferredSize(dmnsn);
    }

    /**
     * Create moon icon
     *
     * @param graphic
     */
    @Override
    protected void paintComponent(Graphics graphic) {
        moonIcon = new MoonIcon(getBounds(), new MoonFx());
        moonIcon.paintIcon(this, graphic, 0, 0);
    }
}
