package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.SQLRuntimeException;

public class DButil {

	// どのドライバを使うか指定（今回はmysql）
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    // 接続するDBのURLを変数に入れる
	private static final  String URL= "jdbc:mysql://192.168.2.5/board";;
    // MySQLに接続する際のユーザー名(デフォルトはroot)
	private static final String USER = "testuser";
    // MySQLに接続する際のパスワード(今回はroot)
	private static final String PASSWORD = "test";

    static {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * コネクションを取得します。
     *
     * @return
     */
    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }

    /**
     * コミットします。
     *
     * @param connection
     */
    public static void commit(Connection connection) {

        try {
            connection.commit();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }

    /**
     * ロールバックします。
     *
     * @param connection
     */
    public static void rollback(Connection connection) {

        if (connection == null) {
            return;
        }

        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }
}
