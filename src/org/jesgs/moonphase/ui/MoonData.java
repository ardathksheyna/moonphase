package org.jesgs.moonphase.ui;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JLabel;
import org.jesgs.moonphase.MoonDataItem;
/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class MoonData extends JPanel {


    /**
     *
     */
    final private ArrayList<MoonDataItem> moonData;


    /**
     * Creates new form MoonData
     * @param moonData
     */
    public MoonData(ArrayList<MoonDataItem> moonData) {
        this.moonData = moonData;

        setupLabels();
        initComponents();
    }


    private void setupLabels()
    {
        // two labels (label/value)
        Iterator moonDataIt = moonData.iterator();

        int vPlacement = 10;

        while(moonDataIt.hasNext()) {
            Object element = moonDataIt.next();
            MoonDataItem data = (MoonDataItem) element;
            String label = data.getLabel(),
                   value = data.getValue();

            JLabel jlabelLabel = new JLabel();
            JLabel jlabelValue = new JLabel();

            jlabelLabel.setText(label);
            jlabelLabel.setBounds(10, vPlacement, 150, 20);
            jlabelValue.setText(value);
            jlabelValue.setBounds(150, vPlacement, 400, 20);

            add(jlabelLabel);
            add(jlabelValue);

            vPlacement = vPlacement + 20;
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
