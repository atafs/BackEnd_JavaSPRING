package pt.americolib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pt.americolib.model.Circle;

@Component
public class JdbcDaoImpl {
	
	//ATTRIBUTE
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public Circle getCircle(int circleId) {
		Connection conn = null;
		try {
		//1- CONNECTION
		conn = dataSource.getConnection();
		
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

	//GETTERS NAD SETTERS
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "\tdataSource = " + this.dataSource;
		toReturn += "\tjdbcTemplate = " + this.jdbcTemplate;
		return toReturn;
	}
	
	/** METHOD: get count for total of ID values*/
	public int getCircleCount() {
		//QUERY
		String sql = "SELECT COUNT(ID) FROM CIRCLE";	
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/** METHOD: get a circle name from a specific ID*/
	public String getCircleName(int circleId) {
		//QUERY
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";	
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	/** METHOD: get a specific circle for a certain ID */
	public Circle getCircleForId(int circleId) {
		//QUERY
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	/** */
	public List<Circle> getAllCircles() {
		//QUERY
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	/** INNER CLASS */
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {

			//INSTANTIATE
			Circle circle = new Circle();
			circle.setId(rs.getInt("ID"));
			circle.setName(rs.getString("NAME"));
			return circle;
		}


		
	}

}
