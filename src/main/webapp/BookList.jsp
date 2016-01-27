<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><center>Library Management System</center></h2> </br>
<P align=left>
<a href="WelcomeAdmin.jsp"><u>Admin Home</u></a>
</P>
<FORM ACTION="SerachBarServlet" METHOD="GET">
           <P align=center> Please enter the Author:
            <BR>
            <INPUT TYPE="TEXT" NAME="author">
            <BR>
            <INPUT TYPE="SUBMIT" value="Search">
        </FORM>
<%!
Connection conn;
Statement stmt;
ResultSet rs;
String bookname,author,publisher,bookstatus;
int bookid,no_of_books;
float price;

%>
<%
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(
   "jdbc:mysql://localhost/vedic", "root", "sanju0206"); 
stmt = conn.createStatement();
rs = stmt.executeQuery("select * from books");
%>

<table border=1>
<center>
<TR><TH>BID<TH>BOOKNAME<TH>AUTHOR<TH>PUBLISHER<TH>PRICE<TH>BOOKSTATUS<TH>COUNT

<%
while(rs.next())
{
	bookid = rs.getInt(1);
	bookname = rs.getString(2);
	author = rs.getString(3);
	publisher = rs.getString(4);
    price = rs.getFloat(5);
	bookstatus = rs.getString(6);
	no_of_books = rs.getInt(7);
%>
<TR> <TD> <%= bookid %> <TD> <%=bookname %> <TD> <%=author %> <TD> <%=publisher %> <TD><%=price %><TD> <%=bookstatus %><TD> <%=no_of_books %> <TD>
<%
}
%>
</center>
</table>

</body>
</html>
	 