/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Malla
 */
public class dbConnection {
    private final String URL = "jdbc:mysql://localhost:3306/StudentIssuesManager";
    private final String Uname = "root";
    private final String Password = "";
    private static dbConnection instance;
    private Connection con;

    private dbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, Uname, Password);
            System.out.println("Connection Success");
        } catch (SQLException ex) {
            System.out.println("Database Connection ERROR " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver class Error " + ex.getMessage());
        }
    }

    public static dbConnection getSingleInstace() {
        try {
            if (instance == null) {
                instance = new dbConnection();
            } else if (instance.con.isClosed()) {
                instance = new dbConnection();
            } else {
                return instance;
               
            }
            return instance;
        } catch (SQLException ex) {
            System.out.println("Database Connection ERROR " + ex.getMessage());
            return null;
        }
    }

    public boolean ExecuteQuery(String sqlQ) {
        try {
            Statement st = con.createStatement();
            int result=st.executeUpdate(sqlQ);
            return result>0;
        } catch (SQLException ex) {
            System.out.println("SQL Error "+ex.getMessage());
            return false;
        }
    }

}
