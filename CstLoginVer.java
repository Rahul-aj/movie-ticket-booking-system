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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class CstLoginVer extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CstLoginVer</title>");            
            out.println("</head>");
            out.println("<body style=\"background-image: url('t3.webp');background-repeat: no-repeat; background-size: cover;  height: 100vh;\">");
           
            String email=request.getParameter("email");
             String pwd=request.getParameter("pwd");
            String sql="select email,pwd from customer where email=? and pwd=?";
            Connection con=DbConnection.iniitializeDatabase();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pwd);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                //out.println("<script> alert('Login Successfull');</script>");
                request.getRequestDispatcher("AfterCustomerLogin.html").include(request, response);
            }
            else
            {
                
                  out.println("<script> alert('Login Failed!');</script>");
                request.getRequestDispatcher("CustomerLogin.html").include(request, response);
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
            Logger.getLogger(CstLoginVer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CstLoginVer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CstLoginVer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CstLoginVer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
