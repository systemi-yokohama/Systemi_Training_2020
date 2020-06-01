package WebProject.no219.src.chapter6.dao;

import static chapter6.utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chapter6.beans.User;
import chapter6.exception.NoRowsUpdatedRuntimeException;
import chapter6.exception.SQLRuntimeException;

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
}