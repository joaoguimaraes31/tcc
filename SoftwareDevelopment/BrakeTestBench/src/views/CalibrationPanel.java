/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author joao
 */
public class CalibrationPanel extends javax.swing.JPanel {

    /**
     * Creates new form CalibrationPanel
     */
    public CalibrationPanel() {
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

        jPanel5 = new javax.swing.JPanel();
        measurementsTabbedPanel = new javax.swing.JTabbedPane();
        therm1Panel = new javax.swing.JPanel();
        voltTemp2ChartLabel = new javax.swing.JLabel();
        measureTemp2ChartLabel = new javax.swing.JLabel();
        therm2Panel = new javax.swing.JPanel();
        voltLoad1ChartLabel = new javax.swing.JLabel();
        measureLoad1ChartLabel = new javax.swing.JLabel();
        loadCell1Panel = new javax.swing.JPanel();
        voltLoad2ChartLabel = new javax.swing.JLabel();
        measureLoad2ChartLabel = new javax.swing.JLabel();
        loadCell2Panel = new javax.swing.JPanel();
        voltCkpChartLabel = new javax.swing.JLabel();
        measureCkpChartLabel = new javax.swing.JLabel();
        ckpPanel = new javax.swing.JPanel();
        voltTemp1ChartLabel = new javax.swing.JLabel();
        measureTemp1ChartLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        factorSpinner = new javax.swing.JSpinner();
        offsetSpinner = new javax.swing.JSpinner();
        updateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        serialPortLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        loadedSettingLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMinimumSize(new java.awt.Dimension(600, 569));
        setPreferredSize(new java.awt.Dimension(600, 569));

        voltTemp2ChartLabel.setText("jLabel1");

        measureTemp2ChartLabel.setText("jLabel1");

        javax.swing.GroupLayout therm1PanelLayout = new javax.swing.GroupLayout(therm1Panel);
        therm1Panel.setLayout(therm1PanelLayout);
        therm1PanelLayout.setHorizontalGroup(
            therm1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therm1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(therm1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltTemp2ChartLabel)
                    .addComponent(measureTemp2ChartLabel))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        therm1PanelLayout.setVerticalGroup(
            therm1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therm1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltTemp2ChartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measureTemp2ChartLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        measurementsTabbedPanel.addTab("Thermocouple 1", therm1Panel);

        voltLoad1ChartLabel.setText("jLabel1");

        measureLoad1ChartLabel.setText("jLabel1");

        javax.swing.GroupLayout therm2PanelLayout = new javax.swing.GroupLayout(therm2Panel);
        therm2Panel.setLayout(therm2PanelLayout);
        therm2PanelLayout.setHorizontalGroup(
            therm2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therm2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(therm2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltLoad1ChartLabel)
                    .addComponent(measureLoad1ChartLabel))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        therm2PanelLayout.setVerticalGroup(
            therm2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(therm2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltLoad1ChartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measureLoad1ChartLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        measurementsTabbedPanel.addTab("ThermoCouple 2", therm2Panel);

        voltLoad2ChartLabel.setText("jLabel1");

        measureLoad2ChartLabel.setText("jLabel1");

        javax.swing.GroupLayout loadCell1PanelLayout = new javax.swing.GroupLayout(loadCell1Panel);
        loadCell1Panel.setLayout(loadCell1PanelLayout);
        loadCell1PanelLayout.setHorizontalGroup(
            loadCell1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCell1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadCell1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltLoad2ChartLabel)
                    .addComponent(measureLoad2ChartLabel))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        loadCell1PanelLayout.setVerticalGroup(
            loadCell1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCell1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltLoad2ChartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measureLoad2ChartLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        measurementsTabbedPanel.addTab("Load Cell 1", loadCell1Panel);

        voltCkpChartLabel.setText("jLabel1");

        measureCkpChartLabel.setText("jLabel1");

        javax.swing.GroupLayout loadCell2PanelLayout = new javax.swing.GroupLayout(loadCell2Panel);
        loadCell2Panel.setLayout(loadCell2PanelLayout);
        loadCell2PanelLayout.setHorizontalGroup(
            loadCell2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCell2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadCell2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltCkpChartLabel)
                    .addComponent(measureCkpChartLabel))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        loadCell2PanelLayout.setVerticalGroup(
            loadCell2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCell2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltCkpChartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measureCkpChartLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        measurementsTabbedPanel.addTab("Load Cell 2", loadCell2Panel);

        voltTemp1ChartLabel.setText("jLabel1");

        measureTemp1ChartLabel.setText("jLabel1");

        javax.swing.GroupLayout ckpPanelLayout = new javax.swing.GroupLayout(ckpPanel);
        ckpPanel.setLayout(ckpPanelLayout);
        ckpPanelLayout.setHorizontalGroup(
            ckpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ckpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ckpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltTemp1ChartLabel)
                    .addComponent(measureTemp1ChartLabel))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        ckpPanelLayout.setVerticalGroup(
            ckpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ckpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltTemp1ChartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measureTemp1ChartLabel)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        measurementsTabbedPanel.addTab("CKP", ckpPanel);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calibration Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        startButton.setText("Start Calibration");

        stopButton.setText("Stop Calibration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calibration Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel1.setText("Conv. Factor:");

        jLabel2.setText("Offset:");

        updateButton.setText("Update");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(factorSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(offsetSpinner))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(factorSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(offsetSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serial Port", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel3.setText("Connected to Port:");

        serialPortLabel.setText("null");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(serialPortLabel)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serialPortLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loaded Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        loadedSettingLabel.setText("none");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadedSettingLabel)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadedSettingLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(measurementsTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(measurementsTabbedPanel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ckpPanel;
    private javax.swing.JSpinner factorSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel loadCell1Panel;
    private javax.swing.JPanel loadCell2Panel;
    private javax.swing.JLabel loadedSettingLabel;
    private javax.swing.JLabel measureCkpChartLabel;
    private javax.swing.JLabel measureLoad1ChartLabel;
    private javax.swing.JLabel measureLoad2ChartLabel;
    private javax.swing.JLabel measureTemp1ChartLabel;
    private javax.swing.JLabel measureTemp2ChartLabel;
    private javax.swing.JTabbedPane measurementsTabbedPanel;
    private javax.swing.JSpinner offsetSpinner;
    private javax.swing.JLabel serialPortLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton startCalibrationBT;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton temp1StopCalibrationButton;
    private javax.swing.JPanel therm1Panel;
    private javax.swing.JPanel therm2Panel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel voltCkpChartLabel;
    private javax.swing.JLabel voltLoad1ChartLabel;
    private javax.swing.JLabel voltLoad2ChartLabel;
    private javax.swing.JLabel voltTemp1ChartLabel;
    private javax.swing.JLabel voltTemp2ChartLabel;
    // End of variables declaration//GEN-END:variables
}
