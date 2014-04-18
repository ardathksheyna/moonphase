package org.jesgs.moonphase;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class MoonPhasePanel extends JComponent implements MoonObserver {

    private MoonIcon moonIcon;

    public MoonPhasePanel() {}

    public void setGraphic(MoonIcon icon) {
        moonIcon = icon;
    }

    protected MoonIcon getGraphic() {
        return moonIcon;
    }

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
        moonIcon.paintIcon(this, graphic, 0, 0);
    }

    /**
     * Update the graphic when notified
     */
    @Override
    public void update() {
        repaint();
    }
}
