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


public class SubscriptionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ebook","root","protect");
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String qual = request.getParameter("qual");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		float fee = Float.parseFloat(request.getParameter("fee"));
		
		
		/*Statement stmt = conn.createStatement();
		stmt.executeUpdate("insert into students values("+sid+",'"+sname+"','"+qual+"','"+gender+"','"+course+"',"+fee+")");
		*/
		
		PreparedStatement pstmt = conn.prepareStatement("insert into students values(?,?,?,?,?,?)");
		pstmt.setInt(1, sid);
		pstmt.setString(2, sname);
		pstmt.setString(3, qual);
		pstmt.setString(4,gender);
		pstmt.setString(5, course);
		pstmt.setFloat(6, fee);
		pstmt.execute();
		
		
		
		
		out.println("Record Added");
		
		//stmt.close();
		
		conn.close();
		
		
		
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
