package teamc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teamc.beans.Users;
import teamc.util.DBUtil;

public class UserDao {
	public static List<Users> select(String sql)
            throws SQLException, Exception {

		List<Users> list = new ArrayList<Users>();

		Connection connection = DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        //rsの変数に入ったデータを1行ずつ
        while (rs.next()) {
        	Users users = new Users();
        	users.setId(rs.getInt("id"));
        	users.setAccount(rs.getString("account"));
        	users.setPassword(rs.getString("password"));
        	users.setName(rs.getString("name"));
        	users.setUser_stop(rs.getInt("user_stop"));
        	users.setBranches_id(rs.getInt("branches_id"));
        	users.setDepartments_id(rs.getInt("departments_id"));
        	users.setCreated_at(rs.getTimestamp("created_at"));
        	users.setUpdated_at(rs.getTimestamp("updated_at"));
            list.add(users);
        }

        connection.commit();
        connection.close();
        statement.close();
        rs.close();

        return list;

	}

	public static void insert(Users users)
		throws IOException, SQLException {

		Connection connection = DBUtil.getConnection();


		StringBuilder sql = new StringBuilder();
		PreparedStatement ps = null;

		sql.append("INSERT INTO users ( ");
        sql.append("account");
        sql.append(", password");
        sql.append(", name");
        sql.append(", branches_id");
        sql.append(", departments_id");
        sql.append(") VALUES ( ");
        sql.append("?, "); // account
        sql.append("?, "); // name
        sql.append("?, "); // email
        sql.append("?, "); // password
        sql.append("?"); // description
        sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setString(1, users.getAccount());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getName());
            ps.setInt(4, users.getBranches_id());
            ps.setInt(5, users.getDepartments_id());
            System.out.println(ps);
            ps.executeUpdate();

            connection.commit();
            connection.close();
            ps.close();
	}

	public static void update(Users users)
		throws IOException, SQLException {

		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();

			sql.append("UPDATE users SET");
			sql.append("  account = ?");
			sql.append(", name = ?");
			sql.append(", branches_id = ?");
			sql.append(", departments_id = ?");
			sql.append(", password = ?");
			//sql.append(", updated_at = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" id = ?");

			ps = connection.prepareStatement(sql.toString());

			ps.setString(1, users.getAccount()); //アカウント
			ps.setString(2, users.getName()); //名称
			ps.setInt(3, users.getBranches_id()); //支社名
			ps.setInt(4, users.getDepartments_id()); //部署名
			ps.setString(5, users.getPassword()); //パスワード
			ps.setInt(6, users.getId()); //id

			System.out.println(ps);
			ps.executeUpdate();

            connection.commit();
			connection.close();
			ps.close();
	}
}
