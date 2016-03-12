package pt.americolib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pt.americolib.model.Circle;

public class JdbcDaoImpl {
	
	public Circle getCircle(int circleId) {
		
		//TALK TO THE DATABASE
		Connection conn = null;
		
		try {
		//DRIVER
		String driver = "org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver).newInstance();
		
		//CONNECTION
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		
		//STATEMENT
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
		ps.setInt(1,  circleId);
		
		//EXECUTE QUERY
		Circle circle = null;
		ResultSet rs = ps.executeQuery();
		
		//CHECK IF THERE IS A RECORD TO ASSIGN
		if (rs.next()) {
			circle = new Circle(circleId, rs.getString("name"));
		}
		
		//CLOSE
		rs.close();
		ps.close();
		
		//OBJECT
		return circle;
	
		} catch(Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
