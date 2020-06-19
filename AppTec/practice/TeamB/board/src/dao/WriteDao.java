package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Users;
import bean.Writes;
import exception.SQLRuntimeException;
import utils.DButil;

public class WriteDao {

	public void insert(Writes write,Users user) {

		Connection connection = DButil.getConnection();
        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO writes( ");
            sql.append(" write_subject");
            sql.append(", write_category");
            sql.append(", write_text");
            sql.append(", write_user_id");
            sql.append(") VALUES (");
            sql.append(" ?"); // subject
            sql.append(", ?"); // category
            sql.append(", ?"); // message
            sql.append(", ?"); // id
            sql.append(")");


            ps = connection.prepareStatement(sql.toString());

            ps.setString(1, write.getWrite_subject());
            ps.setString(2, write.getWrite_category());
            ps.setString(3, write.getWrite_text());
            ps.setInt(4, user.getUser_id());

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

