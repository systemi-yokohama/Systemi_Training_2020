import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete {
	public static void main(String[] args) throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        // 「database_name」は各環境に合わせます
        String url = "jdbc:mysql://localhost/practice_db";
        // MySQLに接続する際のユーザー名(デフォルトはroot)
        String user = "root";
        // MySQLに接続する際のパスワード(今回はroot)
        String password = "saya3814";

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url,
                user, password);
        connection.setAutoCommit(false);

        delete(connection);

        Select.select(connection);

        connection.commit();
        connection.close();
    }

    public static void delete(Connection connection)
            throws SQLException {

        Statement statement = connection.createStatement();

        String sql = "DELETE FROM authors WHERE id = 6";
        int updateCount = statement.executeUpdate(sql);

        if (updateCount == 1) {
            System.out.println("削除成功");
        } else {
            System.out.println("削除失敗");
        }

        statement.close();
    }
}