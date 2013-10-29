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
        Point2D center = new Point2D.Double(centerX, centerY);
        Point2D upperLeft  = new Point2D.Double(2, 2);
        Ellipse2D darkFace = new Ellipse2D.Double();

        g2.setPaint(Color.BLACK);

        darkFace.setFrameFromCenter(center, upperLeft);
        g2.fill(darkFace);
    }

    /**
     * Calculate phase based on Julian Date
     *
     * @return
     */
    private double calculatePhase()
    {
        double ip = getAge() / MoonFx.SYNODIC_PERIOD;

        return ip;
    }
}
