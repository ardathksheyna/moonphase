package org.jesgs.moonphase.ui;

import java.awt.Dimension;
import java.awt.List;
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
import org.jesgs.moonphase.DrawMoonPhase;
import org.jesgs.moonphase.MoonDataCollection;
import org.jesgs.moonphase.MoonFx;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class CurrentAgeFrame extends JFrame {

    /**
     * Creates new form CurrentAgeFrame
     */
    public CurrentAgeFrame() {
        initMoonPhaseGraphic();
        initComponents();
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLblCurrentDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLblMoonAge))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblValueCurrentDate)
                    .add(jlblValueMoonAge))
                .addContainerGap(225, Short.MAX_VALUE))
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
                .addContainerGap(204, Short.MAX_VALUE))
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                CurrentAgeFrame ageFrame = new CurrentAgeFrame();

                ageFrame.initMoonPhaseGraphic();
                ageFrame.setVisible(true);

            }
        });
    }

    final public void initMoonPhaseGraphic() {
        DrawMoonPhase jpMoonPhase = new DrawMoonPhase();

        jpMoonPhase.setMoonFx(moonfx);
        jpMoonPhase.setBounds(10, 10, 190, 190);

        setupMoonData();
        getContentPane().add(jpMoonPhase);
    }

    private void setupMoonData() {
        Calendar cal = Calendar.getInstance();
        String longDateFormat = ResourceBundle.getBundle("org/jesgs/moonphase/ui/Bundle").getString("CurrentAgeFrame.currentDateLongFormat");
        SimpleDateFormat sdf  = new SimpleDateFormat(longDateFormat);
        DecimalFormat df      = new DecimalFormat();
        ArrayList moonData = new ArrayList<MoonDataCollection>();
        double synodicAge = moonfx.getSynodicPhase(),
               julianDate = moonfx.getJulianDate();
        String phaseName = MoonPhaseNames.getPhaseName(synodicAge);

        df.applyLocalizedPattern("###,###,### miles");

        jlblValueCurrentDate.setText(sdf.format(cal.getTime()));
        jlblValueMoonAge.setText(phaseName);

        // output moon data
        SimpleDateFormat sdf2 = (SimpleDateFormat) sdf.clone();

        sdf.applyLocalizedPattern("k:mm a z");
        sdf2.applyLocalizedPattern("k:mm a z");
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));

        moonData.add(new MoonDataCollection("Local Time", sdf.format(cal.getTime())));
        moonData.add(new MoonDataCollection("Universal Time: ", sdf2.format(cal.getTime())));
        moonData.add(new MoonDataCollection("Julian Date: ", Double.toString(julianDate)));
        moonData.add(new MoonDataCollection("Moon's Age: ", Double.toString(synodicAge) + " days since New Moon"));
        moonData.add(new MoonDataCollection("Angle: ", Double.toString(moonfx.getPhaseAngle(synodicAge))));
        moonData.add(new MoonDataCollection("Percent Illuminated: ", Math.round(moonfx.getIlluminatedRatio(synodicAge) * 100) + "%"));
        moonData.add(new MoonDataCollection("Distance (mi): ", df.format(Math.round(moonfx.getDistanceInEarthRadii() * MoonFx.EARTH_RADIUS_MI))));

    }

    private MoonFx moonfx = new MoonFx();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLblCurrentDate;
    private javax.swing.JLabel jLblMoonAge;
    public final javax.swing.JLabel jlblValueCurrentDate = new javax.swing.JLabel();
    public final javax.swing.JLabel jlblValueMoonAge = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
