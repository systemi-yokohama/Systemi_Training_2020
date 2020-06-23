package teamc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import teamc.beans.Comments;
import teamc.beans.Users;
import teamc.util.DBUtil;

public class CommentDao {
	public static List<Comments> select(String sql)
            throws SQLException, Exception {

		List<Users> userList = null;
		List<Comments> list = new ArrayList<Comments>();
		Connection connection =  DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        userList = UserDao.select("select * from users;");

        while (rs.next()) {
        	Comments comments = new Comments();
        	comments.setId(rs.getInt("id"));
        	comments.setText(rs.getString("text"));
        	comments.setTweets_id(rs.getInt("tweets_id"));
        	comments.setUser_id(rs.getInt("users_id"));
        	comments.setCreated_at(rs.getTimestamp("created_at"));
        	comments.setUpdated_at(rs.getTimestamp("updated_at"));

        	for (Users user : userList) {
				if (rs.getInt("users_id") == user.getId()) {
					comments.setUser(user);
					break;
				}
			}

            list.add(comments);

        }

        connection.commit();
        connection.close();
        statement.close();
        rs.close();

        return list;

	}

	public static void insert(Comments comments)
			throws SQLException {

		Connection connection =  DBUtil.getConnection();

        	PreparedStatement ps = null;
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO comments ( ");
            sql.append("text");
            sql.append(", users_id");
            sql.append(", tweets_id");
            sql.append(") VALUES (");
            sql.append("?"); // text
            sql.append(", ?"); // users_id
            sql.append(", ?"); // tweets_id
            sql.append(")");

          //実行するSQL文とパラメータを指定する
            ps = (PreparedStatement) connection.prepareStatement(sql.toString());

            ps.setString(1, comments.getText());
            ps.setInt(2, comments.getUser_id());
            ps.setInt(3, comments.getTweets_id());

            //INSERT文を実行
            System.out.println(ps);
            ps.executeUpdate();

            connection.commit();
            connection.close();
            ps.close();
        }

	public static void delete(int comment_id) throws SQLException{

		Connection connection =  DBUtil.getConnection();

		PreparedStatement ps = null;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM comments where id = ");
        sql.append(comment_id);

        ps = (PreparedStatement) connection.prepareStatement(sql.toString());
        System.out.println(ps);

        ps.executeUpdate();

        connection.commit();
        connection.close();
        ps.close();
	}

}
