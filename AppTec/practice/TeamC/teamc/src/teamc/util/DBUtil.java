package teamc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://192.168.2.15:3306/test";
	private static final String user = "testuser";
	private static final String password = "test";

	static {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {

		try {
			Connection connection = DriverManager.getConnection(url, user,
					password);

			connection.setAutoCommit(false);

			return connection;
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

}
