package service;

import static utils.CloseableUtil.*;
import static utils.DButil.*;

import java.sql.Connection;

import bean.Users;
import dao.UserDao;
//import utils.CipherUtil;

public class LoginService {

	public Users login(String account, String password) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
//			String encPassword = CipherUtil.encrypt(password);
			Users user = userDao.getUser(connection, account, password);

			commit(connection);

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