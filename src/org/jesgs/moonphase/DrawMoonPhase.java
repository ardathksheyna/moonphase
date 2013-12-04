package org.jesgs.moonphase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.*;
import javax.swing.JComponent;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
final public class DrawMoonPhase extends JComponent {

    private Graphics2D g2;

    protected MoonFx moonfx;

    public DrawMoonPhase() {}

    public MoonFx getMoonFx() {
        return this.moonfx;
    }


    public void setMoonFx(MoonFx moonFx) {
        this.moonfx = moonFx;
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
        super.paintComponent(graphic);

        Rectangle bounds = getBounds();
        Dimension imgSize = new Dimension(
            (int)bounds.getWidth(),
            (int)bounds.getHeight()
        );
        setPreferredSize(imgSize);

        g2 = (Graphics2D) graphic;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int height = (int) imgSize.getHeight(),
            width  = (int) imgSize.getWidth();

        double centerX = width / 2,
               centerY = height / 2,
               phaseAngle = moonfx.getPhaseAngle(moonfx.getSynodicPhase()),
               illuminationRatio = moonfx.getIlluminatedRatio(moonfx.getSynodicPhase());

        // draw moon's dark face
        g2.setPaint(Color.WHITE);
        g2.fill(new Ellipse2D.Double(0, 0, width, height));

        // draw illuminated portion
        int[] xp = new int[360];
        int[] yp = new int[360];

        g2.setPaint(Color.BLACK);
        for (int a=0; a < 180; a++) {

            double angle = Math.toRadians(a-90);
            int x1 = (int) Math.ceil( Math.cos( angle ) * centerX ),
                y1 = (int) Math.ceil( Math.sin( angle ) * centerY ),
                moonWidth = x1 * 2,
                x2 = (int) Math.floor(moonWidth * illuminationRatio);

            if ( phaseAngle < 180 ) {
                x1 = (int) centerX - x1;
                x2 = x1 + (moonWidth - x2);
            } else { // waning
                x1 = (int) centerX + x1;
                x2 = x1 - (moonWidth - x2);
            }

            y1 = (int) centerY + y1;

            xp[a] = x1;
            yp[a] = y1;

            xp[xp.length-(a+1)] = x2;
            yp[yp.length-(a+1)] = y1;

        }

        g2.fillPolygon(xp, yp, xp.length);

    }
}
