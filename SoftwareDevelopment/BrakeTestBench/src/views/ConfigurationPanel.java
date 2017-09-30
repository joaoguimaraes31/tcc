package views;

import controllers.ConfigurationController;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import models.ConfigurationModel;

public class ConfigurationPanel extends javax.swing.JPanel {

    //MVC
    private ConfigurationController controller;
    private ConfigurationModel model;
            
    public ConfigurationPanel() {
        initComponents();
    }
    
    public ConfigurationPanel(ConfigurationController controller){
        this.controller=controller;
        this.model=controller.getModel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testConfigurationPanel = new javax.swing.JPanel();
        numberOfCyclesSpinner = new javax.swing.JSpinner(model.getNUMBER_OF_CYCLES_SPINNER_MODEL());
        upperLimitSpinner = new javax.swing.JSpinner(model.getUPPER_LIMITS_SPINNER_MODEL());
        waitUpperTimeSpinner = new javax.swing.JSpinner(model.getWAIT_UPPER_SPINNER_MODEL());
        cyclesTimeSpinner = new javax.swing.JSpinner(model.getCYCLES_TIME_SPINNER_MODEL());
        lowerLimitSpinner = new javax.swing.JSpinner(model.getLOWER_LIMITS_SPINNER_MODEL());
        waitLowerTimeSpinner = new javax.swing.JSpinner(model.getLOWER_LIMITS_SPINNER_MODEL());
        numberOfCyclesFLabel = new javax.swing.JLabel();
        upperLimitFLabel = new javax.swing.JLabel();
        waitUpperTimeFLabel = new javax.swing.JLabel();
        waitLowerTimeFLabel = new javax.swing.JLabel();
        lowerLimitFLabel = new javax.swing.JLabel();
        cyclesTimeFLabel = new javax.swing.JLabel();
        configurationDefaultButton = new javax.swing.JButton();
        configurationFileFLabel = new javax.swing.JLabel();
        regulationFileLabel1 = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        directoryFLabel = new javax.swing.JLabel();
        directoryLabel = new javax.swing.JLabel();
        chooseOutputLabel = new javax.swing.JButton();
        regulationPanel = new javax.swing.JPanel();
        testRegulationFLabel = new javax.swing.JLabel();
        regulationFileLabel = new javax.swing.JLabel();
        chooseRegulationButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(626, 569));

        testConfigurationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        numberOfCyclesFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        numberOfCyclesFLabel.setText("Number of Cycles:");

        upperLimitFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        upperLimitFLabel.setText("Upper limit (kph)");

        waitUpperTimeFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        waitUpperTimeFLabel.setText("Wait time (s)");

        waitLowerTimeFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        waitLowerTimeFLabel.setText("Wait time (s)");

        lowerLimitFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        lowerLimitFLabel.setText("Lower limit (kph)");

        cyclesTimeFLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cyclesTimeFLabel.setText("Time between cycles (ms)");

        configurationDefaultButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        configurationDefaultButton.setText("Default");

        configurationFileFLabel.setText("Configuration File:");

        regulationFileLabel1.setBackground(java.awt.Color.white);
        regulationFileLabel1.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        regulationFileLabel1.setText("none");
        regulationFileLabel1.setOpaque(true);

        javax.swing.GroupLayout testConfigurationPanelLayout = new javax.swing.GroupLayout(testConfigurationPanel);
        testConfigurationPanel.setLayout(testConfigurationPanelLayout);
        testConfigurationPanelLayout.setHorizontalGroup(
            testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigurationPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(configurationDefaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(testConfigurationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigurationPanelLayout.createSequentialGroup()
                        .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cyclesTimeFLabel)
                            .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cyclesTimeSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(numberOfCyclesFLabel)
                                .addComponent(numberOfCyclesSpinner)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lowerLimitFLabel)
                            .addComponent(upperLimitFLabel)
                            .addComponent(upperLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lowerLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(waitUpperTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(waitUpperTimeFLabel)
                            .addComponent(waitLowerTimeFLabel)
                            .addComponent(waitLowerTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addGroup(testConfigurationPanelLayout.createSequentialGroup()
                        .addComponent(configurationFileFLabel)
                        .addGap(18, 18, 18)
                        .addComponent(regulationFileLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        testConfigurationPanelLayout.setVerticalGroup(
            testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigurationPanelLayout.createSequentialGroup()
                .addComponent(configurationDefaultButton)
                .addGap(32, 32, 32)
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfCyclesFLabel)
                    .addComponent(upperLimitFLabel)
                    .addComponent(waitUpperTimeFLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfCyclesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waitUpperTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waitLowerTimeFLabel)
                    .addComponent(lowerLimitFLabel)
                    .addComponent(cyclesTimeFLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cyclesTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waitLowerTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configurationFileFLabel)
                    .addComponent(regulationFileLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Output Files Directory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        directoryFLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        directoryFLabel.setText("Directory");

        directoryLabel.setBackground(java.awt.Color.white);
        directoryLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        directoryLabel.setText("none");
        directoryLabel.setOpaque(true);

        chooseOutputLabel.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        chooseOutputLabel.setText("Choose");

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directoryFLabel)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(directoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chooseOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(directoryFLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryLabel)
                    .addComponent(chooseOutputLabel))
                .addContainerGap())
        );

        regulationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Regulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        testRegulationFLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        testRegulationFLabel.setText("Test Regulation File");

        regulationFileLabel.setBackground(java.awt.Color.white);
        regulationFileLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        regulationFileLabel.setText("none");
        regulationFileLabel.setOpaque(true);

        chooseRegulationButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        chooseRegulationButton.setText("Choose");

        javax.swing.GroupLayout regulationPanelLayout = new javax.swing.GroupLayout(regulationPanel);
        regulationPanel.setLayout(regulationPanelLayout);
        regulationPanelLayout.setHorizontalGroup(
            regulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regulationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(regulationPanelLayout.createSequentialGroup()
                        .addComponent(testRegulationFLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regulationPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(regulationFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(chooseRegulationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        regulationPanelLayout.setVerticalGroup(
            regulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regulationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testRegulationFLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(regulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regulationFileLabel)
                    .addComponent(chooseRegulationButton))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(testConfigurationPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regulationPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(testConfigurationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseOutputLabel;
    private javax.swing.JButton chooseRegulationButton;
    private javax.swing.JButton configurationDefaultButton;
    private javax.swing.JLabel configurationFileFLabel;
    private javax.swing.JLabel cyclesTimeFLabel;
    private javax.swing.JSpinner cyclesTimeSpinner;
    private javax.swing.JLabel directoryFLabel;
    private javax.swing.JLabel directoryLabel;
    private javax.swing.JLabel lowerLimitFLabel;
    private javax.swing.JSpinner lowerLimitSpinner;
    private javax.swing.JLabel numberOfCyclesFLabel;
    private javax.swing.JSpinner numberOfCyclesSpinner;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JLabel regulationFileLabel;
    private javax.swing.JLabel regulationFileLabel1;
    private javax.swing.JPanel regulationPanel;
    private javax.swing.JPanel testConfigurationPanel;
    private javax.swing.JLabel testRegulationFLabel;
    private javax.swing.JLabel upperLimitFLabel;
    private javax.swing.JSpinner upperLimitSpinner;
    private javax.swing.JLabel waitLowerTimeFLabel;
    private javax.swing.JSpinner waitLowerTimeSpinner;
    private javax.swing.JLabel waitUpperTimeFLabel;
    private javax.swing.JSpinner waitUpperTimeSpinner;
    // End of variables declaration//GEN-END:variables
}
