package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.CipherUtil;

public class LoginService {

	//loginメソッドを作る
	public User login(String accountOrEmail, String password) {

		//tryでもcatchでも使うからここで定義
		Connection connection = null;

		try {
			//javasqlconnectionにあるのとつなげる
			connection = getConnection();

			UserDao userDao = new UserDao();
			String encPassword = CipherUtil.encrypt(password);
			//インスタンスしないと使えないからUserDaoでインスタンス生成する
			User user = userDao.getUser(connection, accountOrEmail, encPassword);

			//コミットする理由？
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
			close(connection);
		}
	}

}