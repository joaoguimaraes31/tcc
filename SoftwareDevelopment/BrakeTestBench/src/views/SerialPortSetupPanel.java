package views;

import controllers.SerialPortSetupController;

public class SerialPortSetupPanel extends javax.swing.JPanel {

    private SerialPortSetupController controller;

    public SerialPortSetupPanel(SerialPortSetupController controller) {
        this.controller=controller;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        portsSearchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        portsCB = new javax.swing.JComboBox<>();
        setButton = new javax.swing.JButton();
        serialPortFixedLabel = new javax.swing.JLabel();
        selectedPortLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(626, 569));
        setPreferredSize(new java.awt.Dimension(626, 569));

        portsSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ports Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        searchButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        searchButton.setText("Search");

        portsCB.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        portsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        portsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portsCBActionPerformed(evt);
            }
        });

        setButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        setButton.setText("Set");
        setButton.setEnabled(false);

        serialPortFixedLabel.setFont(new java.awt.Font("Ubuntu", 2, 20)); // NOI18N
        serialPortFixedLabel.setText("Selected Serial Port:");

        selectedPortLabel.setBackground(java.awt.Color.white);
        selectedPortLabel.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        selectedPortLabel.setText("null");
        selectedPortLabel.setOpaque(true);

        javax.swing.GroupLayout portsSearchPanelLayout = new javax.swing.GroupLayout(portsSearchPanel);
        portsSearchPanel.setLayout(portsSearchPanelLayout);
        portsSearchPanelLayout.setHorizontalGroup(
            portsSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portsSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(portsSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(portsSearchPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(portsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(portsSearchPanelLayout.createSequentialGroup()
                        .addComponent(serialPortFixedLabel)
                        .addGap(18, 18, 18)
                        .addComponent(selectedPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 175, Short.MAX_VALUE))
        );
        portsSearchPanelLayout.setVerticalGroup(
            portsSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portsSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(portsSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(portsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setButton))
                .addGap(33, 33, 33)
                .addGroup(portsSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialPortFixedLabel)
                    .addComponent(selectedPortLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portsSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portsSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void portsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portsCBActionPerformed
        setButton.setEnabled(true);
    }//GEN-LAST:event_portsCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> portsCB;
    private javax.swing.JPanel portsSearchPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel selectedPortLabel;
    private javax.swing.JLabel serialPortFixedLabel;
    private javax.swing.JButton setButton;
    // End of variables declaration//GEN-END:variables
    
    
    //Getters and Setters
    public javax.swing.JComboBox<String> getPortsCB() {
        return portsCB;
    }

    public javax.swing.JPanel getPortsSearchPanel() {
        return portsSearchPanel;
    }

    public javax.swing.JButton getSearchButton() {
        return searchButton;
    }

    public javax.swing.JLabel getSelectedPortLabel() {
        return selectedPortLabel;
    }

    public javax.swing.JButton getSetButton() {
        return setButton;
    }
    
}
