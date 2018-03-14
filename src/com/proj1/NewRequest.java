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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class NewRequest
 */
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    	 sql ="select * from dept_list";
	    	 System.out.println(sql);
	    	 ResultSet ps = stmt.executeQuery(sql);
	    	 request.setAttribute("ps", ps);
	    	 //while(ps.next())
	    	// System.out.println(ps.getString("dep_name"));
	    		//request.getRequestDispatcher("View_Request.jsp").forward(request, response);
	    		
	    		RequestDispatcher view = request.getRequestDispatcher("New_Request.jsp");  
                view.forward(request,response);
	
	    	 ps.close();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dept=request.getParameter("department");
		String exprc=request.getParameter("experience");
		String exprt=request.getParameter("expertise");
		String desc=request.getParameter("description");
		HttpSession session=request.getSession();
		String usid=(String)session.getAttribute("userId");
			
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
	    	 sql ="insert into request(req_id,req_date,state,req_description,department,experience,expertise,usid) "
	    	 		+ "values(seq_person.nextval,SYSDATE,'New Request','"+desc+"','"+dept+"','"+exprc+"','"+exprt+"','"+usid+"')";
	    	 System.out.println(sql);
	    	 stmt.executeUpdate(sql);
	    	 request.getRequestDispatcher("Saved.jsp").forward(request, response);
	    	
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

}
