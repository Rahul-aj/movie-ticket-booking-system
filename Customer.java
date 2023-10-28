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
 
public class Customer extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Customer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Hiiiiiii");
              
             Connection con=DbConnection.iniitializeDatabase();
           int customer_id =Integer.parseInt(request.getParameter("customer_id"));
            String customer_name =request.getParameter("customer_name");
            Long  pnumber=Long.parseLong(request.getParameter("pnumber"));
            String address=request.getParameter("address");
            String email =request.getParameter("email");
            String pwd =request.getParameter("pwd"); 
            String sql="insert into customer values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, customer_id);
            ps.setString(2,customer_name);
            ps.setLong(3,pnumber);
            ps.setString(4,address);
            ps.setString(5,email);
            ps.setString(6,pwd);
             //  out.println("<h1> Details of Customer is ......</h1>");
              // out.println("<table border=1>");
              //  out.println("<tr><th>CID</th><th>CName</th><th>PNUMBER</th><th>ADDRESS</th><th>EMAIL</th><th>PASSWORD</th></tr>");
               // out.println("<tr><td>"+customer_id+"</td><td>"+customer_name+"</td><td>"+pnumber+"</td><td>"+address+"</td><td>"+email+"</td><td>"+pwd+"</td></tr>");
               // out.println("</table>");
                int i=ps.executeUpdate();
                if(i>0)
                {
                    out.println("<script>");
                    out.println("alert('record inserted');");
                    out.println("location='AfterCustomerLogin.html';");
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
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
