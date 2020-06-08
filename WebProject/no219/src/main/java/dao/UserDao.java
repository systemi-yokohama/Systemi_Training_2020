package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import exception.NoRowsUpdatedRuntimeException;
import exception.SQLRuntimeException;

public class UserDao {

    public void insert(Connection connection, User user) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO users ( ");
            sql.append("    account, ");
            sql.append("    name, ");
            sql.append("    email, ");
            sql.append("    password, ");
            sql.append("    description, ");
            sql.append("    created_date, ");
            sql.append("    updated_date ");
            sql.append(") VALUES ( ");
            sql.append("    ?, ");                                  // account
            sql.append("    ?, ");                                  // name
            sql.append("    ?, ");                                  // email
            sql.append("    ?, ");                                  // password
            sql.append("    ?, ");                                  // description
            sql.append("    CURRENT_TIMESTAMP, ");  // created_date
            sql.append("    CURRENT_TIMESTAMP ");       // updated_date
            sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setString(1, user.getAccount());
            
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getDescription());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }
    public User select(Connection connection, String accountOrEmail, String password) {

        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM users WHERE (account = ? OR email = ?) AND password = ?";

            ps = connection.prepareStatement(sql);

            ps.setString(1, accountOrEmail);
            ps.setString(2, accountOrEmail);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            List<User> users = toUsers(rs);
            if (users.isEmpty()) {
                return null;
            } else if (2 <= users.size()) {
                throw new IllegalStateException("ユーザーが重複しています");
            } else {
                return users.get(0);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    private List<User> toUsers(ResultSet rs) throws SQLException {

        List<User> users = new ArrayList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setAccount(rs.getString("account"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setDescription(rs.getString("description"));
                user.setCreatedDate(rs.getTimestamp("created_date"));
                user.setUpdatedDate(rs.getTimestamp("updated_date"));

                users.add(user);
            }
            return users;
        } finally {
            close(rs);
        }
    }
    public User select(Connection connection, int id) {

        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
    
            ps = connection.prepareStatement(sql);
    
            ps.setInt(1, id);
    
            ResultSet rs = ps.executeQuery();
    
            List<User> users = toUsers(rs);
            if (users.isEmpty()) {
                return null;
            } else if (2 <= users.size()) {
                throw new IllegalStateException("ユーザーが重複しています");
            } else {
                return users.get(0);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }
    public void update(Connection connection, User user) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE users SET ");
            sql.append("    account = ?, ");
            sql.append("    name = ?, ");
            sql.append("    email = ?, ");
            sql.append("    password = ?, ");
            sql.append("    description = ?, ");
            sql.append("    updated_date = CURRENT_TIMESTAMP ");
            sql.append("WHERE id = ?");
    
            ps = connection.prepareStatement(sql.toString());
    
            ps.setString(1, user.getAccount());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getDescription());
            ps.setInt(6, user.getId());
    
            int count = ps.executeUpdate();
            if (count == 0) {
                throw new NoRowsUpdatedRuntimeException();
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }
}