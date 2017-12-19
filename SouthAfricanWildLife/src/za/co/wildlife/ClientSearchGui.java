/**
 * @author: Quintin Mudge
 * Date: 26/02/2017
 * Description: Main GUI interface, User search for content page.
 */
package za.co.wildlife;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Contains JFrame User GUI plus methods to interact with server and search for
 * records in the database.
 */
public class ClientSearchGui extends javax.swing.JFrame {

    /**
     * variable declared for window frame.
     */
    private Component frame;

    /**
     * Creates new form SearchPage
     */
    public ClientSearchGui() {
        initComponents();
    }

    /**
     * Method for closing the application using a custom dialog box.
     */
    private void CustomClose() {
        Object[] options = {"Exit", "Minimize", "Cancel"};
        int n = JOptionPane.showOptionDialog(frame,
                "Would you like to exit the program ",
                "Confirm exit",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        //Closes application.    
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);

            //Minimizes window.       
        } else {
            if (n == JOptionPane.NO_OPTION) {
                setExtendedState(JFrame.ICONIFIED);

            }
        }

    }

    /**
     * Design and layout, initializes the form. WARNING: Do NOT modify this
     * code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainHeading = new javax.swing.JLabel();
        picture1 = new javax.swing.JLabel();
        panelBackground = new javax.swing.JPanel();
        searchLbl = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        menuBar = new javax.swing.JMenuBar();
        adminLogin = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        aboutMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        closeProgram = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        allowedValues = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("South-African Wildlife application");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1680, 1050));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1680, 1050));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        mainHeading.setFont(new java.awt.Font("Andalus", 3, 48)); // NOI18N
        mainHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainHeading.setText("South-African Wildlife");
        getContentPane().add(mainHeading);
        mainHeading.setBounds(-950, 0, 3495, 62);

        picture1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        picture1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/za/co/wildlife/africa4.png"))); // NOI18N
        picture1.setMaximumSize(new java.awt.Dimension(1680, 700));
        picture1.setMinimumSize(new java.awt.Dimension(1680, 600));
        picture1.setPreferredSize(new java.awt.Dimension(1680, 700));
        getContentPane().add(picture1);
        picture1.setBounds(0, -180, 1700, 800);

        panelBackground.setBackground(new java.awt.Color(0, 0, 0));
        panelBackground.setMinimumSize(new java.awt.Dimension(1366, 550));
        panelBackground.setPreferredSize(new java.awt.Dimension(1680, 550));

        searchLbl.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        searchLbl.setForeground(new java.awt.Color(255, 255, 255));
        searchLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLbl.setText("Search for animal or species :");

        textSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        searchButton.setText("Search");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(searchLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(471, Short.MAX_VALUE))
        );

        getContentPane().add(panelBackground);
        panelBackground.setBounds(-20, 570, 1720, 600);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(40, 10, 0, 2);

        menuBar.setBorder(new javax.swing.border.MatteBorder(null));

        adminLogin.setText("File");
        adminLogin.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N

        loginMenu.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        loginMenu.setText("Admin Login");
        loginMenu.setContentAreaFilled(false);
        loginMenu.setIconTextGap(0);
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
        adminLogin.add(loginMenu);
        adminLogin.add(jSeparator3);

        aboutMenu.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        aboutMenu.setText("Info");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        adminLogin.add(aboutMenu);
        adminLogin.add(jSeparator4);

        closeProgram.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        closeProgram.setText("Exit");
        closeProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeProgramActionPerformed(evt);
            }
        });
        adminLogin.add(closeProgram);

        menuBar.add(adminLogin);

        helpMenu.setText("Help");
        helpMenu.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N

        about.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        helpMenu.add(about);
        helpMenu.add(jSeparator1);

        allowedValues.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        allowedValues.setText("Allowed values");
        allowedValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowedValuesActionPerformed(evt);
            }
        });
        helpMenu.add(allowedValues);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event listener that sets custom option selection before exiting the
     * program
     */
    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_loginMenuActionPerformed

    /**
     * Event listener that sets custom option selection before exiting the
     * program
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        CustomClose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Uses regular expressions to check the input when searching for a animal
     * or species.
     */
    private void regexAnimalSearch() {
        String SearchText = textSearch.getText();

        //Checking correct field input
        while (SearchText != null) {
            boolean matches = Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]+\\s*[a-zA-Z]*+\\s*[a-zA-Z]*", SearchText);

            if (matches) {
                try {
                    searchClient();
                } catch (IOException ex) {
                    Logger.getLogger(ClientSearchGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

                //Error message displayed for incorrect user input.   
            } else {
                JOptionPane.showConfirmDialog(null,
                        "Search must contain atleast 3 alphabetical letters [a-zA-Z]."
                        + "\nE.g : 'Bald Eagle'", "Input Error",
                        JOptionPane.CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE
                );
                break;
            }
        }
    }

    /**
     * Event listener for about menu option. Displays a information dialog box
     * containing general description of program.
     */
    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "This program contains information "
                + "about various wildlife found throughout Southern Africa.\n To"
                + " start with a new search, type in the name or the species "
                + "group of the particular animal\n you would like to gain more"
                + "  information about.", " Search Help",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutActionPerformed

    /**
     * Event listener that sets custom option selection before exiting the
     * program. Exit from menu.
     */
    private void closeProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeProgramActionPerformed
        CustomClose();
    }//GEN-LAST:event_closeProgramActionPerformed

    /**
     * Event listener for allowed values menu option. Displays a information
     * dialog box containing allowed values for searches.
     */
    private void allowedValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowedValuesActionPerformed
        JOptionPane.showMessageDialog(null, "Only make use of alphabetical "
                + "lettering ranging from  [a - z]  and CAPITALS  [A - Z] .\n\n"
                + "All other characters eg, numbers and special characters "
                + "are disallowed. ", "Allowed values for search",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_allowedValuesActionPerformed

    /**
     * Event listener for information menu option. Displays a information dialog
     * box containing short description of searchable types.
     */
    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Examples of searchable content.\n\n"
                + "Species types : Mammals, Birds, Fish, Reptiles. \n "
                + "Animal types : Zebra, Blue Crane, Cape kurper, Crocodile. ",
                "General Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuActionPerformed

    /**
     * Event listener that runs input validation check method.
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        regexAnimalSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientSearchGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientSearchGui().setVisible(true);
            }
        });
    }

    /**
     * Creates client connections for animal search to communicate with server.
     * Receives input back from server with custom messages.
     */
    private void searchClient() throws IOException {

        // connection variables.
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        //new client connection.
        try {
            clientSocket = new Socket("127.0.0.1", 7777
            );
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            BufferedReader line = new BufferedReader(new InputStreamReader(
                    System.in));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: 127.0.0.1");
            System.exit(1);
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null,
                    "Unable to connect to server.\nMake sure that server is"
                    + " running and try again.",
                    "Connection Error",
                    JOptionPane.CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }
        String fromServer;
        String fromUser;

        //Server recieved input
        while ((fromServer = in.readLine()) != null) {

            //Input from user
            fromUser = textSearch.getText();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
                break;
            }
        }
        fromServer = in.readLine();

        //Message dialog box for no records returned.
        if (fromServer.equals("noResult")) {
            JOptionPane.showMessageDialog(null, "OOPS! No matches found for your search."
                    + "\n Please try a different name.",
                    "No results to display",
                    JOptionPane.INFORMATION_MESSAGE);

            //Closes connections.
        } else {

            /**
             * Store data sent from server into arrays.
             */
            String[] details = fromServer.split("\\[");
            String[] animalName = details[1].replace("]", "").split(",");
            String[] description = details[2].replace("]", "").split(",");
            String[] species = details[3].replace("]", "").split(",");

            //Opens new JTable displaying returned records, pass in array values.
            new AnimalSearchTable(animalName, description, species);
            out.close();
            in.close();
            clientSocket.close();
        }

        //Closes client connections.
        out.close();
        in.close();
        clientSocket.close();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenu adminLogin;
    private javax.swing.JMenuItem allowedValues;
    private javax.swing.JMenuItem closeProgram;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JLabel mainHeading;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JLabel picture1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}