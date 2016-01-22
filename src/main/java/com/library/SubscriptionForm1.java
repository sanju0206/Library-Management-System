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
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/library","root","protect");
		
		String u_Id = request.getParameter("user_id");
		String u_name = request.getParameter("user_name");
		String u_passwd = request.getParameter("passwd");
		String u_confirmpasswd = request.getParameter("confirmpasswd");
		String u_occupation = request.getParameter("occupation");
		String u_email = request.getParameter("email");
		String u_address = request.getParameter("address");
		
		
		
		
		PreparedStatement pstmt = conn.prepareStatement("insert into SUBSCRIPTION values(?,?,?,?,?,?,?)");
		pstmt.setString(1, u_Id);
		pstmt.setString(2, u_name);
		pstmt.setString(3, u_passwd );
		pstmt.setString(4,u_confirmpasswd);
		pstmt.setString(5, u_occupation);
		pstmt.setString(6, u_email);
		pstmt.setString(7, u_address);
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
