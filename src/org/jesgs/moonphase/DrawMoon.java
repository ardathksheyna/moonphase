package org.jesgs.moonphase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
final public class DrawMoon extends JComponent implements Moon {
    /**
     * Moon's age
     * Default to New Moon
     */
    protected double age = 0;

    private Graphics2D g2;

    protected MoonFx moonfx;

    public DrawMoon() {
        setPreferredSize(new Dimension(16, 16));
    }

    /**
     * Get age of Moon
     *
     * @return double
     */
    @Override
    public double getAge() {
        return this.age;
    }

    /**
     * Set the age of the moon
     *
     * @param age Moon's age
     */
    @Override
    public void setAge(double age) {
        this.age = age;
    }

    public MoonFx getMoonFx() {
        return this.moonfx;
    }

    public void setMoonFx(MoonFx moonFx) {
        this.moonfx = moonFx;
    }

    /**
     * Get preferred panel size
     * @return Dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
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

        g2     = (Graphics2D) graphic;
        Dimension imgSize = getPreferredSize();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height     = (int) imgSize.getHeight();
        int width      = (int) imgSize.getWidth();
        double centerX = width / 2;
        double centerY = height / 2;
        double moonAge = getAge();

        double phaseAngle = moonfx.getPhaseAngle(moonAge),
               illuminationRatio = moonfx.getIlluminatedRatio(moonAge);

        g2.setPaint(Color.WHITE);
        g2.fill( new Ellipse2D.Double(0, 0, width, height) );

        g2.setPaint(Color.BLACK);
        int[] xPoints = new int[360];
        int[] yPoints = new int[360];

        for ( int i=0; i < 180; i++ ) {

            double angle = Math.toRadians(i - 90);
            int x1 = (int) ( Math.cos( angle ) * centerX );
            int y1 = (int) ( Math.sin( angle ) * centerY );
            int width1 = x1 * 2;
            int x2 = (int) ( width1 * illuminationRatio );

            if ( phaseAngle < 180 ) {
                x1 = (int)centerX - x1;
                x2 = x1 + (width1 - x2);
            } else { // waning
                x1 = (int)centerX + x1;
                x2 = x1 - (width1 - x2);
            }

            y1 = (int)centerY + y1;

            xPoints[i] = x1;
            yPoints[i] = y1;

            xPoints[xPoints.length-(i+1)] = x2;
            yPoints[yPoints.length-(i+1)] = y1;

        }

        g2.fillPolygon(xPoints, yPoints, xPoints.length);

    }
}
