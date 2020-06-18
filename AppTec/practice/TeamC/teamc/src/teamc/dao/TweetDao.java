package teamc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import teamc.beans.Tweets;
import teamc.beans.Users;
import teamc.util.DBUtil;

public class TweetDao {

	public static List<Tweets> select(String sql)
            throws SQLException, Exception {

		List<Tweets> list = new ArrayList<Tweets>();
		Connection connection =  DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
        	Tweets Tweets = new Tweets();
        	Tweets.setId(rs.getInt("id"));
        	Tweets.setSubject(rs.getString("subject"));
        	Tweets.setText(rs.getString("text"));
        	Tweets.setCategory(rs.getString("category"));
        	Tweets.setUser_id(rs.getInt("users_id"));
        	Tweets.setCreated_at(rs.getTimestamp("created_at"));
        	Tweets.setUpdated_at(rs.getTimestamp("updated_at"));
            list.add(Tweets);
        }

        connection.commit();
        connection.close();
        rs.close();
        statement.close();

        return list;

	}

	public static void insert(Tweets tweets, Users users)
			throws SQLException {

		Connection connection =  DBUtil.getConnection();

        	PreparedStatement ps = null;
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tweets ( ");
            sql.append("subject");
            sql.append(", text");
            sql.append(", category");
            sql.append(", users_id");
            sql.append(") VALUES (");
            sql.append("?"); // subject
            sql.append(", ?"); // text
            sql.append(", ?"); // category
            sql.append(", ?"); // users_id
            sql.append(")");

          //実行するSQL文とパラメータを指定する
            ps = (PreparedStatement) connection.prepareStatement(sql.toString());

            ps.setString(1, tweets.getSubject());
            ps.setString(2, tweets.getText());
            ps.setString(3, tweets.getCategory());
            ps.setInt(4, users.getId());

            //INSERT文を実行
            System.out.println(ps);
            ps.executeUpdate();

            ps.close();
            connection.commit();
            connection.close();
        }

	public static void delete(int tweet_id) throws SQLException{

		Connection connection =  DBUtil.getConnection();

		PreparedStatement ps = null;
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM tweets where id = ");
        sql.append(tweet_id);

        ps = (PreparedStatement) connection.prepareStatement(sql.toString());
        System.out.println(ps);

        ps.executeUpdate();

        ps.close();
        connection.commit();
        connection.close();
	}
}
