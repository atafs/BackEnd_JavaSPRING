package pt.americolib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pt.americolib.model.Circle;

public class JdbcDaoImpl {
	
	public Circle getCircle(int circleId) {
		Connection conn = null;
		try {
		//1- CONNECTION
		String driver = "org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		
		//2- PREPARE STATEMENT
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
		ps.setInt(1,  circleId);
		
		//3- EXECUTE QUERY
		Circle circle = null;
		ResultSet rs = ps.executeQuery();
		
		//4- PARSING THE RESULT SET
		if (rs.next()) {
			circle = new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
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
