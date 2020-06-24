package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import exception.NoRowsUpdatedRuntimeException;
import exception.SQLRuntimeException;

public class UserDao {

    //SQL文を書いて実行している
    //新規ユーザーデータをDB
    public void insert(Connection connection, User user) {

        //statement=問い合わせを実行したり問い合わせの結果の取得に関するベースとなるもの

        //問い合わせ文の不正な入力を防ぐ
        PreparedStatement ps = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO users ( ");
            sql.append("account");
            sql.append(", name");
            sql.append(", email");
            sql.append(", password");
            sql.append(", description");
            sql.append(", created_date");
            sql.append(", updated_date");
            sql.append(") VALUES (");
            sql.append("?"); // account
            sql.append(", ?"); // name
            sql.append(", ?"); // email
            sql.append(", ?"); // password
            sql.append(", ?"); // description
            sql.append(", CURRENT_TIMESTAMP"); // created_date
            sql.append(", CURRENT_TIMESTAMP"); // updated_date
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

    
    //登録しているユーザーを見つけるためのSQL文
    public User getUser(Connection connection, String accountOrEmail,
            String password) {

        PreparedStatement ps = null;
        try {
            //StringBuilderを使えば？は使用しなくてもできる
            String sql = "SELECT * FROM users WHERE (account = ? OR email = ?) AND password = ?";

            //ステートメントとる
            ps = connection.prepareStatement(sql);
            ps.setString(1, accountOrEmail);
            ps.setString(2, accountOrEmail);
            ps.setString(3, password);

            //SQL文の実行
            ResultSet rs = ps.executeQuery();
            //toUserListの変数としてrsを使う

            List<User> userList = toUserList(rs);
            
            //isEmpty=文字列が空かどうか判断する
            //ユーザーが重複していたらエラーをなげて
            //ユーザーが登録されていなかったらnullを投げる
            //ユーザーが一つだけだったらユーザーのデータを投げる
            if (userList.isEmpty() == true) {
                return null;
                //ユーザーリストのサイズ（配列の数を数える＝length）を確認(格納したユーザーデータの数)
                //２個以上だとユーザーが重複していることになるからエラーを投げる
            } else if (2 <= userList.size()) {
                throw new IllegalStateException("2 <= userList.size()");
            } else {
                //インスタンスを返す(ユーザーデータの)
                return userList.get(0);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    //SQL文の各カラムの情報をひとつひとつ入れてる
    private List<User> toUserList(ResultSet rs) throws SQLException {

        List<User> ret = new ArrayList<User>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String account = rs.getString("account");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String description = rs.getString("description");
                Timestamp createdDate = rs.getTimestamp("created_date");
                Timestamp updatedDate = rs.getTimestamp("updated_date");


                //ユーザーを新しく一つのものとして作る＝インスタンス
                User user = new User();
                user.setId(id);
                user.setAccount(account);
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setDescription(description);
                user.setCreatedDate(createdDate);
                user.setUpdatedDate(updatedDate);

                ret.add(user);
            }
            return ret;
        } finally {
            close(rs);
        }
    }

    
    public User getUser(Connection connection, int id) {

    	PreparedStatement ps = null;
    	try {
    		String sql = "SELECT * FROM users WHERE id = ?";

    		ps = connection.prepareStatement(sql);
    		ps.setInt(1, id);

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

    public void update(Connection connection, User user) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET");
			sql.append("  account = ?");
			sql.append(", name = ?");
			sql.append(", email = ?");
			sql.append(", password = ?");
			sql.append(", description = ?");
			sql.append(", updated_date = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" id = ?");

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