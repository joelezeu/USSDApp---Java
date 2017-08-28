package com.ussd.servlet;

import com.ussd.action.USSDProcess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel.eze
 */
@WebServlet("/processUSSD")
public class Process extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        USSDProcess up = new USSDProcess();
        try (PrintWriter out = resp.getWriter()) {
            try {
                up.processUSSD(out, req);
            } catch (SQLException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
