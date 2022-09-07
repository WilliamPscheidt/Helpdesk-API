package com.helpdeskproject.repository;

import java.sql.*;

public class LoginUserRepository {
  public static String[] ExecuteQuery() 
  {
    try
    {
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/helpdesk";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      String query = "SELECT * FROM users";

      Statement st = conn.createStatement();
      
      ResultSet rs = st.executeQuery(query);
      
      while (rs.next())
      {
        String email = rs.getString("email");
        String password = rs.getString("password");

        return new String[] {email, password};
      }
      st.close();
    }
    catch (Exception e)
    {
      return new String[] {"Error"} ;
    }
    return null;
  }
}