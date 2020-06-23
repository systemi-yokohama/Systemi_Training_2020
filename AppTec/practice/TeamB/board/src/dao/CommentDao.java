package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Comments;
import bean.Users;
import exception.SQLRuntimeException;
import utils.DButil;

public class CommentDao {

	public void insert(Comments comment,Users user) {

		Connection connection = DButil.getConnection();
        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO comments( ");
            sql.append("comment_text");
            sql.append(", comment_user");
            sql.append(", comment_write_id");
            sql.append(") VALUES (");
            sql.append(" ?"); // text
            sql.append(", ?"); // user
            sql.append(", ?"); // write_id
            sql.append(")");


            ps = connection.prepareStatement(sql.toString());

            ps.setString(1, comment.getComment_text());
            ps.setInt(2, user.getUser_id());
            ps.setInt(3, comment.getComment_write_id());

            System.out.println(ps);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
            try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }
    }

}

