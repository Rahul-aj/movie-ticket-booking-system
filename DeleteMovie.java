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
 
public class DeleteMovie extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteMovie</title>");            
            out.println("</head>");
            out.println("<body>");
          
             
             Connection con=DbConnection.iniitializeDatabase();
            String mname=request.getParameter("mname");
            String sql="delete from moviedetails where mname=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,mname);
            int i=ps.executeUpdate();
            if(i>0)
            {
                    out.println("<script>");
                    
                    out.println("location='DeleteSuccesful.html';");
                    out.println("</script>");
                     
                
            }
            else
            {
                out.println("<script>alert('not deleted')</script)");
                out.println("<br><h2>Enter the Currect Movie Name to Delete<h2>");
 
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
