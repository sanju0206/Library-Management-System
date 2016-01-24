package com.library;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String userid,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1/vedic","root","sanju0206");
         PreparedStatement ps =con.prepareStatement
                             ("select * from Subscription where userid=? and password=?");
         ps.setString(1, userid);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}
