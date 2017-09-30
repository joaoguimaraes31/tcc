package views;

import controllers.NavigationController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JMenuItem;
import models.NavigationModel;

public class ApplicationFrame extends javax.swing.JFrame {
    
    //MVC
    private NavigationController controller;
    private NavigationModel model;
    
    //views
    private SerialPortSetupPanel serialPortSetupPanel;
    private CalibrationPanel calibrationPanel;
    private ConfigurationPanel configurationPanel;
    private BraketestPanel braketestPanel;
            
    private GridBagLayout layout = new GridBagLayout();
    
    public ApplicationFrame(){
        initComponents();
    }
    
    public ApplicationFrame(NavigationController controller) {
        this.controller=controller;
        this.model=controller.getModel();
        initComponents();
        serialPortSetupPanel = controller.getSerialPortSetupController().getView();
        calibrationPanel = controller.getCalibrationController().getView();
        configurationPanel = controller.getConfigurationController().getView();
        braketestPanel = controller.getBraketestController().getView();
        DynamicPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(serialPortSetupPanel, c);
        DynamicPanel.add(calibrationPanel, c);
        DynamicPanel.add(configurationPanel,c);
        DynamicPanel.add(braketestPanel,c);
        deselectButtonsPannels();      
        serialPortSetupPanel.setVisible(true);
        serialPortsToggleButton.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        serialPortsToggleButton = new javax.swing.JToggleButton();
        b2 = new javax.swing.JToggleButton();
        configuraitonToggleButton = new javax.swing.JToggleButton();
        calibrationToggleButton = new javax.swing.JToggleButton();
        braketestToggleButton = new javax.swing.JToggleButton();
        DynamicPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemOpenCalibrationFile = new javax.swing.JMenuItem();
        menuItemSaveCalibrationFile = new javax.swing.JMenuItem();
        menuItemOpenConfigurationFile = new javax.swing.JMenuItem();
        menuSaveConfiguration = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        menuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 20))); // NOI18N

        serialPortsToggleButton.setSelected(true);
        serialPortsToggleButton.setText("Ports Setup");
        serialPortsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialPortsToggleButtonActionPerformed(evt);
            }
        });

        b2.setText("Sensor Setup");
        b2.setEnabled(false);

        configuraitonToggleButton.setText("Configuration");
        configuraitonToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuraitonToggleButtonActionPerformed(evt);
            }
        });

        calibrationToggleButton.setText("Calibration");
        calibrationToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calibrationToggleButtonActionPerformed(evt);
            }
        });

        braketestToggleButton.setText("Braketest");
        braketestToggleButton.setEnabled(false);
        braketestToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                braketestToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serialPortsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(configuraitonToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
            .addComponent(calibrationToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(braketestToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serialPortsToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calibrationToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configuraitonToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(braketestToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        DynamicPanel.setBorder(null);
        DynamicPanel.setMinimumSize(new java.awt.Dimension(626, 569));
        DynamicPanel.setPreferredSize(new java.awt.Dimension(626, 569));

        javax.swing.GroupLayout DynamicPanelLayout = new javax.swing.GroupLayout(DynamicPanel);
        DynamicPanel.setLayout(DynamicPanelLayout);
        DynamicPanelLayout.setHorizontalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        DynamicPanelLayout.setVerticalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menuFile.setText("File");

        menuItemOpenCalibrationFile.setText("Open Calibration File");
        menuFile.add(menuItemOpenCalibrationFile);

        menuItemSaveCalibrationFile.setText("Save Calibration File");
        menuFile.add(menuItemSaveCalibrationFile);

        menuItemOpenConfigurationFile.setText("Open Configuration File");
        menuFile.add(menuItemOpenConfigurationFile);

        menuSaveConfiguration.setText("Save Configuration File");
        menuFile.add(menuSaveConfiguration);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(DynamicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void serialPortsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialPortsToggleButtonActionPerformed
        deselectButtonsPannels();
        serialPortSetupPanel.setVisible(true);
        serialPortsToggleButton.setSelected(true);
    }//GEN-LAST:event_serialPortsToggleButtonActionPerformed

    private void calibrationToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calibrationToggleButtonActionPerformed
        deselectButtonsPannels();
        if (model.getSelectedSerialPort() != null) {         
            calibrationPanel.getSerialPortLabel().setText(model.getSelectedSerialPort().getName());
            calibrationPanel.getStartButton().setEnabled(true);
        }else{
            calibrationPanel.getSerialPortLabel().setText("null");
            calibrationPanel.getStartButton().setEnabled(false);
        }
        calibrationPanel.setVisible(true);
        calibrationToggleButton.setSelected(true);
    }//GEN-LAST:event_calibrationToggleButtonActionPerformed

    private void configuraitonToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuraitonToggleButtonActionPerformed
        deselectButtonsPannels();
        configurationPanel.setVisible(true);
        configuraitonToggleButton.setSelected(true);
    }//GEN-LAST:event_configuraitonToggleButtonActionPerformed

    private void braketestToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_braketestToggleButtonActionPerformed
        deselectButtonsPannels();
        braketestPanel.setVisible(true);
        braketestToggleButton.setSelected(true);
    }//GEN-LAST:event_braketestToggleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JToggleButton b2;
    private javax.swing.JToggleButton braketestToggleButton;
    private javax.swing.JToggleButton calibrationToggleButton;
    private javax.swing.JToggleButton configuraitonToggleButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemOpenCalibrationFile;
    private javax.swing.JMenuItem menuItemOpenConfigurationFile;
    private javax.swing.JMenuItem menuItemSaveCalibrationFile;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JMenuItem menuSaveConfiguration;
    private javax.swing.JToggleButton serialPortsToggleButton;
    // End of variables declaration//GEN-END:variables

    public void deselectButtonsPannels() {
        serialPortsToggleButton.setSelected(false);
        calibrationToggleButton.setSelected(false);
        configuraitonToggleButton.setSelected(false);
        braketestToggleButton.setSelected(false);
        serialPortSetupPanel.setVisible(false);
        calibrationPanel.setVisible(false);
        configurationPanel.setVisible(false);
        braketestPanel.setVisible(false);
    }

    public SerialPortSetupPanel getSerialPortSetupPanel() {
        return serialPortSetupPanel;
    }

    public CalibrationPanel getCalibrationPanel() {
        return calibrationPanel;
    }

    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    public JMenuItem getMenuItemOpenCalibrationFile() {
        return menuItemOpenCalibrationFile;
    }

    public JMenuItem getMenuItemSaveCalibrationFile() {
        return menuItemSaveCalibrationFile;
    }

}
