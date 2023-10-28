/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ViewAllMovieAdmin extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"ViewAllMovie.css\" />");
            out.println("<title>Servlet ViewAllMovieAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            
             out.println("<center>");
            
            
             Connection con=DbConnection.iniitializeDatabase();
             String sql="SELECT * from moviedetails";
             Statement stm=con.createStatement();
             ResultSet rs=stm.executeQuery(sql);
             out.println("<h1>All Movie</h1>");
              out.println("<table border=1 id=\"list\">");
             
             out.println("<tr><th>MOVIE NAME</th><th>THEOTER NAME</th><th>MOVIE TYPE</th><th>LANGUAGE</th><th>DIRECTOR</th><th>CAST</th><th>DURATION</th><th>PRICE</th></tr>");
             while(rs.next())
             {
                 out.println("<tr><td>"+rs.getString(1)+"</td>");
                 out.println("<td>"+rs.getString(2)+"</td>");
                 out.println("<td>"+rs.getString(3)+"</td>");
                 out.println("<td>"+rs.getString(4)+"</td>");
                 out.println("<td>"+rs.getString(5)+"</td>");
                 out.println("<td>"+rs.getString(6)+"</td>");
                 out.println("<td>"+rs.getString(7)+"</td>");
                  out.println("<td>"+rs.getInt(8)+"</td></tr>");
                 
             }
             con.close();
             out.println("</table>"); 
             out.println("</center>");
            
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
            Logger.getLogger(ViewAllMovieAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllMovieAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllMovieAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllMovieAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
