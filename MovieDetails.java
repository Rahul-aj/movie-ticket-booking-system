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
 
public class MovieDetails extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MovieDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            Connection con=DbConnection.iniitializeDatabase();
            String mname =request.getParameter("mname");
            String tname =request.getParameter("tname");
            String mtype =request.getParameter("mtype");
            String language =request.getParameter("language");
            String director =request.getParameter("director"); 
            String cast =request.getParameter("cast"); 
            String duration =request.getParameter("duration"); 
            int price =Integer.parseInt(request.getParameter("price")); 
             
            String sql="insert into MovieDetails values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,mname);
            ps.setString(2,tname);
            ps.setString(3,mtype);
            ps.setString(4,language);
            ps.setString(5,director);
            ps.setString(6,cast);
            ps.setString(7,duration);
            ps.setInt(8,price);
               out.println("hellooo");
                int i=ps.executeUpdate();
                if(i>0)
                {
                    out.println("<script>");
                    out.println("location='AddedSuccesful.html';");
                    out.println("</script>");
                }
                else
                {
                    out.println("<script>alert('not inserted')</script>");
                }  
            
            
            
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
            Logger.getLogger(MovieDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
