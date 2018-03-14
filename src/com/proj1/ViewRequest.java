package com.proj1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class ViewRequest
 */
public class ViewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String i=request.getParameter("i");
	 String req_id =(String)session.getAttribute("tmp"+i);
	 session.setAttribute("tmp",req_id);
		
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
	    	 String sql ="update request SET state='Cancelled Request' where req_id='"+req_id+"'";
	    	 
	    	 System.out.println(sql);
	    	 stmt.executeUpdate(sql);
	    	 request.getRequestDispatcher("CancelReq.jsp").forward(request, response);
	    	
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
	               conn.close();
	         }catch(SQLException se){
	         }// do nothing
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      }//end try
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String usid=(String)session.getAttribute("userId");
	
    	 if(usid==null) {
    		 request.getRequestDispatcher("index.jsp").forward(request, response); 
    		 return;
    	 }
		
		
		
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
	    	 sql ="select * from request where usid= '"+usid+"' order by req_id";
	    	 System.out.println(sql);
	    	 ResultSet rs = stmt.executeQuery(sql);
	    	 request.setAttribute("rs", rs);
	    	// while(rs.next())
		    	// System.out.println(rs.getString("req_id"));
	    		//request.getRequestDispatcher("View_Request.jsp").forward(request, response);
	    		
	    		RequestDispatcher view = request.getRequestDispatcher("View_Request.jsp");  
                view.forward(request,response);
	
	    	 rs.close();
	    	 stmt.close();
	    	 conn.close();
	    		
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
