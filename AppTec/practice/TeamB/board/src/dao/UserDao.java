package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Users;
import exception.SQLRuntimeException;

public class UserDao {

    public void insert(Connection connection, Users user) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO users ( ");
            sql.append("user_id");
            sql.append(", user_account");
            sql.append(", user_password");
            sql.append(", user_name");
            sql.append(", user_office");
            sql.append(", user_department");
            sql.append(", user_status");
            sql.append(", user_created_date");
            sql.append(", user_update_date");
            sql.append(") VALUES (");
            sql.append("?"); // id
            sql.append(", ?"); // account
            sql.append(", ?"); // password
            sql.append(", ?"); // name
            sql.append(", ?"); // office
            sql.append(", ?"); // department
            sql.append(", ?"); // status
            sql.append(", CURRENT_TIMESTAMP"); // created_date
            sql.append(", CURRENT_TIMESTAMP"); // updated_date
            sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setInt(1, user.getUser_id());
            ps.setString(2, user.getUser_account());
            ps.setString(3, user.getUser_password());
            ps.setString(4, user.getUser_name());
            ps.setString(5, user.getUser_office());
            ps.setString(6, user.getUser_department());
            ps.setString(7, user.getUser_status());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    public Users getUser(Connection connection, String account,
            String password) {

        PreparedStatement ps = null;
        try {
//            String sql = "SELECT * FROM users WHERE user_account = ? AND user_password = ?";
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM users WHERE user_account = '");
            sql.append(account);
            sql.append("'");
            sql.append(" AND user_password = '");
            sql.append(password);
            sql.append("'");
            sql.append(" AND user_status = 0");



            ps = connection.prepareStatement(sql.toString());

            System.out.println(sql.toString());

            ResultSet rs = ps.executeQuery();
            List<Users> usersList = toUserList(rs);
            if (usersList.isEmpty() == true) {
                return null;
            } else if (2 <= usersList.size()) {
                throw new IllegalStateException("2 <= userList.size()");
            } else {
                return usersList.get(0);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    private List<Users> toUserList(ResultSet rs) throws SQLException {

        List<Users> ret = new ArrayList<Users>();
        try {
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String account = rs.getString("user_account");
                String password = rs.getString("user_password");
                String name = rs.getString("user_name");
                String office = rs.getString("user_office");
                String department = rs.getString("user_department");
                String status = rs.getString("user_status");
                Timestamp createdDate = rs.getTimestamp("user_created_date");
                Timestamp updatedDate = rs.getTimestamp("user_updated_date");



                Users users = new Users();
                users.setUser_id(id);
                users.setUser_account(account);
                users.setUser_password(password);
                users.setUser_name(name);
                users.setUser_office(office);
                users.setUser_department(department);
                users.setUser_status(status);
                users.setUser_created_date(createdDate);
                users.setUser_updated_date(updatedDate);

                ret.add(users);
            }
            return ret;
        } finally {
            close(rs);
        }
    }

    public Users getUser(Connection connection, int id) {

    	PreparedStatement ps = null;
    	try {
    		String sql = "SELECT * FROM users WHERE account = ?";

    		ps = connection.prepareStatement(sql);
    		ps.setInt(1, id);

    		ResultSet rs = ps.executeQuery();
    		List<Users> userList = toUserList(rs);
    		if (userList.isEmpty() == true) {
    			return null;
    		} else if (2 <= userList.size()) {
    			throw new IllegalStateException("2 <= userList.size()");
    		} else {
    			return userList.get(0);
    		}
    	} catch (SQLException e) {
    		throw new SQLRuntimeException(e);
    	} finally {
    		close(ps);
    	}
    }

//    public void update(Connection connection, Users users) {
//
//		PreparedStatement ps = null;
//		try {
//			StringBuilder sql = new StringBuilder();
//			sql.append("UPDATE users SET");
//			sql.append("  user_id = ?");
//			sql.append(", user_account = ?");
//			sql.append(", user_password = ?");
//			sql.append(", user_name = ?");
//			sql.append(", user_office = ?");
//			sql.append(", user_department = ?");
//			sql.append(", user_status = ?");
//			sql.append(", user_updated_date = CURRENT_TIMESTAMP");
//			sql.append(" WHERE");
//			sql.append(" user_id = ?");
//
//			ps = connection.prepareStatement(sql.toString());
//
//			ps.setString(1, users.getUser_account());
//			ps.setString(2, users.getUser_password());
//			ps.setString(3, users.getUser_name());
//			ps.setString(4, users.getUser_office());
//			ps.setString(5, users.getUser_department());
//			ps.setString(6, users.getUser_status());
//			ps.setInt(7, users.getUser_id());
//
//			int count = ps.executeUpdate();
//			if (count == 0) {
//				throw new NoRowsUpdatedRuntimeException();
//			}
//		} catch (SQLException e) {
//			throw new SQLRuntimeException(e);
//		} finally {
//			close(ps);
//		}
//
//	}

}