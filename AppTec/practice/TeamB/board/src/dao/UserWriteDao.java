package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.UserWrite;
import exception.SQLRuntimeException;

public class UserWriteDao {

    public List<UserWrite> getUserWrite(Connection connection, int num) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("writes.write_id as id, ");
            sql.append("writes.write_subject as subject, ");
            sql.append("writes.write_text as text, ");
            sql.append("writes.write_category as category, ");
            sql.append("writes.write_user_id as user_id, ");
            sql.append("users.user_account as account, ");
            sql.append("users.user_name as name, ");
            sql.append("writes.write_created_date as created_date ");
            sql.append("FROM writes ");
            sql.append("INNER JOIN users ");
            sql.append("ON writes.write_user_id = users.user_id ");
            sql.append("ORDER BY write_created_date DESC limit " + num);

            ps = connection.prepareStatement(sql.toString());

            ResultSet rs = ps.executeQuery();
            List<UserWrite> ret = toUserWriteList(rs);
            return ret;
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    private List<UserWrite> toUserWriteList(ResultSet rs)
    		throws SQLException {

        List<UserWrite> ret = new ArrayList<UserWrite>();
        try {
            while (rs.next()) {
            	String account = rs.getString("account");
                String name = rs.getString("name");
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String text = rs.getString("text");
                Timestamp createdDate = rs.getTimestamp("created_date");

                UserWrite write = new UserWrite();
                write.setId(rs.getInt("id"));
                write.setSubject(rs.getString("subject"));
                write.setText(rs.getString("text"));
                write.setCategory(rs.getString("category"));
                write.setUserId(rs.getInt("user_id"));
                write.setAccount(rs.getString("account"));
                write.setName(rs.getString("name"));
                write.setCreated_date(rs.getTimestamp("created_date"));

                ret.add(write);
            }
            return ret;
        } finally {
            close(rs);
        }
    }
}