package my.mainframe;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {
    
    private static final int asciiCommandNullId = 43;
    ExecutionTimerControl execTimer =  new ExecutionTimerControl();
    Communicator communicator = new Communicator();
    CommandHandlings commandHandlings = new CommandHandlings(asciiCommandNullId);
            
    public MainFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        commandsPN = new javax.swing.JPanel();
        command0_RB = new javax.swing.JRadioButton();
        command1_RB = new javax.swing.JRadioButton();
        command2_RB = new javax.swing.JRadioButton();
        command3_RB = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        disconnectBT = new javax.swing.JButton();
        connectBT = new javax.swing.JButton();
        searchBT = new javax.swing.JButton();
        portsCB = new javax.swing.JComboBox<>();
        SetSamplingRatePN = new javax.swing.JPanel();
        samplingRatesCB = new javax.swing.JComboBox<>();
        SetNumberOfSamplesPN = new javax.swing.JPanel();
        NumberOfSamplesCB = new javax.swing.JComboBox<>();
        AcquisitionControlPN = new javax.swing.JPanel();
        StopAcquisitionBT = new javax.swing.JButton();
        StartAcquisitionBT = new javax.swing.JButton();
        RunTimeTF = new javax.swing.JTextField();
        RunTimeLB = new javax.swing.JLabel();

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commandsPN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 24))); // NOI18N
        commandsPN.setToolTipText("");
        commandsPN.setEnabled(false);

        command0_RB.setText("Command 0");
        command0_RB.setEnabled(false);
        command0_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command0_RBActionPerformed(evt);
            }
        });

        command1_RB.setText("Command 1");
        command1_RB.setEnabled(false);
        command1_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command1_RBActionPerformed(evt);
            }
        });

        command2_RB.setText("Command 2");
        command2_RB.setEnabled(false);
        command2_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command2_RBActionPerformed(evt);
            }
        });

        command3_RB.setText("Command 3");
        command3_RB.setEnabled(false);
        command3_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command3_RBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commandsPNLayout = new javax.swing.GroupLayout(commandsPN);
        commandsPN.setLayout(commandsPNLayout);
        commandsPNLayout.setHorizontalGroup(
            commandsPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandsPNLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(commandsPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(command3_RB)
                    .addComponent(command1_RB)
                    .addComponent(command0_RB)
                    .addComponent(command2_RB))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        commandsPNLayout.setVerticalGroup(
            commandsPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandsPNLayout.createSequentialGroup()
                .addComponent(command0_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command1_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command2_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command3_RB)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serial Port Connection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 24))); // NOI18N

        disconnectBT.setText("Disconnect");
        disconnectBT.setEnabled(false);
        disconnectBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disconnectBTMouseClicked(evt);
            }
        });

        connectBT.setText("Connect");
        connectBT.setEnabled(false);
        connectBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectBTMouseClicked(evt);
            }
        });

        searchBT.setText("Search");
        searchBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchBT)
                        .addGap(18, 18, 18)
                        .addComponent(portsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(connectBT)
                        .addGap(34, 34, 34)
                        .addComponent(disconnectBT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBT)
                    .addComponent(portsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectBT)
                    .addComponent(disconnectBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SetSamplingRatePN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sampling Rate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N
        SetSamplingRatePN.setToolTipText("");
        SetSamplingRatePN.setEnabled(false);

        samplingRatesCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Hz", "10Hz", "100Hz", "1KHz", "10KHz", "100KHz" }));
        samplingRatesCB.setSelectedIndex(3);
        samplingRatesCB.setToolTipText("");
        samplingRatesCB.setEnabled(false);

        javax.swing.GroupLayout SetSamplingRatePNLayout = new javax.swing.GroupLayout(SetSamplingRatePN);
        SetSamplingRatePN.setLayout(SetSamplingRatePNLayout);
        SetSamplingRatePNLayout.setHorizontalGroup(
            SetSamplingRatePNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetSamplingRatePNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(samplingRatesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SetSamplingRatePNLayout.setVerticalGroup(
            SetSamplingRatePNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetSamplingRatePNLayout.createSequentialGroup()
                .addComponent(samplingRatesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SetNumberOfSamplesPN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number Of Samples", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N
        SetNumberOfSamplesPN.setToolTipText("");
        SetNumberOfSamplesPN.setEnabled(false);

        NumberOfSamplesCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "10", "100", "500", "1k", "10k" }));
        NumberOfSamplesCB.setSelectedIndex(2);
        NumberOfSamplesCB.setEnabled(false);

        javax.swing.GroupLayout SetNumberOfSamplesPNLayout = new javax.swing.GroupLayout(SetNumberOfSamplesPN);
        SetNumberOfSamplesPN.setLayout(SetNumberOfSamplesPNLayout);
        SetNumberOfSamplesPNLayout.setHorizontalGroup(
            SetNumberOfSamplesPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetNumberOfSamplesPNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NumberOfSamplesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        SetNumberOfSamplesPNLayout.setVerticalGroup(
            SetNumberOfSamplesPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetNumberOfSamplesPNLayout.createSequentialGroup()
                .addComponent(NumberOfSamplesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        AcquisitionControlPN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acquisition Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N
        AcquisitionControlPN.setEnabled(false);

        StopAcquisitionBT.setText("Stop Acquisition");
        StopAcquisitionBT.setEnabled(false);
        StopAcquisitionBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StopAcquisitionBTMouseClicked(evt);
            }
        });

        StartAcquisitionBT.setText("Start Acquisition");
        StartAcquisitionBT.setEnabled(false);
        StartAcquisitionBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartAcquisitionBTMouseClicked(evt);
            }
        });

        RunTimeTF.setEditable(false);
        RunTimeTF.setText("0ms");
        RunTimeTF.setEnabled(false);

        RunTimeLB.setText("RunTime");
        RunTimeLB.setEnabled(false);

        javax.swing.GroupLayout AcquisitionControlPNLayout = new javax.swing.GroupLayout(AcquisitionControlPN);
        AcquisitionControlPN.setLayout(AcquisitionControlPNLayout);
        AcquisitionControlPNLayout.setHorizontalGroup(
            AcquisitionControlPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcquisitionControlPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AcquisitionControlPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AcquisitionControlPNLayout.createSequentialGroup()
                        .addComponent(StartAcquisitionBT)
                        .addGap(18, 18, 18)
                        .addComponent(RunTimeLB)
                        .addGap(0, 82, Short.MAX_VALUE))
                    .addGroup(AcquisitionControlPNLayout.createSequentialGroup()
                        .addComponent(StopAcquisitionBT)
                        .addGap(16, 16, 16)
                        .addComponent(RunTimeTF)))
                .addContainerGap())
        );
        AcquisitionControlPNLayout.setVerticalGroup(
            AcquisitionControlPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcquisitionControlPNLayout.createSequentialGroup()
                .addGroup(AcquisitionControlPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartAcquisitionBT)
                    .addComponent(RunTimeLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AcquisitionControlPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StopAcquisitionBT)
                    .addComponent(RunTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AcquisitionControlPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SetSamplingRatePN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SetNumberOfSamplesPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(commandsPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SetSamplingRatePN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SetNumberOfSamplesPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AcquisitionControlPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(commandsPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void command0_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_command0_RBActionPerformed
        commandOperation();
    }//GEN-LAST:event_command0_RBActionPerformed

    private void command1_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_command1_RBActionPerformed
        commandOperation();
    }//GEN-LAST:event_command1_RBActionPerformed

    private void command2_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_command2_RBActionPerformed
        commandOperation();
    }//GEN-LAST:event_command2_RBActionPerformed

    private void command3_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_command3_RBActionPerformed
        commandOperation();
    }//GEN-LAST:event_command3_RBActionPerformed

    private void connectBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectBTMouseClicked
        connect_routine();        
    }//GEN-LAST:event_connectBTMouseClicked

    private void disconnectBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnectBTMouseClicked
        //Connecting to the serial port
        disconnect_routine();
    }//GEN-LAST:event_disconnectBTMouseClicked

    private void searchBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBTMouseClicked
        search_routine();       
    }//GEN-LAST:event_searchBTMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        communicator.writeData(97);
    }//GEN-LAST:event_jButton1MouseClicked

    private void StartAcquisitionBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartAcquisitionBTMouseClicked
        startAcquisitionRoutine();
    }//GEN-LAST:event_StartAcquisitionBTMouseClicked

    private void StopAcquisitionBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopAcquisitionBTMouseClicked
        communicator.writeData(41);
        communicator.removeListener();
        
        //controlling GUI elements
        SetSamplingRatePN.setEnabled(true);
        samplingRatesCB.setEnabled(true);
        SetNumberOfSamplesPN.setEnabled(true);
        NumberOfSamplesCB.setEnabled(true);
        StartAcquisitionBT.setEnabled(true);
        StopAcquisitionBT.setEnabled(false);
        RunTimeLB.setEnabled(false);
        RunTimeTF.setEnabled(false);
    }//GEN-LAST:event_StopAcquisitionBTMouseClicked
    

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AcquisitionControlPN;
    private javax.swing.JComboBox<String> NumberOfSamplesCB;
    private javax.swing.JLabel RunTimeLB;
    private javax.swing.JTextField RunTimeTF;
    private javax.swing.JPanel SetNumberOfSamplesPN;
    private javax.swing.JPanel SetSamplingRatePN;
    private javax.swing.JButton StartAcquisitionBT;
    private javax.swing.JButton StopAcquisitionBT;
    private javax.swing.JRadioButton command0_RB;
    private javax.swing.JRadioButton command1_RB;
    private javax.swing.JRadioButton command2_RB;
    private javax.swing.JRadioButton command3_RB;
    private javax.swing.JPanel commandsPN;
    private javax.swing.JButton connectBT;
    private javax.swing.JButton disconnectBT;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> portsCB;
    private javax.swing.JComboBox<String> samplingRatesCB;
    private javax.swing.JButton searchBT;
    // End of variables declaration//GEN-END:variables


    public void search_routine(){
        portsCB.removeAllItems();
        String[] portMapValues =  communicator.getPortMapValues();
        
        for(int i =0;i<portMapValues.length;i++){
            portsCB.addItem(portMapValues[i]);
        }
        
        if (portsCB.getSelectedItem()==null){
            connectBT.setEnabled(false);
            Component frame = null;			
            JOptionPane.showMessageDialog(frame,"No serial ports were found!","ERROR",JOptionPane.ERROR_MESSAGE);
                        
        }else{
            connectBT.setEnabled(true);
        }
    }
    
    public void connect_routine(){
        //Connecting to the serial port
        if (!communicator.getIsConnected() && connectBT.isEnabled()){
            communicator.connect(portsCB.getSelectedItem().toString());
        }
        
        //Controlling GUI elements
        if (communicator.getIsConnected() && connectBT.isEnabled() && !disconnectBT.isEnabled()){
            connectBT.setEnabled(false);
            disconnectBT.setEnabled(true);
            commandsPN.setEnabled(true);
            command0_RB.setEnabled(true);
            command1_RB.setEnabled(true);
            command2_RB.setEnabled(true);
            command3_RB.setEnabled(true);
            SetSamplingRatePN.setEnabled(true);
            samplingRatesCB.setEnabled(true);
            SetNumberOfSamplesPN.setEnabled(true);
            NumberOfSamplesCB.setEnabled(true);
            AcquisitionControlPN.setEnabled(true);
            StartAcquisitionBT.setEnabled(true);
        }
        //communicator.initListener();    
    }
    
    public void disconnect_routine(){
        if (communicator.getIsConnected()){
            communicator.disconnect();
        }
        
        //Controlling GUI elements
        if (!communicator.getIsConnected() && disconnectBT.isEnabled() && !connectBT.isEnabled()){
            connectBT.setEnabled(true);
            disconnectBT.setEnabled(false);
            commandsPN.setEnabled(false);
            command0_RB.setEnabled(false);
            command0_RB.setSelected(false);
            command1_RB.setEnabled(false);
            command1_RB.setSelected(false);
            command2_RB.setEnabled(false);
            command2_RB.setSelected(false);
            command3_RB.setSelected(false);
            command3_RB.setEnabled(false);
            samplingRatesCB.setEnabled(false);
            SetNumberOfSamplesPN.setEnabled(false);
            NumberOfSamplesCB.setEnabled(false);
            AcquisitionControlPN.setEnabled(false);
            StartAcquisitionBT.setEnabled(false);
            
        }
    }

    public void commandOperation(){       
        communicator.writeData(commandHandlings.commandHandle(command0_RB.isSelected(),command1_RB.isSelected(),command2_RB.isSelected(),command3_RB.isSelected()));
        //System.out.println(commandHandlings.commandHandle(command0_RB.isSelected(),command1_RB.isSelected(),command2_RB.isSelected(),command3_RB.isSelected()));
        if (!communicator.getIsConnected()){
            portsCB.removeAllItems();
            disconnect_routine();
            
            //connectBT.setEnabled(false);
        }
    }

    public void setSamplingRateRoutine(int input ) {
        switch (input){
            case 0:
                communicator.writeData(65);
            case 1:
                communicator.writeData(66);
            case 2:
                communicator.writeData(67);
            case 3:
                communicator.writeData(68);
            case 4:
                communicator.writeData(69);
            case 5:
                communicator.writeData(70); 
        }
        
    }
    
    public void setNumberOfSamplesRoutine (int input ) {
        switch (input){
            case 0:
                communicator.writeData(33);
            case 1:
                communicator.writeData(34);
            case 2:
                communicator.writeData(35);
            case 3:
                communicator.writeData(36);
            case 4:
                communicator.writeData(37);
            case 5:
                communicator.writeData(38); 
        }
    }

    public void startAcquisitionRoutine(){
        if (JOptionPane.showConfirmDialog(null, "Sampling Rate defined at: "
            + samplingRatesCB.getSelectedItem().toString()
            + ".\nNumberOfSamples defined at: "
            + NumberOfSamplesCB.getSelectedItem().toString()
            +" samples.\n Are you sure you want to start acquistion with these settings?", "WARNING",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //setNumberOfSamplesRoutine(samplingRatesCB.getSelectedIndex());
                //setNumberOfSamplesRoutine(NumberOfSamplesCB.getSelectedIndex());
                communicator.writeData(40);
                communicator.initListener();
                
                //controlling GUI elements
                SetSamplingRatePN.setEnabled(false);
                samplingRatesCB.setEnabled(false);
                SetNumberOfSamplesPN.setEnabled(false);
                NumberOfSamplesCB.setEnabled(false);
                StartAcquisitionBT.setEnabled(false);
                StopAcquisitionBT.setEnabled(true);
                RunTimeLB.setEnabled(true);
                RunTimeTF.setEnabled(true);
        }               
    }
}
