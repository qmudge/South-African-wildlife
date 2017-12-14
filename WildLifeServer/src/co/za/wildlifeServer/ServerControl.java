/**
 * @author: Quintin Mudge
 * Date: 15/02/2017
 * Lets user shutdown the server using a button.
 */
package co.za.wildlifeServer;

/**
 * Contains two buttons to start and stop server.
 */
public class ServerControl extends javax.swing.JFrame {

    /**
     * Creates new form ServerStartStop
     */
    public ServerControl()  {
        initComponents();
    }

    /**
     * Design and layout, initializes the form. WARNING: Do NOT modify this
     * code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartServerBtn = new javax.swing.JButton();
        StopServerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setLocation(new java.awt.Point(600, 350));

        StartServerBtn.setText("Startup");
        StartServerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StartServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartServerBtnActionPerformed(evt);
            }
        });

        StopServerBtn.setText("Shutdown");
        StopServerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StopServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopServerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(StartServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(StopServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StopServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartServerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event listener for start button, Creates new server.
     */
    private void StartServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartServerBtnActionPerformed
        this.dispose();
        new LoginServerStart().setVisible(true);
    }//GEN-LAST:event_StartServerBtnActionPerformed

    /**
     * Event listener for shutdown button,Creates new shutdown server method.
     */
    private void StopServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopServerBtnActionPerformed
        this.dispose();
                   new LoginServerShutdown().setVisible(true);       
    }//GEN-LAST:event_StopServerBtnActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Create and display the form 
        new ServerControl().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StartServerBtn;
    private javax.swing.JButton StopServerBtn;
    // End of variables declaration//GEN-END:variables
}
