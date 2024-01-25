/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 
import java.sql.*;
public class SignupServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       
        String name=request.getParameter("name");
        String email=request.getParameter("email");
      String password=request.getParameter("password");
      String contact=request.getParameter("contact");
      
       //String redirectURL = "signup.html";
      RequestDispatcher dispatcher=null;
      Connection con=null;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "vsics");


        PreparedStatement ps=con.prepareStatement("insert into signup (name,email,password,contact) values (?,?,?,?)");
         ps.setString(1,name);
         ps.setString(2,email);
         ps.setString(3,password);
         ps.setString(4,contact);
         
                  int rowCount=ps.executeUpdate();
                 dispatcher = request.getRequestDispatcher("signin.html");
                   if(rowCount>0){ 
                          request.setAttribute("status","success"); 
                         
                      }
                  else
                  {             
                      request.setAttribute("status", "failed");
//                       RequestDispatcher dispatcher = request.getRequestDispatcher("signup.html");
//                       dispatcher.forward(request, response); 
                  }
                   dispatcher.forward(request, response); 
      }
     
      catch(Exception e)
      {
          
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
