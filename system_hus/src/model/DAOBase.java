package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOBase implements DAO {
			
	@Override
	public Connection getConnection() throws SQLException {
		String jdbc_driver = "org.mariadb.jdbc.Driver";
        String db_url = "jdbc:mariadb://localhost:3306/workerdb";
                
        try{
        	Class.forName(jdbc_driver);
        	Connection conn = DriverManager.getConnection(db_url,"java","java");
        	return conn;
        	
        } catch(Exception e) {
             e.printStackTrace();
             System.out.println("connect error");
        }
         return null;		
	}
	
	public void closeDBResources(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("resultSet close error");
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("stmt or pstmt close error");
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("connection close error");
			}
		}
	}

}
