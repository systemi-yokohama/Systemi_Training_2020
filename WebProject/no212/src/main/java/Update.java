import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        // 「database_name」は各環境に合わせます
        String url = "jdbc:mysql://localhost/practice_db";
        // MySQLに接続する際のユーザー名(デフォルトはroot)
        String user = "root";
        // MySQLに接続する際のパスワード(今回はroot)
        String password = "root";

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url,user, password);
        connection.setAutoCommit(false);

        update(connection);

        Select.select(connection);

        connection.commit();
        connection.close();
    }
    //コードの内容はINSERT文と同じ
    public static void update(Connection connection)
            throws SQLException {

        Statement statement = connection.createStatement();

        String sql = "UPDATE authors SET gender = '女' WHERE id = 6";
        int updateCount = statement.executeUpdate(sql);

        if (updateCount == 1) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失敗");
        }

        statement.close();
    }
}