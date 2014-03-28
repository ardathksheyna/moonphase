package org.jesgs.moonphase.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.event.InputMethodEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jesgs.moonphase.DrawMoonPhase;
import org.jesgs.moonphase.MoonIcon;
import org.jesgs.moonphase.MoonDataCollection;
import org.jesgs.moonphase.MoonFx;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class CurrentAgeFrame extends JFrame {

    private ArrayList<MoonDataCollection> moonData = new ArrayList<MoonDataCollection>();
    private CurrentAgeFrame self = new CurrentAgeFrame();

    /**
     * Creates new form CurrentAgeFrame
     */
    public CurrentAgeFrame() {
        initComponents();
        /* Create and display the form */

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLblCurrentDate = new javax.swing.JLabel();
        jLblMoonAge = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 100), new java.awt.Dimension(100, 100), new java.awt.Dimension(100, 100));
        jLabel1 = new javax.swing.JLabel();
        jSpinnerDate = new javax.swing.JSpinner();

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jFrame2Layout = new org.jdesktop.layout.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblCurrentDate.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jesgs/moonphase/ui/Bundle"); // NOI18N
        jLblCurrentDate.setText(bundle.getString("CurrentAgeFrame.jLblCurrentDate")); // NOI18N

        jLblMoonAge.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLblMoonAge.setText(bundle.getString("CurrentAgeFrame.jLblMoonAge")); // NOI18N

        jlblValueCurrentDate.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jlblValueCurrentDate.setText("jLabel3");

        jlblValueMoonAge.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jlblValueMoonAge.setText("jLabel4");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Choose Date and Time:");

        jSpinnerDate.setModel(new javax.swing.SpinnerDateModel());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSpinnerDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLblCurrentDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLblMoonAge))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jlblValueCurrentDate)
                            .add(jlblValueMoonAge))))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLblCurrentDate)
                            .add(jlblValueCurrentDate))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLblMoonAge)
                            .add(jlblValueMoonAge)))
                    .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jSpinnerDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jLblCurrentDate.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CurrentAgeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentAgeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentAgeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentAgeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    /**
     * Init graphics panel
     * @return void
     */
    final public CurrentAgeFrame initMoonPhaseGraphic() {

        jSpinnerDate.addChangeListener(new ChangeListener(){
            private Object lastValue;

            @Override
            public void stateChanged(ChangeEvent ce) {
                JSpinner spinner = (JSpinner) ce.getSource();

                if (lastValue != null && !spinner.getValue().equals(lastValue)) {
                   System.out.println(spinner.getValue());
                }

                lastValue = spinner.getValue();
            }

        });
        return this;
    }


    final public CurrentAgeFrame changeMoonData() {

        DrawMoonPhase jpMoonPhase = new DrawMoonPhase();
        MoonFx moonFx = new MoonFx();
        Date currentDate = (Date) jSpinnerDate.getValue();
        moonFx.setDate(currentDate);

        jpMoonPhase.setBounds(10, 10, 190, 190);

        getContentPane().add(jpMoonPhase);

        MoonIcon mIcon = new MoonIcon(new Rectangle(0, 0, 288, 288), moonFx);
        Image moonImage = this.iconToImage(mIcon);
        this.setIconImage(moonImage);

        return this;
    }

    /**
     * Convert icon to image before assigning
     *
     * @param icon
     * @return
     */
    private Image iconToImage(Icon icon) {
       if (icon instanceof ImageIcon) {
          return ((ImageIcon)icon).getImage();
       } else {
          int w = icon.getIconWidth(),
              h = icon.getIconHeight();

          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
          GraphicsDevice gd = ge.getDefaultScreenDevice();
          GraphicsConfiguration gc = gd.getDefaultConfiguration();
          BufferedImage image = gc.createCompatibleImage(w, h, Transparency.TRANSLUCENT);

          Graphics2D g = image.createGraphics();
          icon.paintIcon(null, g, 0, 0);
          g.dispose();

          return image;
       }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblCurrentDate;
    private javax.swing.JLabel jLblMoonAge;
    private javax.swing.JSpinner jSpinnerDate;
    public final javax.swing.JLabel jlblValueCurrentDate = new javax.swing.JLabel();
    public final javax.swing.JLabel jlblValueMoonAge = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
