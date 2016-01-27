package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SerachBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection conn=null;
     Statement stmt=null;
     ResultSet rs=null;
     
   public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vedic","root","sanju0206");
			stmt = conn.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

  
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		
	   try{
		   	rs = stmt.executeQuery("SELECT * FROM books WHERE author = "+ "'" + request.getParameter("author") + "'");
		   	
		   	out.println("<table border=1>");
		   	out.println("<h2><center>Library Management System</center></h2> </br>");
		   	out.println("<p align=left> <a href='WelcomeAdmin.jsp'><u>Admin Home</u></a></p>");
		   	
		   	out.println("<TR><TH>BID<TH>BOOKNAME<TH>AUTHOR<TH>PUBLISHER<TH>PRICE<TH>BOOKSTATUS<TH>COUNT");
		   	while(rs.next()){
		   		int bookid = rs.getInt(1);
		   		String bookname = rs.getString(2);
		   		String author = rs.getString(3);
		   		String publisher = rs.getString(4);
		   	    Float price = rs.getFloat(5);
		   	    String bookstatus = rs.getString(6);
		   		int no_of_books = rs.getInt(7);
		   	out.println("<tr><td>"+bookid+"<td>"+bookname+"<td>"+author+"<td>"+publisher+"<td>"+price+"<td>"+bookstatus+"<td>"+no_of_books);
		   	}
		   	out.println("</table>");
		   	out.println("</body></html>");
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	}

	 public void destroy() {
			try{
				rs.close();
			stmt.close();
			conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}

		