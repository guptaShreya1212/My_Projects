import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewServlet extends HttpServlet{
    

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        String roll_no = request.getParameter("roll_no");
        String name = request.getParameter("name");
        Connection con=null;
         RequestDispatcher rd=null;
        
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
         
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "vsics");


        PreparedStatement ps=con.prepareStatement("select * from addstudent where roll_no=? and name=?");
         ps.setString(1,roll_no);
         ps.setString(2,name);
        ResultSet rs= ps.executeQuery();
        if (rs.next()){
               String roll_number=rs.getString(roll_no);
               System.out.println(roll_number);
               String Sname=rs.getString(name);
               System.out.println(Sname);
               rd = request.getRequestDispatcher("user.jsp");
               rd.forward(request, response);
        }
           else {
              //Student information not found
            response.getWriter().println("Student information not found.");
       
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


