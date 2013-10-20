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
        double moonAge = getAge();
        
        // Moon background
//        g2.setPaint(Color.BLACK);
//        Ellipse2D moonNotIlluminated = new Ellipse2D.Double(0, 0, width, height);
//
//        g2.fill( moonNotIlluminated );
        
        int xPos;
        int xPos1;
        int xPos2;
        int rPos;
        
        double Phase = calculatePhase();
        int maxYPos = (int)Math.floor(height / 2);
        
        for (int yPos=0; yPos<= maxYPos; yPos++) {
            xPos = (int)(Math.sqrt(maxYPos*maxYPos - yPos*yPos));
            
            g2.setPaint(Color.BLACK);
            
            // Draw darkness part of the moon        
            Point pB1 = new Point((maxYPos-xPos), (yPos+maxYPos));
            Point pB2 = new Point((xPos+maxYPos), (yPos+maxYPos));
            Point pB3 = new Point((maxYPos-xPos), (maxYPos-yPos));
            Point pB4 = new Point((xPos+maxYPos), (maxYPos-yPos));

            g2.drawLine(pB1.x, pB1.y, pB2.x, pB2.y);
            g2.drawLine(pB3.x, pB3.y, pB4.x, pB4.y);
            
            // Determine the edges of the lighted part of the moon       
            rPos = 2 * xPos;
            if (Phase < 0.5) {
                xPos1 = -xPos;
                xPos2 = (int)(rPos - 2 * Phase * rPos - xPos);
            } else {
               xPos1 = xPos;
               xPos2 = (int)(xPos - 2 * Phase * rPos + rPos);
            }

            g2.setPaint(Color.WHITE);
            
            // Draw the lighted part of the moon       
            Point pW1 = new Point((xPos1+maxYPos), (maxYPos-yPos));
            Point pW2 = new Point((xPos2+maxYPos), (maxYPos-yPos));
            Point pW3 = new Point((xPos1+maxYPos), (yPos+maxYPos));
            Point pW4 = new Point((xPos2+maxYPos), (yPos+maxYPos));
           
            g2.drawLine(pW1.x, pW1.y, pW2.x, pW2.y);
            g2.drawLine(pW3.x, pW3.y, pW4.x, pW4.y);            
        }
    }
    
    /**
     * Calculate phase based on Julian Date
     * 
     * @return 
     */
    private double calculatePhase()
    { 
        double ip = getAge() / MoonFx.SYNODIC_PERIOD;
        System.out.println(getAge());
        System.out.println(ip);
        System.out.println("----");
        return ip;
    }    
}
