package my.mainframe;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {
    
    private static final int asciiCommandNullId = 43;
    Communicator communicator = new Communicator();
    CommandHandlings commandHandlings = new CommandHandlings(asciiCommandNullId);
            
    public MainFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 425, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commandsPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
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
        }
        communicator.initListener();    
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
            
        }
    }

    public void commandOperation(){       
        communicator.writeData(commandHandlings.commandHandle(command0_RB.isSelected(),command1_RB.isSelected(),command2_RB.isSelected(),command3_RB.isSelected()));
        if (!communicator.getIsConnected()){
            portsCB.removeAllItems();
            disconnect_routine();
            
            //connectBT.setEnabled(false);
        }
    }




}
