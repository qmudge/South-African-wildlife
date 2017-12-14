/**
 * @author: Quintin Mudge
 * Date: 21/02/2017
 * Description: JTable for displaying records from database to user.
 * records from database to user.
 */
package co.za.wildlife;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

/**
 * Create a JTable to display records from database.
 */
public class AnimalSearchTable extends JFrame {

    /**
     * Creates JTable that reads in and displays database data object from
     * created result list.
     */
    AnimalSearchTable(String[] animalName, String[] description, String[] species) {

        //Design variables
        super("Result list");
        setSize(1200, 250);
        setLocation(150, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int count = 0;

        //get size of Array
        count = animalName.length;

        /**
         * JTable column names and rows
         */
        String columnNames[] = {"Animal name", "Description", "Species"};
        Object rows[][] = new Object[count][3];

        
        //Creates new table
        JTable t = new JTable(rows, columnNames);
        t.setFont(new Font("Serif", Font.BOLD, 30));
        JScrollPane scrollPane = new JScrollPane(t);
        setContentPane(scrollPane);

         /**
         * String arrays of animal names, descriptions and species names.
         */
        String[] name = animalName;
        String[] animalDescription = description;
        String[] speciesName = species;

        //Loop array data into rows
        for (int i = 0; i < name.length; i++) {
            rows[i][0] = name[i];
            rows[i][1] = animalDescription[i];
            rows[i][2] = speciesName[i];
        }

        // When updating values redefine the table and add it to the scrollPane.
        t = new JTable(rows, columnNames);
        scrollPane.getViewport().add(t);

        //Sets table style
        t.setRowHeight(25);
        t.setShowVerticalLines(true);
        t.setShowHorizontalLines(true);
        t.setFont(new Font("Georgia", Font.ITALIC, 18));
        t.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        t.setForeground(Color.blue);
        t.setBackground(Color.orange);
        TableColumnModel columnModel = t.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(350);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(350);
        setVisible(true);
    }
}
