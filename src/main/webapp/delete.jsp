<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
Connection conn;
Statement stmt;

%>

<%
int v=Integer.parseInt(request.getParameter("bookid"));
try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(
		"jdbc:mysql://127.0.0.1/vedic","root","sanju0206"); 
stmt = conn.createStatement();
stmt.executeUpdate("delete from books where bid = '"+v+"'");
out.println("Record Deleted");
conn.close();

}
catch(ClassNotFoundException e){
	e.printStackTrace();
}
catch(SQLException e){
	e.printStackTrace();
}

%>
<jsp:include page="Viewupdatedelete.jsp"></jsp:include>

</body>
</html>