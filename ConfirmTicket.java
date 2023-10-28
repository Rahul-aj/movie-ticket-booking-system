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

public class ConfirmTicket extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"ConfirmTicket.css\" />");
            out.println("<title>Servlet ConfirmTicket</title>");
            out.println("</head>");
            out.println("<body >");
            out.println("<center>");
            Connection con = DbConnection.iniitializeDatabase();
            String mname = request.getParameter("mname");
            int price = Integer.parseInt(request.getParameter("price"));
            int cid = Integer.parseInt(request.getParameter("cid"));
            String cname = request.getParameter("cname");
            Long pnumber = Long.parseLong(request.getParameter("pnumber"));
            int seats = Integer.parseInt(request.getParameter("seats"));
            String sql2 = "select customer_id from Customer where customer_id=? ";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, cid);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                String sql = "insert into moviebooked values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, mname);
                ps.setInt(2, price);
                ps.setInt(3, cid);
                ps.setString(4, cname);
                ps.setLong(5, pnumber);
                ps.setInt(6, seats);
                int i = ps.executeUpdate();
                if (i > 0) {
                    
                    out.println("Details of Booking");
                    out.println("<h1> Ticket Booked!...</h1>");
                    out.println("<table border=1 id=\"list\">");
                    out.println("<tr><th>Movie Name</th><th>price</th><th>Customer ID</th><th>Customer Name</th><th>Phone Number</th><th>Seats</th></tr>");
                    out.println("<tr><td>" + mname + "</td><td>" + price + "</td><td>" + cid + "</td><td>" + cname + "</td><td>" + pnumber + "</td><td>" + seats + "</td>"); 
                    out.println("</table>");
                   out.println("<h2>Thank you for Booking...</h2>");
                   out.println("<h2><button><a href='AfterCustomerLogin.html' class='btn' >Back Home</a></button></h2>");
            
                }
            } else {
                out.println("<script>alert('Customer id does not Exist');</script>");
                request.getRequestDispatcher("BookWindow").include(request, response);
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
            Logger.getLogger(ConfirmTicket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmTicket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
