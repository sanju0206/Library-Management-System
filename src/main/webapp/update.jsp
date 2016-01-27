<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
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
PreparedStatement stmt;
String bookname,author,publisher,bookstatus;
int bookid,no_of_books;
float price;
%>

<%
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(	"jdbc:mysql://127.0.0.1/vedic","root","sanju0206"); 
stmt = conn.prepareStatement("update books set bookname=?,author=?,publisher=?,price=?,bookstatus=?,count=? where bid="+request.getParameter("bookid"));
stmt.setString(2, request.getParameter("bookname"));
stmt.setString(3, request.getParameter("author"));
stmt.setString(4, request.getParameter("publisher"));
stmt.setFloat(5, Float.parseFloat(request.getParameter("price")));
stmt.setString(6, request.getParameter("bookstatus"));
stmt.setInt(7, Integer.parseInt(request.getParameter("count")));

stmt.execute();
out.println("Record Updated");

%>
<jsp:include page="Viewupdatedelete.jsp"></jsp:include>

</body>
</html>