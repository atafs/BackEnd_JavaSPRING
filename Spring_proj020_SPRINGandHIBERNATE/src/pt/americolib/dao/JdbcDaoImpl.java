package pt.americolib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pt.americolib.model.Circle;

@Component
public class JdbcDaoImpl {
	
	//ATTRIBUTE
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//GETTERS AND SETTERS
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//NOT THE BEST PATTERN
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
	/** CREATE: insert a new circle in the table using parameters instead of hardcode */
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";	
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
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
