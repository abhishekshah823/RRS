package com.proj1;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId =null;
		userId=request.getParameter("uid");
		String password = request.getParameter("pass");
		HttpSession session=request.getSession();
		System.out.println("Entered:"+userId);
		
		 Connection conn = null;
		 Statement stmt = null;
		 Properties prop = new Properties();
		    InputStream input = null;
		     try {
		    	 
		    	 input=new FileInputStream("C:\\Users\\KIIT\\eclipse-workspace\\Proj1\\WebContent\\WEB-INF\\application.properties");
		    	 prop.load(input);
		    	 System.out.println("Linking Driver");
		    	 Class.forName(prop.getProperty("databasedriver"));
		    	 System.out.println("Connecting to database...");
		    	 conn = DriverManager.getConnection(prop.getProperty("databaseurl"),prop.getProperty("databaseuser"),prop.getProperty("databasepass"));		
	    	 stmt = conn.createStatement();
	    	 String sql;
	    	 sql ="select * from userdb";
	    	 ResultSet rs = stmt.executeQuery(sql);
	    	 String id = null;
	    	 
	    	 
	    	 
	    	
	    	 while(rs.next())
	    	 {
	    		id= rs.getString("usid");
	    		
	    		String pas= rs.getString("pass");
	    		
	    		String usertype=rs.getString("usertype");
	    		
	    		if(userId.trim().equals(id)&&(password.equals(pas)))
	    		{
	    			System.out.println("Found User");
	    			session.setAttribute("userId", userId);
	    			session.setAttribute("usertype", usertype);
	    		request.getRequestDispatcher("options.jsp").forward(request, response);
	    		return;
	    		}
	    	 }
	    	 
	    	 
	    	 
	    	 if(userId.trim().equals("") )
	    	 {	
	    		 System.out.println("Blank input");
	    		 request.getRequestDispatcher("index.jsp").forward(request, response); 
	    		 rs.close();
	    	      stmt.close();
	    	      conn.close();
	    		 return;
	    		
	    	 } 
	    	 else
	    		 {
	    		 System.out.println("Failed to find the user");
	    		request.getRequestDispatcher("failed.jsp").forward(request, response);
	    		rs.close();
	    	      stmt.close();
	    	      conn.close();
	    		 }
	    	 	 
	    	
	    	 }catch(SQLException se){
	    	      //Handle errors for JDBC
	    	      se.printStackTrace();
	    	   }catch(Exception e){
	    	      //Handle errors for Class.forName
	    	      e.printStackTrace();
	    	   }finally{
	    		      //finally block used to close resources
	    		      try{
	    		         if(stmt!=null)
	    		            stmt.close();
	    		      }catch(SQLException se2){
	    		      }// nothing we can do
	    		      try{
	    		         if(conn!=null)
	    		            conn.close();
	    		      }catch(SQLException se){
	    		         se.printStackTrace();
	    		      }//end finally try
	    		   }//end try
	    	 
	   }

}
