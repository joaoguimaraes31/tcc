/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mainframe;

public class MainFrame extends javax.swing.JFrame {
    private static final int asciiCommandNullId = 96;
    Communicator communicator = new Communicator();
    CommandHandlings commandHandlings = new CommandHandlings(asciiCommandNullId);
            
    public MainFrame() {
        initComponents();
        communicator.connect();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        command0_RB = new javax.swing.JRadioButton();
        command1_RB = new javax.swing.JRadioButton();
        command2_RB = new javax.swing.JRadioButton();
        command3_RB = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands Control"));

        command0_RB.setText("Command 0");
        command0_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command0_RBActionPerformed(evt);
            }
        });

        command1_RB.setText("Command 1");
        command1_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command1_RBActionPerformed(evt);
            }
        });

        command2_RB.setText("Command 2");
        command2_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command2_RBActionPerformed(evt);
            }
        });

        command3_RB.setText("Command 3");
        command3_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command3_RBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(command0_RB)
                    .addComponent(command1_RB)
                    .addComponent(command2_RB)
                    .addComponent(command3_RB))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(command0_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command1_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command2_RB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(command3_RB)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
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
    
    public void commandOperation(){       
        communicator.writeData(commandHandlings.commandHandle(command0_RB.isSelected(),command1_RB.isSelected(),command2_RB.isSelected(),command3_RB.isSelected()));
    }

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
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables



}
