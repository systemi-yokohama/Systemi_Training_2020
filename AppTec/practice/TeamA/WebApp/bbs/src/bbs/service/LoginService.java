package bbs.service;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.sql.Connection;

import bbs.bean.User;
import bbs.dao.UserDao;

public class LoginService {

	public User login(String account, String password) {
		Connection connection = null;
		try {
			//コネクションをとる(DBUtil.javaのメソッド)
			connection = getConnection();

			//UserDaoをインスタンス化
			UserDao userDao = new UserDao();
			//パスワードを暗号化
//			String encPassword = CipherUtil.encrypt(password);
			//SQL文の実行
//			User user = userDao.getUser(connection, account, encPassword);
			User user = userDao.getUser(connection, account, password);
			//SQL処理の完了
			commit(connection);

			//ログインしようとしているユーザーのデータを返す
			return user;
		} catch (RuntimeException e) {
			rollback(connection);
			throw e;
		} catch (Error e) {
			rollback(connection);
			throw e;
		} finally {
			//成功しても失敗してもconnectionをクローズする
			close(connection);
		}
	}
}
