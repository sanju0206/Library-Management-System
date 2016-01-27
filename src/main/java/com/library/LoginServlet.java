package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
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

  
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String u_id = request.getParameter("userid");
		String u_passwd = request.getParameter("passwd");
		
	   try{
		  
		   rs = stmt.executeQuery("select * from Subscription where userid='"+u_id+"' and passwd = '"+u_passwd+"'");
		   	ResultSet rs = stmt.getResultSet();

		   	if(rs.next()){
            	
            	 RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser.jsp");    
                 rd.forward(request,response);
		   	}
	
		  /* 	String userid = rs.getString(1);
		   	String passwd = rs.getString(2);*/
	   
	  /* if(userid.equals(u_id)&&passwd.equals(u_passwd)){    
           RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser.jsp");    
           rd.forward(request,response);       
       }
	   /*else if (userid.equals("admin")&&passwd.equals(u_passwd)){    
           RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin");    
           rd.forward(request,response);   
	   }*/
       	
       else{    
           out.print("<p style=\"color:red\">Sorry username or password error</p>");    
           RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
           rd.include(request,response);    
       }
		   	
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
