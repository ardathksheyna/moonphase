package org.jesgs.moonphase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class DrawMoon extends Component {
    /**
     * Moon's age
     * Default to New Moon
     */
    protected int age = 0;

    /**
     * Size of Moon icon
     * Default to 16x16 pixels
     */
    protected Dimension iconSize = null;

    public DrawMoon() {
        if (iconSize == null) {
            iconSize = new Dimension(16, 16);
        }
    }

    /**
     * Get age of Moon
     *
     * @return int
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Set the age of the moon
     *
     * @param age Moon's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the image size
     *
     * @return Dimension
     */
    public Dimension getIconSize() {
        return this.iconSize;
    }

    /**
     * Set the image size
     * @param size
     */
    public void setIconSize(int size) {
        this.iconSize = new Dimension(size, size);
    }

    /**
     * Create moon icon
     *
     * @param graphic
     */
    public void drawMoon(Graphics graphic) {
        Graphics2D g2     = (Graphics2D) graphic;
        Dimension imgSize = getIconSize();
        int height        = (int) imgSize.getHeight() - 2;
        int width         = (int) imgSize.getWidth() - 2;
        int x             = (int) imgSize.getHeight() / 2;
        int y             = (int) imgSize.getWidth() / 2;
        int moonAge       = getAge();

        g2.setColor(Color.WHITE);
        g2.drawOval(x, y, height, width);
        g2.fillOval(x, y, height, width);
    }
}
