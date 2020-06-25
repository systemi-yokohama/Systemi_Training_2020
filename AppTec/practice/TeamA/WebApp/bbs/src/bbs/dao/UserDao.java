package bbs.dao;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import bbs.bean.User;
import bbs.exception.SQLRuntimeException;


public class UserDao {

	public User getUser(Connection connection, String account, String password) {
		PreparedStatement ps = null;

		try {
			//SQL文の作成
			//アカウントとパスワードを使って一致するユーザーを探す
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT * FROM users ");
			sql.append("WHERE account='");
			sql.append(account);
			sql.append("' AND ");
			sql.append("password='");
			sql.append(password);
			sql.append("'");

//			System.out.println(sql.toString());
			ps = connection.prepareStatement(sql.toString());

			//SQL文を実行
			ResultSet rs = ps.executeQuery();
			List<User> userList = toUserList(rs);

			//ログインしようとしているデータが1つだけ見つかるようにしている
            if (userList.isEmpty() == true) {
                return null;
            } else {
                //1つだけ取り出したインスタンスを返す
                return userList.get(0);
            }
        //SQLExceptionでエラー
		} catch(SQLException e) {
			throw new IllegalStateException("2 <= userList.size()");
		} finally {
			close(ps);
		}

	}

	public User getUser(Connection connection, User user) {
		StringBuilder sql = new StringBuilder();
		PreparedStatement ps = null;
		try {
//			ps = connection.prepareStatement(sql);
//			ps.setInt(1, id);
			sql.append("SELECT * FROM users WHERE account='");
			sql.append(user.getAccount());
			sql.append("'");
			ps = connection.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			List<User> userList = toUserList(rs);
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

	private List<User> toUserList(ResultSet rs) throws SQLException {

		List<User> ret = new ArrayList<User>();
		try {
			while(rs.next()) {

				//SELECT文で見つけたユーザー情報を取り出す
				int id = rs.getInt("id");
				String account = rs.getString("account");
				String password = rs.getString("password");
				String name = rs.getString("name");
				int branchId = rs.getInt("branch_id");
				int departmentId = rs.getInt("department_id");
				int status = rs.getInt("status");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp updatedDate = rs.getTimestamp("updated_date");

				//見つけたユーザーでインスタンス作成
				User user = new User();
				user.setId(id);
				user.setAccount(account);
				user.setPassword(password);
				user.setName(name);
				user.setBranchId(branchId);
				user.setDepartmentId(departmentId);
				user.setStatus(status);
				user.setCreatedDate(createdDate);
				user.setUpdatedDate(updatedDate);

				//ユーザーリストにユーザーを追加
				ret.add(user);
			}
			//ユーザーリストを返す
			return ret;
		} finally {
			close(rs);
		}

	}

	public void insert(Connection connection, User user) {
		//問い合わせ文の不正な入力を防ぐ
        PreparedStatement ps = null;
        try {
        //SQL文
	        StringBuilder sql = new StringBuilder();
	        sql.append("INSERT INTO users ( ");
	        sql.append("account");
	        sql.append(", password");
	        sql.append(", name");
	        sql.append(", branch_id");
	        sql.append(", department_id");
	        sql.append(", status");
	        sql.append(", created_date");
	        sql.append(", updated_date");
	        sql.append(") VALUES ('");
	        sql.append(user.getAccount()); //account
	        sql.append("', '");
	        sql.append(user.getPassword());//password
	        sql.append("', '");
	        sql.append(user.getName()); //name
	        sql.append("', '");
	        sql.append(user.getBranchId());//branch_id
	        sql.append("', '");
	        sql.append(user.getDepartmentId());//department_id
	        sql.append("', 1"); //status
	        sql.append(", CURRENT_TIMESTAMP"); // created_date
	        sql.append(", CURRENT_TIMESTAMP"); // updated_date
	        sql.append(")");
	        ps = connection.prepareStatement(sql.toString());
	        System.out.println(sql.toString());
	        int rs = ps.executeUpdate();
	        System.out.println(rs);
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
	}

	public boolean getOldUser(Connection connection, String account, String oldAccount) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		connection = getConnection();
		List<User> ret = new ArrayList<User>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM users ");
			sql.append("WHERE account='");
			sql.append(account);
			sql.append("'");
			System.out.println(sql.toString());
			ps = connection.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			ret = toUserList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}

		if(ret.isEmpty() == true) {
			return true;
		} else {
			if (account.equals(oldAccount)) {
				return true;
			}
			return false;
		}

	}

	public void update(Connection connection, User user, String oldAccount) {
		PreparedStatement ps = null;
		boolean flg = false;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET");
			if (!(StringUtils.isBlank(user.getAccount()))) {
				sql.append(" account='");
				sql.append(user.getAccount());
				sql.append("'");
				flg = true;
			}
			if (!(StringUtils.isBlank(user.getPassword()))) {
				if (flg) {
					sql.append(", password='");
					sql.append(user.getPassword());
					sql.append("'");
				} else {
					sql.append(" password='");
					sql.append(user.getPassword());
					sql.append("'");
					flg = true;
				}
			}
			if (!(StringUtils.isBlank(user.getName()))) {
				if (flg) {
					sql.append(", name='");
					sql.append(user.getName());
					sql.append("'");
				} else {
					sql.append(" name='");
					sql.append(user.getName());
					sql.append("'");
					flg = true;
				}
			}
			if (user.getBranchId() != 0) {
				if (flg) {
					sql.append(", branch_id='");
					sql.append(user.getBranchId());
					sql.append("'");
				} else {
					sql.append(" branch_id='");
					sql.append(user.getBranchId());
					sql.append("'");
					flg = true;
				}
			}
			if(user.getDepartmentId() != 0) {
				if (flg) {
					sql.append(", department_id='");
					sql.append(user.getDepartmentId());
					sql.append("'");
				} else {
					sql.append(" department_id='");
					sql.append(user.getDepartmentId());
					sql.append("'");
					flg = true;
				}
			}
			sql.append(", updated_date = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" account='");
			sql.append(oldAccount);
			sql.append("'");

			System.out.println(sql.toString());

			ps = connection.prepareStatement(sql.toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

}
