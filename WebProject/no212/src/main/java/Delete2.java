//削除する行を特定するためのIDをdeleteメソッドの引数で渡すようにしたコード
/*ブラウザから1 OR id = idというデータを受け取った場合DELETE FROM authors WHERE id = 1 OR id = id;となり
「id = 1」のうしろに「OR id = id」と続いているので、全レコードが削除対象となってしまい、
データがすべて消えてしまうという恐ろしい事態が発生する。
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete2 {
  public static void main(String[] args) throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    // 「database_name」は各環境に合わせます
    String url = "jdbc:mysql://localhost/practice_db";
    // MySQLに接続する際のユーザー名(デフォルトはroot)
    String user = "root";
    // MySQLに接続する際のパスワード(今回はroot)
    String password = "root";

    Class.forName(driver);

    Connection connection = DriverManager.getConnection(url,
        user, password);
    connection.setAutoCommit(false);

    String deleteId = "6";

    delete(connection, deleteId);

    Select.select(connection);

    connection.commit();
    connection.close();
  }

  public static void delete(Connection connection,
      String deleteId) throws SQLException {

    Statement statement = connection.createStatement();

    String sql = "DELETE FROM authors WHERE id = " + deleteId;
    int updateCount = statement.executeUpdate(sql);

    if (updateCount == 1) {
      System.out.println("削除成功");
    } else {
      System.out.println("削除失敗");
    }

    statement.close();
  }
}