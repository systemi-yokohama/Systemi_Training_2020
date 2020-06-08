package src.chapter6.dao;

import static src.chapter6.utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import src.chapter6.beans.UserMessage;
import src.chapter6.exception.SQLRuntimeException;

public class UserMessageDao {

    public List<UserMessage> getUserMessages(Connection connection, int num) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("messages.id as id, ");
            sql.append("messages.text as text, ");
            sql.append("messages.user_id as user_id, ");
            sql.append("users.account as account, ");
            sql.append("users.name as name, ");
            sql.append("messages.created_date as created_date ");
            sql.append("FROM messages ");
            sql.append("INNER JOIN users ");
            sql.append("ON messages.user_id = users.id ");
            sql.append("ORDER BY created_date DESC limit " + num);

            ps = connection.prepareStatement(sql.toString());

            ResultSet rs = ps.executeQuery();
            List<UserMessage> ret = toUserMessageList(rs);
            return ret;
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    private List<UserMessage> toUserMessageList(ResultSet rs)
            throws SQLException {

        List<UserMessage> ret = new ArrayList<UserMessage>();
        try {
            while (rs.next()) {
                String account = rs.getString("account");
                String name = rs.getString("name");
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String text = rs.getString("text");
                Timestamp createdDate = rs.getTimestamp("created_date");

                UserMessage message = new UserMessage();
                message.setAccount(account);
                message.setName(name);
                message.setId(id);
                message.setUserId(userId);
                message.setText(text);
                message.setCreated_date(createdDate);

                ret.add(message);
            }
            return ret;
        } finally {
            close(rs);
        }
    }

}