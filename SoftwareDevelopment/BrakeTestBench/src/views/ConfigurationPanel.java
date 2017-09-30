package views;

import controllers.ConfigurationController;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import models.ConfigurationModel;

public class ConfigurationPanel extends javax.swing.JPanel {

    //MVC
    private ConfigurationController controller;
    private ConfigurationModel model;

    public ConfigurationPanel() {
        initComponents();
    }

    public ConfigurationPanel(ConfigurationController controller) {
        this.controller = controller;
        this.model = controller.getModel();
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
        waitLowerTimeSpinner = new javax.swing.JSpinner(model.getWAIT_LOWER_SPINNER_MODEL());
        numberOfCyclesFLabel = new javax.swing.JLabel();
        upperLimitFLabel = new javax.swing.JLabel();
        waitUpperTimeFLabel = new javax.swing.JLabel();
        waitLowerTimeFLabel = new javax.swing.JLabel();
        lowerLimitFLabel = new javax.swing.JLabel();
        cyclesTimeFLabel = new javax.swing.JLabel();
        configurationDefaultButton = new javax.swing.JButton();
        configurationFileFLabel = new javax.swing.JLabel();
        configurationFileLabel = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        directoryFLabel = new javax.swing.JLabel();
        directoryLabel = new javax.swing.JLabel();
        chooseOutputButton = new javax.swing.JButton();
        defaultOutputButton = new javax.swing.JButton();
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

        configurationFileLabel.setBackground(java.awt.Color.white);
        configurationFileLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        configurationFileLabel.setText("default");
        configurationFileLabel.setOpaque(true);

        javax.swing.GroupLayout testConfigurationPanelLayout = new javax.swing.GroupLayout(testConfigurationPanel);
        testConfigurationPanel.setLayout(testConfigurationPanelLayout);
        testConfigurationPanelLayout.setHorizontalGroup(
            testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testConfigurationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigurationPanelLayout.createSequentialGroup()
                        .addGroup(testConfigurationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(testConfigurationPanelLayout.createSequentialGroup()
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
                                    .addComponent(waitLowerTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(testConfigurationPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(configurationDefaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83))
                    .addGroup(testConfigurationPanelLayout.createSequentialGroup()
                        .addComponent(configurationFileFLabel)
                        .addGap(18, 18, 18)
                        .addComponent(configurationFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(configurationFileLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Output Files Directory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        directoryFLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        directoryFLabel.setText("Directory");

        directoryLabel.setBackground(java.awt.Color.white);
        directoryLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        directoryLabel.setText("default");
        directoryLabel.setOpaque(true);

        chooseOutputButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        chooseOutputButton.setText("Choose");

        defaultOutputButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        defaultOutputButton.setText("Default");

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(directoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(directoryFLabel))
                .addGap(18, 18, 18)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooseOutputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(defaultOutputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(directoryFLabel))
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(defaultOutputButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryLabel)
                    .addComponent(chooseOutputButton))
                .addContainerGap())
        );

        regulationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Regulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N
        regulationPanel.setEnabled(false);

        testRegulationFLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        testRegulationFLabel.setText("Test Regulation File");
        testRegulationFLabel.setEnabled(false);

        regulationFileLabel.setBackground(java.awt.Color.white);
        regulationFileLabel.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        regulationFileLabel.setText("none");
        regulationFileLabel.setEnabled(false);
        regulationFileLabel.setOpaque(true);

        chooseRegulationButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        chooseRegulationButton.setText("Choose");
        chooseRegulationButton.setEnabled(false);

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
    private javax.swing.JButton chooseOutputButton;
    private javax.swing.JButton chooseRegulationButton;
    private javax.swing.JButton configurationDefaultButton;
    private javax.swing.JLabel configurationFileFLabel;
    private javax.swing.JLabel configurationFileLabel;
    private javax.swing.JLabel cyclesTimeFLabel;
    private javax.swing.JSpinner cyclesTimeSpinner;
    private javax.swing.JButton defaultOutputButton;
    private javax.swing.JLabel directoryFLabel;
    private javax.swing.JLabel directoryLabel;
    private javax.swing.JLabel lowerLimitFLabel;
    private javax.swing.JSpinner lowerLimitSpinner;
    private javax.swing.JLabel numberOfCyclesFLabel;
    private javax.swing.JSpinner numberOfCyclesSpinner;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JLabel regulationFileLabel;
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

    public ConfigurationController getController() {
        return controller;
    }

    public ConfigurationModel getModel() {
        return model;
    }

    public JButton getChooseOutputLabel() {
        return chooseOutputButton;
    }

    public JButton getChooseRegulationButton() {
        return chooseRegulationButton;
    }

    public JButton getConfigurationDefaultButton() {
        return configurationDefaultButton;
    }

    public JLabel getConfigurationFileFLabel() {
        return configurationFileFLabel;
    }

    public JLabel getCyclesTimeFLabel() {
        return cyclesTimeFLabel;
    }

    public JSpinner getCyclesTimeSpinner() {
        return cyclesTimeSpinner;
    }

    public JLabel getDirectoryFLabel() {
        return directoryFLabel;
    }

    public JLabel getDirectoryLabel() {
        return directoryLabel;
    }

    public JLabel getLowerLimitFLabel() {
        return lowerLimitFLabel;
    }

    public JSpinner getLowerLimitSpinner() {
        return lowerLimitSpinner;
    }

    public JLabel getNumberOfCyclesFLabel() {
        return numberOfCyclesFLabel;
    }

    public JSpinner getNumberOfCyclesSpinner() {
        return numberOfCyclesSpinner;
    }

    public JPanel getOutputPanel() {
        return outputPanel;
    }

    public JLabel getRegulationFileLabel() {
        return regulationFileLabel;
    }

    public JLabel getConfigurationFileLabel() {
        return configurationFileLabel;
    }

    public JPanel getRegulationPanel() {
        return regulationPanel;
    }

    public JPanel getTestConfigurationPanel() {
        return testConfigurationPanel;
    }

    public JLabel getTestRegulationFLabel() {
        return testRegulationFLabel;
    }

    public JLabel getUpperLimitFLabel() {
        return upperLimitFLabel;
    }

    public JSpinner getUpperLimitSpinner() {
        return upperLimitSpinner;
    }

    public JLabel getWaitLowerTimeFLabel() {
        return waitLowerTimeFLabel;
    }

    public JSpinner getWaitLowerTimeSpinner() {
        return waitLowerTimeSpinner;
    }

    public JLabel getWaitUpperTimeFLabel() {
        return waitUpperTimeFLabel;
    }

    public JSpinner getWaitUpperTimeSpinner() {
        return waitUpperTimeSpinner;
    }

    public JButton getDefaultOutputButton() {
        return defaultOutputButton;
    }

    public JButton getChooseOutputButton() {
        return chooseOutputButton;
    }
}
