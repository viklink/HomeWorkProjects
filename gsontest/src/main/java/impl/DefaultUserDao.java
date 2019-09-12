package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import models.UserData;

public class DefaultUserDao implements UserDao {

	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travel  ";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "jogdogJ25";

	public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ? AND name = ?";
	public static final String INSERT_USER = "INSERT INTO users (id, name) VALUES (?, ?)";
	public static final String DELETE_USER_RECORD = "DELETE FROM users WHERE id = ?";

	@Override
	public UserData getUserById(int id) {
		UserData userData = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID)) {
			statement.setInt(1, id);
			statement.setString(2, "Andrey");
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
	public boolean saveUser(UserData userData) {
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		String name = scanner.nextLine();
		String last_name = scanner.nextLine();
		int role_id = scanner.nextInt();
		int rows = 0;
		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(INSERT_USER)) {

			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, last_name);
			statement.setInt(4, role_id);

			rows = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteUserRecord() {
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USER_RECORD)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Record is deleted");
	}
	
}
