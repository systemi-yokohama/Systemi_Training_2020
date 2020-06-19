package bbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bbs.exception.SQLRuntimeException;

/**
 * DB(コネクション関係)のユーティリティー
 */
public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.2.6:3306/test";
    private static final String USER = "testuser";
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