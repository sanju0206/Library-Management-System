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


public class GetStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection conn=null;
     Statement stmt=null;
     ResultSet rs=null;
     
   public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vedic","root","root");
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
		   	rs = stmt.executeQuery("select * from students");
		   	
		   	out.println("<table border=1>");
		   	out.println("<tr><th>SID<th>SNAME<th>QUAL<th>GENDER<th>COURSE<th>FEE");
		   	while(rs.next()){
		   	int sid = rs.getInt(1);
		   	String sname = rs.getString(2);
		   	String qual = rs.getString(3);
		   	String gender = rs.getString(4);
		   	String course = rs.getString(5);
		   	float fee = rs.getFloat(6);
		   	out.println("<tr><td>"+sid+"<td>"+sname+"<td>"+qual+"<td>"+gender+"<td>"+course+"<td>"+fee);
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