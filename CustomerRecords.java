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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class CustomerRecords extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"CustomerRecords.css\" />");
            out.println("<title>Servlet CustomerRecords</title>");            
            out.println("</head>");
            out.println("<body>");
          
             Connection con=DbConnection.iniitializeDatabase();
              int cid=Integer.parseInt(request.getParameter("cid"));
             String sql="SELECT * from moviebooked where cid=?";
              PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1,cid);
             ResultSet rs=ps.executeQuery();  
             out.println("<center><h1>All Booked records are</h1></center>");
             out.println("<table border=1 id=\"list\">");
             out.println("<tr><th>Movie name</th><th>Price</th><th>CUstomer ID</th><th>Customer Name</th><th>Phone Num</th><th>seats</th></tr>");
             while(rs.next())
             {
                 out.println("<tr><td>"+rs.getString(1)+"</td>");
                 out.println("<td>"+rs.getInt(2)+"</td>");
                 out.println("<td>"+rs.getInt(3)+"</td>");
                  out.println("<td>"+rs.getString(4)+"</td>");
                   out.println("<td>"+rs.getLong(5)+"</td>");
                    out.println("<td>"+rs.getInt(6)+"</td>");
  
             }
          
             con.close();
            out.println("</table>"); 
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
