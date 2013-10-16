package org.jesgs.moonphase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

        int height        = (int) imgSize.getHeight();
        int width         = (int) imgSize.getWidth();
        double moonAge       = getAge();

        // Moon background
        g2.setPaint(Color.BLACK);
        g2.fill( new Ellipse2D.Double(0, 0, width, height) );

        // determine phase
//        Point2D leftEdge = new Point2D.Float(0, 2);
//        Point2D rightEdge = new Point2D.Float(width - 10, 2);

        // determine age to width interval
        double ageInterval = width / moonAge;

        g2.setPaint(Color.WHITE);
        g2.fill( new Ellipse2D.Double( 2, 2, width - 4, height - 4) );
        // Top Right
//        g2.fill( new Arc2D.Float(2, 2, width - 4, height - 4, 0, 90, Arc2D.PIE));
//        // Bottom Right
//        g2.fill( new Arc2D.Float(2, 2, width - 4, height - 4, 0, -90, Arc2D.PIE));

        g2.setPaint(Color.BLACK);
        g2.fill( new Arc2D.Float(2, 2, width - 10, height - 4, 0, 180, Arc2D.PIE));
//        g2.fill( new Arc2D.Float(2, 2, width - 10, height - 4, 0, -90, Arc2D.PIE));
    }
}
