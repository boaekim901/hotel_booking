package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		Context initContext;
		try {
			initContext = new InitialContext();
		
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
    public  static void  close(Connection  conn,  Statement  stmt,  ResultSet  rs)  {
    	try { 
	    	if (conn != null) { 
	    		 if (!conn.isClosed()) {
	    			 conn.close();
	    		 }
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	try { 
	    	if (stmt != null) { 
	    		 if (!stmt.isClosed()) {
	    			 stmt.close();
	    		 }
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
        try { 
        	if (rs != null) { 
        		 if (!rs.isClosed()) {
        			 rs.close();
        		 }
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    

    // insert, update, delete 수행 후 리소스 해제 메소드
    public  static  void  close(Connection  conn, Statement  stmt) {
    	try { 
	    	if (conn != null) { 
	    		 if (!conn.isClosed()) {
	    			 conn.close();
	    		 }
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	try { 
	    	if (stmt != null) { 
	    		 if (!stmt.isClosed()) {
	    			 stmt.close();
	    		 }
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
