package teamc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import teamc.beans.Branches;
import teamc.beans.Departments;
import teamc.beans.UserManagement;
import teamc.util.DBUtil;

public class UserMangementDao {

	public static List<UserManagement> select(String sql)
            throws SQLException, Exception {

		List<UserManagement> list = new ArrayList<UserManagement>();

		Connection connection = DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
        	UserManagement userManagement = new UserManagement();
        	userManagement.setAccount(rs.getString("account"));
        	userManagement.setName(rs.getString("name"));
        	userManagement.setId(rs.getInt("id"));
        	userManagement.setBranches_id(rs.getInt("branches_id"));
        	userManagement.setDepartments_id(rs.getInt("departments_id"));
        	userManagement.setCreated_at(rs.getTimestamp("created_at"));
        	userManagement.setBranches_name(rs.getString("branches.name"));
        	userManagement.setDepartments_name(rs.getString("departments.name"));
        	userManagement.setUser_stop(rs.getInt("user_stop"));
        	userManagement.setPassword(rs.getString("password"));
        	userManagement.setStop_message(rs.getString("stopmessage.name"));
        	list.add(userManagement);
        }
        connection.commit();
        connection.close();
        rs.close();
        statement.close();

        return list;



	}
	public static List<Branches>editb(String sql)
            throws SQLException, Exception {

		List<Branches> list = new ArrayList<Branches>();

		Connection connection = DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
        	Branches branches = new Branches();

        	branches.setName(rs.getString("name"));
        	branches.setId(rs.getInt("id"));

        	list.add(branches);
        }
        connection.commit();
        connection.close();
        rs.close();
        statement.close();

        return list;



	}
	public static List<Departments>editd(String sql)
            throws SQLException, Exception {

		List<Departments> list = new ArrayList<Departments>();

		Connection connection = DBUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
        	Departments departments = new Departments();

        	departments.setName(rs.getString("name"));
        	departments.setId(rs.getInt("id"));

        	list.add(departments);
        }
        connection.commit();
        connection.close();
        rs.close();
        statement.close();

        return list;



	}

	public static void update(UserManagement usermanagement)
			throws SQLException {

		Connection connection =  DBUtil.getConnection();
//sql.append
        	PreparedStatement ps = null;
            StringBuilder sql = new StringBuilder();
            sql.append("update users set user_stop=? where id=?");
			/*sql.append(" user_stop");
			sql.append(" = ");
			sql.append(" ? ");
			sql.append("where id=");
			sql.append("?");*/

          //実行するSQL文とパラメータを指定する
            ps = (PreparedStatement) connection.prepareStatement(sql.toString());


            ps.setInt(1, usermanagement.getUser_stop());
            ps.setInt(2, usermanagement.getId());


            System.out.println(ps);
            ps.executeUpdate();

            ps.close();
            connection.commit();
            connection.close();
        }

}
