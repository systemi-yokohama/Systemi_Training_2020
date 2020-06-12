

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;



// public class Select {
// 	public static void main(String[] args) throws Exception {
//         String driver = "com.mysql.jdbc.Driver";
//         // 「database_name」は各環境に合わせます
//         String url = "jdbc:mysql://localhost/practice_db";
//         // MySQLに接続する際のユーザー名(デフォルトはroot)
//         String user = "root";
//         // MySQLに接続する際のパスワード(今回はroot)
//         String password = "saya3814";

//         Class.forName(driver);

//         Connection connection = DriverManager.getConnection(url,
//                 user, password);
//         connection.setAutoCommit(false);

//         select(connection);

//         connection.commit();
//         connection.close();
//     }

//     public static void select(Connection connection)
//             throws SQLException {

//         Statement statement = connection.createStatement();

//         String sql = "SELECT * FROM authors";
//         ResultSet rs = statement.executeQuery(sql);

//         System.out.println("SELECTの結果（ここから）");

//         while (rs.next()) {
//             int userId = rs.getInt("id");
//             String userName = rs.getString("name");
//             String userKana = rs.getString("kana");
//             String userGender = rs.getString("gender");

//             System.out.println(userId + ", " + userName + ", "
//                     + userKana + ", " + userGender);
//         }

//         System.out.println("SELECTの結果（ここまで）");

//         rs.close();
//         statement.close();
//     }
// }