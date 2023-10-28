 
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

 
public class BookWindow extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"BookWindow.css\" />");
            out.println("<title>Servlet BookWindow</title>");
            out.println("</head>");
            out.println("<body style=\"background-image: url('4.jfif');background-repeat: no-repeat; background-size: cover;  height: 100vh;\"><br><br><br><br>");
            out.println("<div class='c6'>");
          
            out.println("<form method=post action=ConfirmTicket>");
            String mname = request.getParameter("mname");
            int price = Integer.parseInt(request.getParameter("price"));
          
            out.println("<p>Moive Name:</p>");
            out.println("<input type='text' name=mname value=" + mname + " readonly>");
             out.println("<p>Price:</p>");
             out.println("<input type='text' name=price value=" + price + " readonly>");
              out.println("<p>Customer ID:</p>");
              out.println("<input type='text' name=cid>");
            out.println("<p>Customer Name:</p>");
            out.println("<input type='text' name=cname>");
            out.println("<p>Phone Number:</p>");
            out.println("<input type='text' name=pnumber>");
            out.println("<p>Number Of Seats:</p>");            
            out.println("<input type='text' name=seats>");
            out.println("<center><input type='submit' value=Confirm></center>");
               
            out.println("</form>");
          
          
           out.println("</div>");
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
            Logger.getLogger(BookWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
