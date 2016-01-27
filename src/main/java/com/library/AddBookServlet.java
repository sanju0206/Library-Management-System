package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;


public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vedic","root","sanju0206");
		
		int book_id = Integer.parseInt(request.getParameter("BID"));
		String book_name = request.getParameter("BOOKNAME");
		String author = request.getParameter("AUTHOR");
		String publisher = request.getParameter("PUBLISHER");
		Float price = Float.parseFloat(request.getParameter("PRICE"));
		String Availability = request.getParameter("BOOKSTATUS");
		int no_books = Integer.parseInt(request.getParameter("count"));
		
		
		PreparedStatement pstmt = conn.prepareStatement("insert into books values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, book_id);
		pstmt.setString(2, book_name);
		pstmt.setString(3, author);
		pstmt.setString(4, publisher);
		pstmt.setFloat(5, price);
		pstmt.setString(6, Availability);
		pstmt.setInt(7, no_books);
		pstmt.execute();
		conn.close();
		
	
		RequestDispatcher rd=request.getRequestDispatcher("BookAddedConfirmation.jsp");    
        rd.include(request,response); 
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		/*response.sendRedirect("BookAddedConfirmation.jsp");*/
	}

}
