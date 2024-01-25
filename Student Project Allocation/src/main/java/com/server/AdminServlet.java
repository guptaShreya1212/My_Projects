/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/


package com.server;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AdminServlet extends HttpServlet{
    

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        String name = request.getParameter("student_name");
        String roll_number= request.getParameter("roll_no");
        String project_name = request.getParameter("project_name");
        String team_member = request.getParameter("team_member");
        
        Connection con=null;
       // RequestDispatcher dispatcher=null;
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
         
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "vsics");


        PreparedStatement ps=con.prepareStatement("insert into addStudent values(?,?,?,?)");
        
        ps.setString(1,roll_number);
        ps.setString(2,name);
         ps.setString(3,project_name);
          ps.setString(4,team_member);
        
       ps.executeUpdate();
      RequestDispatcher rd = request.getRequestDispatcher("admin.html"); 
      rd.forward(request, response);
       }
        catch(Exception e){
         e.printStackTrace();
    }
      finally {
            try {
                if (con != null) {
                    con.close(); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
}
           
//                
//                
//                
    