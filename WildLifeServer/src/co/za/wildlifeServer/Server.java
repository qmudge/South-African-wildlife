/**
 * @author: Quintin Mudge
 * Date: 15/02/2017
 * Lets user shutdown the server using a button.
 */
package co.za.wildlifeServer;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Server application, handles multiple client requests, Queries database and
 * returns results to client.
 */
public class Server {

    /**
     * Server connection.
     */
    static ServerSocket ss;
    boolean listening;

    /**
     * Create server socket and listen for client requests.
     */
    public Server() {
        try {
            ss = new ServerSocket(7777);
            listening = true;

            //Dialog message for server started.
            JOptionPane.showMessageDialog(null, "Server started ",
                    " Server message",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ioe) {

            //Error dialog box for server allready running.
            JOptionPane.showConfirmDialog(null,
                    "Server Allready running",
                    "Server running notification",
                    JOptionPane.CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println(ioe.toString());
            System.exit(0);
        }
// wait for client – this could be placed on a thread.
        while (listening) {
            try {
// create a client socket and start a new client session.
                Session session = new Session(ss.accept());
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }
        }
    }

    /**
     * Client connection session.
     */
    class Session implements Runnable {

        /**
         * Session connection.
         */
        Socket soc;
        BufferedReader br;
        PrintWriter pw;
        Thread runner;

        //Creat new connection.
        Session(Socket s) {
            soc = s;
            try {
                br = new BufferedReader(new InputStreamReader(
                        soc.getInputStream()));
                pw = new PrintWriter(new BufferedOutputStream(
                        soc.getOutputStream()), true);

                pw.println("Welcome");
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }

            // start the thread.
            if (runner == null) {
                runner = new Thread(this);
                runner.start();
            }
        }

        /**
         * Reads input sent from client, Prints output.
         */
        @Override
        public void run() {
            while (runner == Thread.currentThread()) {
                try {
                    String input = br.readLine();
                    if (input != null) {
                        String output = Protocol.processInput(input);
                        pw.println(output);

                        //Close connection
                        if (output.equals("stop")) {
                            runner = null;
                            pw.close();
                            br.close();
                            soc.close();
                        }
                    }
                } catch (IOException ie) {
                    System.out.println(ie.toString());
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ie) {
                }
            }
            System.exit(0);
        }

    }
}

/**
 * Handler for client requests.
 */
class Protocol {

    /**
     * Database connection variables.
     */
    static String data = "jdbc:sqlserver://localhost:1433;databaseName=SaWild;integratedSecurity=true";
    static String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    /**
     * Returns data retrieved from database back to client.
     */
    public static String processInput(String input) {

        //Server shutdown.
        if (input.equals("wisdom")) {
            return "stop";

            //Check for add species request
        } else if (input.matches(".*,species")) {

            /**
             * Add new species variables.
             */
            String speciesName = null;
            String speciesSelect = null;
            String speciesID = "";
            int specID = 0;

            //make database connection.
            try {
                conn = DriverManager.getConnection(data, "", "");

                /**
                 * New array with species name.
                 */
                String[] speciesSplit = input.split(",");
                speciesName = speciesSplit[0];

                //Check for existing name.
                ps = conn.prepareStatement(
                        "SELECT species_name FROM species "
                        + "WHERE species_name = ? ");

                ps.setString(1, speciesName);

                rs = ps.executeQuery();

                //Store result value.
                while (rs.next()) {

                    speciesSelect = rs.getString(1);
                }

                //Close connection.
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

            //Species does not exist.
            if (speciesSelect == null) {

                //Connect to database, add new name.
                try {
                    conn = DriverManager.getConnection(data, "", "");
                    String sql = "INSERT INTO species (species_name) VALUES (?)";

                    //Fetches auto generated id key.
                    ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                    ps.setString(1, speciesName);

                    ps.executeUpdate();

                    ResultSet rs = ps.getGeneratedKeys();

                    //Sets id key. 
                    if (rs.next()) {
                        specID = (int) rs.getInt(1);
                        speciesID = String.valueOf(specID);
                    }

                    //Close connection.
                    ps.close();

                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
                input = "recordInserted";
            }
            return input;

            //Check for delete record request from client.
        } else if (input.matches(".*,delete")) {

            /**
             * Delete animal record variables.
             */
            String animalDelete = null;
            String animDelete = null;

            //Connect to database.
            try {

                conn = DriverManager.getConnection(data, "", "");

                /**
                 * Array holds animal details.
                 */
                String[] deleteSplit = input.split(",");
                animDelete = deleteSplit[0];

                //Check database for existing name.
                ps = conn.prepareStatement(
                        "SELECT animal_name FROM animal "
                        + "WHERE animal_name = ? ");

                ps.setString(1, animDelete);

                ResultSet rs = ps.executeQuery();

                //Store value result.
                while (rs.next()) {

                    animalDelete = rs.getString(1);
                }

                //Close connection.
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

            //Name exists in database
            if (animalDelete != null) {

                try {
                    conn = DriverManager.getConnection(data, "", "");

                    //Deletes animal.
                    ps = conn.prepareStatement(
                            "DELETE FROM animal WHERE animal_name = ? ");

                    ps.setString(1, animDelete);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        animalDelete = rs.getString(1);
                    }

                    //Close connection.
                    ps.close();

                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
                input = "recordDeleted";

                return input;
            }

            //Check for add new animal request from client.
        } else if (input.matches(".*=newAnimal")) {

            /**
             * Add new animal variables.
             */
            String animalName = null;
            String animalDesc = null;
            int animID = 0;
            int animalSpec = 0;
            int specID = 0;
            String animalSelect = null;
            String animalID = "";

            try {

                /**
                 * Array holds animal details.
                 */
                String[] animSplit = input.split("=");
                animalName = animSplit[0];
                animalDesc = animSplit[1];
                animalSpec = Integer.parseInt(animSplit[2]);

                System.out.println(animSplit[2]);

                //Connect to database.
                conn = DriverManager.getConnection(data, "", "");

                //Checks if name exists.
                ps = conn.prepareStatement(
                        "SELECT animal_name FROM animal WHERE animal_name = ?");

                ps.setString(1, animalName);

                ResultSet rs = ps.executeQuery();

                //Stores value result.
                while (rs.next()) {
                    animalSelect = rs.getString(1);
                }

                //Close connection.
                ps.close();
                rs = null;

                //Check that species id exists.
                ps = conn.prepareStatement(
                        "SELECT species_id FROM species WHERE species_id = ?");

                ps.setInt(1, animalSpec);
                rs = ps.executeQuery();

                //Stores result value
                while (rs.next()) {
                    specID = rs.getInt(1);
                }

                //Close connection.
                ps.close();

            } catch (SQLException e) {
                System.out.println(e.toString());
            }

            //Add new animal record.
            if (animalSelect == null && !(specID == 0)) {
                try {

                    //Connect to database.
                    conn = DriverManager.getConnection(data, "", "");
                    String sql = "INSERT INTO animal (animal_name, description, species_id) VALUES (?, ?, ?)";

                    //Get next available ID. 
                    ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                    ps.setString(1, animalName);
                    ps.setString(2, animalDesc);
                    ps.setInt(3, animalSpec);

                    ps.executeUpdate();

                    ResultSet rs = ps.getGeneratedKeys();

                    //Set ID key.
                    if (rs.next()) {
                        animID = (int) rs.getInt(1);
                        animalID = String.valueOf(animID);
                    }

                    //Close connection.
                    ps.close();

                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
                input = "recordInserted";

                //Species ID not found.
            } else if (specID == 0) {
                input = "speciesExists";

                //Name allready exists.
            } else {
                input = "nameExists";

                //Close connection.
                try {
                    ps.close();
                    ps = null;
                    conn.close();
                    conn = null;

                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
                return input;
            }

            //Check for client login request.
        } else if (input.matches(".*\\d+.*")) {

            /**
             * Login details.
             */
            String name = null;
            String password = null;

            //Connect to database.
            try {
                conn = DriverManager.getConnection(data, "", "");

                /**
                 * Array holds login details.
                 */
                String[] inputModified = input.split(",");

                //Check for name and password.
                ps = conn.prepareStatement(
                        "SELECT user_name, password FROM clientUser "
                        + "WHERE user_name = ? and password = ?");

                ps.setString(1, inputModified[0]);
                ps.setString(2, inputModified[1]);

                ResultSet rs = ps.executeQuery();

                //Stores value results.
                while (rs.next()) {
                    name = rs.getString(1) + ",";
                    password = rs.getString(2);
                    System.out.println(name + password);
                }

                //Close connection.    
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            return name + password;

            //Checks for animal/species search request.
        } else {

            /**
             * Value for empty search result.
             */
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> desc = new ArrayList<>();
            ArrayList<String> spec = new ArrayList<>();
            String valueCheck = null;
            try {

                //Connect to database.
                Connection conn = DriverManager.getConnection(data, "", "");

                String inputModified = "%" + input + "%";

                //Creat new ArrayLists to hold record values.
                //Get records from database.
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT animal_name, description, species_name FROM animal "
                        + "JOIN species ON species.species_id = animal.species_id "
                        + "WHERE animal_name LIKE ? OR species_name like ?");

                ps.setString(1, inputModified);
                ps.setString(2, inputModified);

                ResultSet rs = ps.executeQuery();

                //Store record values.
                while (rs.next()) {
                    names.add(rs.getString(1));
                    desc.add(rs.getString(2));
                    spec.add(rs.getString(3));

                    valueCheck = rs.getString(1);
                }

                //Close connection.
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

            //No record found
            if (valueCheck == null) {
                valueCheck = "noResult";
                return valueCheck;

            } else {
                input = names.toString() + desc.toString() + spec.toString();
            }
        }
        return input;
    }
}
