/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class CancelTicket extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CancelTicket</title>");            
            out.println("</head>");
            out.println("<body style=\"background-image: url('D1.webp');background-repeat: no-repeat; background-size: cover;  height: 100vh;\" >");
           
            
  
             int cid=Integer.parseInt(request.getParameter("cid"));   
              String mname=request.getParameter("mname");    
             
             
             String sql="delete from moviebooked where cid=? and mname=?";
             Connection con=DbConnection.iniitializeDatabase();
             PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, cid);
             ps.setString(2, mname);
            int i=ps.executeUpdate();
            if(i>0)
            {
               // out.println("<script>alert('Succesfully Cancel')</script>");
                out.println("<center><h1 style=\"color: white\">Ticket is Canceled</h1></center>");
            }
            else
            {
                out.println("<script>alert('not Cancel')</script)");
 
            }
             
            con.close();
             
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CancelTicket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CancelTicket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
