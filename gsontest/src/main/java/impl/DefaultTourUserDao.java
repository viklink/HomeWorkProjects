package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.TourData;
import models.UserData;

public class DefaultTourUserDao implements TourUserDao {
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travel  ";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "jogdogJ25";
	
	public static final String SELECT_TOUR_BY_USER_ID = "SELECT t.name as tour_name, u.name as user_name FROM tours_users tu\r\n" + 
			"JOIN users u ON u.id = tu.user_id" + 
			"JOIN tours t ON t.id = tu.tour_id" + 
			"WHERE u.name = Andrey";
	public static final String SELECT_USER_BY_TOUR_COUNT = "SELECT u.name, COUNT(u.id) as tours FROM tours_users tu " + 
			"JOIN users u ON u.id = tu.user_id " + 
			"GROUP BY u.id " + 
			"HAVING(COUNT(u.id)>1)";
	
	private Connection getConnection() {
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME + PARAMS, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TourData getTourByUserId(int user_id) {
		TourData tourData = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_USER_ID)) {
				statement.setInt(1, 3);
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						tourData = new TourData();
						tourData.setId(rs.getInt("id"));
						tourData.setName(rs.getString("name"));
						tourData.setPrice(rs.getDouble("price"));
						}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tourData;
	}
	

	@Override
	public UserData getUserByTourCount() {
		UserData userData = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_TOUR_COUNT)) {
			
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("id"));
						userData.setName(rs.getString("name"));
						userData.setLastName(rs.getString("last_name"));
						userData.setRoleId(rs.getInt("role_id"));
						}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userData;
	}

}
