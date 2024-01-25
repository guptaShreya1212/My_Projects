

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<html>
<head>
    <title>Display Data</title>
           <link rel="stylesheet" href="admin.css"> 

</head>
<body>
<center>
    <div class="details-display">
            <table class="details-display-table" border="1">
                <thead>
                    <tr>
                        <td>Roll_no </td>
                        <td>Student_name</td>
                        <td>Project_name</td>
                        <td colspan="2">Team_member</td>
                    </tr>
                </thead>
                
            
         
    <% 
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
       // RequestDispatcher dispatcher=null;
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
         
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "vsics");
                  st=con.createStatement();
                    String qry="select * from addstudent";
                    rs=st.executeQuery(qry);
                    while(rs.next())
                    {
                    %>
                    <tr>
                        <td><%=rs.getString(1) %></td>
                        <td><%=rs.getString(2) %></td>
                        <td><%=rs.getString(3) %></td>
                        <td><%=rs.getString(4) %></td>

                    </tr>
                   <%
                     }
        }catch(Exception e)
        {
        
        }
    %>
</table>
    </div>
</center>
</body>
</html>
