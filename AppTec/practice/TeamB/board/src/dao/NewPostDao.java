package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.SQLRuntimeException;

public class NewPostDao {

    public void insert(Connection connection, Message message) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO messages ( ");
            sql.append("user_id");
            sql.append(", text");
            sql.append(", created_date");
            sql.append(", updated_date");
            sql.append(") VALUES (");
            sql.append(" ?"); // user_id
            sql.append(", ?"); // text
            sql.append(", CURRENT_TIMESTAMP"); // created_date
            sql.append(", CURRENT_TIMESTAMP"); // updated_date
            sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setInt(1, message.getUserId());
            ps.setString(2, message.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

}

