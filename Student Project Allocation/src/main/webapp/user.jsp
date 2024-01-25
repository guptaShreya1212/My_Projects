<%-- 
    Document   : user
    Created on : 01-Jan-2024, 2:12:16 pm
    Author     : shreya
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<html>
<head>
    <title>View Student Information</title>
           <link rel="stylesheet" href="admin.css"> 

</head>
<body>
<center>
    <div class="details-display">
            <table class="details-display-table" border="1">
                <thead>
                    <tr>
                        <td>Roll_no</td>
                        <td>student Name</td>
                        <td>Project_name</td>
                        <td colspan="2">Team_member</td>
                    </tr>
                </thead>
                <tbody>
           <%  
                ResultSet studentInfo = (ResultSet) request.getAttribute("studentInfo");
                if (studentInfo != null) {
             %>
             
                    <tr>
                        <td><%=studentInfo.getString(1) %></td>
                        <td><%=studentInfo.getString(2) %></td>
                        <td><%=studentInfo.getString(3) %></td>
                        <td><%=studentInfo.getString(4) %></td>

                    </tr>
                    
                   <%
                     }else{%>
                                <h1>No student information found.</h1>

            <% } 
            %>
            </tbody>
       
</table>
    </div>
</center>
</body>
</html>
