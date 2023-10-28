/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebook;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
     public static Connection iniitializeDatabase() throws ClassNotFoundException, SQLException
  {
       //Step1 Loading the JDBC drives
        Class.forName("com.mysql.jdbc.Driver");
        //Stpe 2 Connecting to the database
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root123");
        return con;
  }
}
