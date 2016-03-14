package pt.americolib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

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
	private JdbcTemplate jdbcTemplate;
	
	//CONSTRUCTOR
/*	public Circle getCircle(int circleId) {
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
	*/

	//GETTERS AND SETTERS
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
	
	/* CREATE */
	/** CREATE: insert a new circle in the table */
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";	
		jdbcTemplate.update( sql, new Object[] {circle.getId(), circle.getName()} );
	}
	
	/** CREATE: create a new table from a new type */
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE ( ID INTEGER, NAME VARCHAR(50) )";	
		jdbcTemplate.execute(sql);
	}
	
	/* RETRIEVE: fetch data from table */
	/** RETRIEVE: get a total count of ID values*/
	public int getCircleCount() {
		//QUERY
		String sql = "SELECT COUNT(ID) FROM CIRCLE";	
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/** RETRIEVE: get a circle name from a specific ID*/
	public String getCircleName(int circleId) {
		//QUERY
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";	
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	/** RETRIEVE: get a circle object for a certain ID */
	public Circle getCircleForId(int circleId) {
		//QUERY
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	/** RETRIEVE: get all circles from the table */
	public List<Circle> getAllCircles() {
		//QUERY
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	/* UPDATE */
	//...
	
	/* DELETE */
	//...
	
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
