package service;

//staticをつけることでメソッドの呼び出しにクラス名がいらない
import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.CipherUtil;

public class LoginService {

	public User login(String accountOrEmail, String password) {

		//コネクションを定義
		Connection connection = null;
		try {
			//コネクションをとる（DBUtil.javaのメソッド）
			connection = getConnection();

			//UserDaoをインスタンス化＝インスタンスメソッドが使える
			UserDao userDao = new UserDao();
			//パスワードを暗号化
			String encPassword = CipherUtil.encrypt(password);
			//SQL文の実行
			User user = userDao.getUser(connection, accountOrEmail, encPassword);
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