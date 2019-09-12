package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.TourData;

public class DefaultTourDao implements TourDao {
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travel  ";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "jogdogJ25";

	public static final String SELECT_TOUR_BY_NAME = "SELECT * FROM tours WHERE name = ?";
	public static final String SELECT_TOUR_BY_PRICE = "SELECT * FROM tours WHERE price < ?";
	public static final String INSERT_TOUR = "INSERT INTO tours (id, name) VALUES (?, ?)";

	@Override
	public TourData getTourByName(String name) {
		TourData tourData = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_NAME)) {
				statement.setString(1, "Tour2");
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
	public TourData getTourByPrice(double price) {
		TourData tourData = null;
		double maxPrice = 5000;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_PRICE)) {
				statement.setDouble(1, maxPrice);
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
	public boolean saveTour(TourData tourData) {
		
		int rows = 0;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(INSERT_TOUR)) {
				
				statement.setInt(1, 6);
				statement.setString(2, "Tropic paradise");
				statement.setDouble(3, 5000);
				
				rows = statement.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows != 0) {
			return true;
		} else {
		return false;
		}
	}

}
