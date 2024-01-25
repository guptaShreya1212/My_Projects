/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shreya
 */
package com.server;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet{
    

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Connection con=null;
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
         
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "vsics");


        PreparedStatement ps=con.prepareStatement("select * from signup where email=? and password=?");
         ps.setString(1,email);
         ps.setString(2,password);
        ResultSet rs= ps.executeQuery();
        if (rs.next()) {
                //Successful login, redirect to a dashboard or success page
//                response.sendRedirect("choice.html");
             email = rs.getString("email"); // Assuming 'role' is a column in your 'signup' table

                if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("ad123")) {
                    // Redirect to admin page
                    response.sendRedirect("admin.html");
                } else {
                    // Redirect to user page
                    response.sendRedirect("view.html");
                }
                
                
                
                
                
                
            } else {
                // Invalid credentials, redirect back to the login page with an error message
                response.sendRedirect("signin.html?error=invalid");
            }
        
    }catch(Exception e){
         e.printStackTrace();
    }
     finally{
        try{
           
                con.close(); 
        
        }
        catch(SQLException e){
            e.printStackTrace();
        }
      
          }
          
          }
}
