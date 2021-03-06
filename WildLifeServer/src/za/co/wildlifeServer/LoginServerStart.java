/**
 * @author: Quintin Mudge
 * Date: 15/02/2017
 * Lets user start the server using a button.
 */
package za.co.wildlifeServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Takes user name and password, Checks them against database values, Then
 * starts up the server.
 */
public class LoginServerStart extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginServerStart() {
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

        userNameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        passwordLbl = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        continueBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setLocation(new java.awt.Point(600, 350));

        userNameLbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        userNameLbl.setText("User Name :");

        passwordLbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        passwordLbl.setText("Password :");

        continueBtn.setText("Continue");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userNameLbl)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(userNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(passwordLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event listener for continue button, Takes user input and matches it
     * against the database.
     */
    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed

        /**
         * User input and check variables.
         */
        String name = nameTxt.getText();
        String password = new String(passwordTxt.getPassword());
        String nameChk = null;
        String passwordChk = null;
        String data = "jdbc:sqlserver://localhost:1433;databaseName=SaWild;integratedSecurity=true";
        Connection conn = null;
        ResultSet rs = null;

        //Makes new connection to database
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(data, "", "");

            //Query database
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT user_name, password FROM clientUser "
                    + "WHERE user_name = ? and password = ?")) {

                //Sets prepared statement
                ps.setString(1, name);
                ps.setString(2, password);
                rs = ps.executeQuery();

                //Stores values from Resultset.
                while (rs.next()) {
                    nameChk = rs.getString(1);
                    passwordChk = rs.getString(2);
                }
            }
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(null,
                    "Unable to connect to database, Check configuration.",
                    "Connection Error",
                    JOptionPane.CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println(e.toString());
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Checks for match, Displays server started message dialog.
        if (name.equals(nameChk) && password.equals(passwordChk)) {

            //Creates server.
            this.dispose();
            new Server();

        
            //Input error dialog box.
        } else {
            JOptionPane.showConfirmDialog(null,
                    "Incorrect Username or Password",
                    "Input Error",
                    JOptionPane.CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_continueBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel userNameLbl;
    // End of variables declaration//GEN-END:variables

}
