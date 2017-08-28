/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ussd.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel.eze
 */
public class DBConnection {

    public ResultSet getMySQLConnectionForUser(String mobile) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //The Following DataSource can be kept in a config file
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ussdapp", "root", "");
            Statement stmt = con.createStatement();
            String userMobile = !mobile.startsWith("234")? "234"+mobile.substring(1): mobile;
            rs = stmt.executeQuery("SELECT name, account_number, mobile, balance, category FROM account WHERE mobile = "+userMobile);
            //con.close();
        } catch (Exception ex) {
            con.close();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public String getUserDetails(String mobile) throws SQLException{
        String result = "";
        DBConnection connect = new DBConnection();
        ResultSet rs = connect.getMySQLConnectionForUser(mobile);
        while (rs.next()) {
            result = rs.getString("name");
        }
        return result;
    }
    
    public String getUserBalance(String mobile) throws SQLException{
        String result = "";
        DBConnection connect = new DBConnection();
        ResultSet rs = connect.getMySQLConnectionForUser(mobile);
        while (rs.next()) {
            result = rs.getString("balance");
        }
        return result;
    }
}
