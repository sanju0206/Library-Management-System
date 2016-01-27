package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;


public class SubscriptionForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vedic","root","sanju0206");
		
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String occupation = request.getParameter("occupation");
		String emailid = request.getParameter("emailid");
		String address = request.getParameter("address");
		
		
		
		
		PreparedStatement pstmt = conn.prepareStatement("insert into Subscription values(?,?,?,?,?,?)");
		pstmt.setString(1, userid);
		pstmt.setString(2, username);
		pstmt.setString(3, passwd );
		pstmt.setString(4, occupation);
		pstmt.setString(5, emailid);
		pstmt.setString(6, address);
		pstmt.execute();
		
		
		//out.println("Record Added");
		
		//stmt.close();
		
		conn.close();
		
		}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect("RecordAdded.jsp");
	}

}
