import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
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

        insert(connection);

        Select.select(connection);

        connection.commit();
        connection.close();
    }

    public static void insert(Connection connection)
            throws SQLException {

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO authors (id, name, kana, gender) VALUES (6, '福沢諭吉', 'ふくざわゆきち', '男')";
        //SELECT文以外を実行するコード(SELECT文はstatement#executeQuery())
        int updateCount = statement.executeUpdate(sql);
        /*
        ・もう一点、SELECT文を実行するコードとの違い
        ・INSERTが成功したかどうかを確認しているコードがあること
        Statement#executeUpdate()メソッドを実行すると、「更新された行のカウント」を取得することができる。
        ここでいう更新とは、INSERT/UPDATE/DELETEの3パターンを指す。
        ただし、今回のINSERTに利用したSQL文に関しては、1行のINSERTなので、updateCountが1にならないということは考えられない。

        たとえば、1行のデータを更新しようとしたときに0が返ってくることがある。
        更新しようとした瞬間には、すでに削除されていたり、あるいはデータが更新されてWHERE句に一致しなかった場合などがある。
        更新が成功したかどうかを確認する手段として、Statement#getUpdateCount()というメソッドも用意されている。
　      また、本来であれば登録に失敗した場合はトランザクションをロールバックするところだが、
        サンプルコードでは省略し、常にコミットを行っている。
        ※普段プログラミングするときには、登録に失敗した場合は、きちんとロールバックをするようにする。
        */
        if (updateCount == 1) {
            System.out.println("登録成功");
        } else {
            System.out.println("登録失敗");
        }

        statement.close();
    }
}