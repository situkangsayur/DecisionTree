/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendri
 */
public class HelpAttribute {

    private static List<Attribute> atribut;
    private static Connection conn;

    public static void getColumnNames(ResultSet rs) throws SQLException {
        if (rs == null) {
            return;
        }
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
       
        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {

            //if (i != 6) {
         //   System.out.println(rsMetaData.getColumnName(i));
            Attribute attr = new Attribute();
            attr.setNumber(i - 1);
            if ((i == numberOfColumns + 1) || (i == 1)) {
                attr.setState(true);
            } else {
                attr.setState(false);
            }

        //    System.out.println("");
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            attr.setAttribute(columnName);

            atribut.add(attr);
            //}
        }
    }

    protected static void createAttributeList() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree?zeroDateTimeBehavior=convertToNull", "root", "");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if (atribut == null) {
            try {
                atribut = new ArrayList<Attribute>();

                Statement getField = conn.createStatement();
                ResultSet rs = getField.executeQuery("select * from training_set");
                getColumnNames(rs);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
    }

    public static List<Attribute> getAtribut() {
        if (atribut == null) {
            createAttributeList();
        }
        return atribut;
    }

    public static int checkState() {
        if (atribut == null) {
            createAttributeList();
        }
       // System.out.println(atribut.size());
        int status = 0;

        for (Attribute attr : atribut) {

            if (!attr.isState()) {
                status++;
            }

        }
       // System.out.println(status);
        return status;
    }

    public static int sumOfAllAttr() {
        return atribut.size();
    }

    public static boolean isAvailable(int numField) {
        boolean status = false;
        status = atribut.get(numField).isState() ? false : true;
       // System.out.println(status + "<<==== status field");

        return status;
    }

    public static boolean isAvailable(String nameField) {
        boolean status = false;
        for (Attribute attr : atribut) {
            if (attr.getAttribute().equalsIgnoreCase(nameField)) {
                status = !attr.isState();
            }
        }
        return status;
    }
}
