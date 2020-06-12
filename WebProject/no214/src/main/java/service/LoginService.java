package service;

import static utils.utils.CloseableUtil.*;
import static utils.utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.utils.CipherUtil;

public class LoginService {

	public User login(String accountOrEmail, String password) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			String encPassword = CipherUtil.encrypt(password);
			User user = userDao.getUser(connection, accountOrEmail, encPassword);

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