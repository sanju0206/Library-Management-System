package com.library;

import java.io.IOException; 
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String userid =request.getParameter("userid");    
        String password =request.getParameter("password");   
          
        if(Validate.checkUser(userid, password)){    
            RequestDispatcher rd=request.getRequestDispatcher("WelcomeUsers");    
            rd.forward(request,response);       
        }
        	
        else{    
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);    
        }    
  
        out.close();
    }    
}   
