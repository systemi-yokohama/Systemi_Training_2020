
 package dao;

 import static utils.utils.CloseableUtil.*;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;

import beans.UserMessage;

 import exception.exception.SQLRuntimeException;

 public class UserMessageDao {

     public List<UserMessage> select(Connection connection, int num) {
         PreparedStatement ps = null;
         try {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT ");
             sql.append("    messages.id as id, ");
             sql.append("    messages.text as text, ");
             sql.append("    messages.user_id as user_id, ");
             sql.append("    users.account as account, ");
             sql.append("    users.name as name, ");
             sql.append("    messages.created_date as created_date ");
             sql.append("FROM messages ");
             sql.append("INNER JOIN users ");
             sql.append("ON messages.user_id = users.id ");
             sql.append("ORDER BY created_date DESC limit " + num);
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            List<UserMessage> messages = toUserMessages(rs);
             return messages;
         } catch (SQLException e) {
            throw new SQLRuntimeException(e);
         } finally {
             close(ps);
         }
     }
    private List<UserMessage> toUserMessages(ResultSet rs) throws SQLException {
        List<UserMessage> messages = new ArrayList<UserMessage>();
         try {
             while (rs.next()) {
                 UserMessage message = new UserMessage();
                 message.setId(rs.getInt("id"));
                 message.setText(rs.getString("text"));
                 message.setUserId(rs.getInt("user_id"));
                 message.setAccount(rs.getString("account"));
                 message.setName(rs.getString("name"));
                 message.setCreatedDate(rs.getTimestamp("created_date"));

                 messages.add(message);
             }
             return messages;
         } finally {
             close(rs);
         }
     }
 }