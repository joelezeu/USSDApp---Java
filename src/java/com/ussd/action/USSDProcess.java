package com.ussd.action;

import com.ussd.dao.USSDSession;
import com.ussd.dbc.DBConnection;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joel.eze
 */
public class USSDProcess {

    public void processUSSD(final PrintWriter out, HttpServletRequest req) throws SQLException {

        String userDial = req.getParameter("msisdn");
        String action = req.getParameter("userinput");
        String sessionID = req.getParameter("sessionid");

        HttpSession webSession = req.getSession();

        StringBuilder sb = new StringBuilder();
        USSDSession session = new USSDSession();
        DBConnection conn = new DBConnection();

        if (action.startsWith("*123")) {
            sb.append("Welcome ").append(conn.getUserDetails(userDial)).append("~");
            sb.append("1. Account Opening").append("~");
            sb.append("2. Check Balance");
        }
        if (action.equals("1")) {
            sb.append("Entet First Name");
        }

        if (action.equals("2")) {
            sb.append("Dear ").append(conn.getUserDetails(userDial)).append(" your balance is ").append("N").append(conn.getUserBalance(userDial));
        }
        
        

        out.println(sb.toString());

    }
}
