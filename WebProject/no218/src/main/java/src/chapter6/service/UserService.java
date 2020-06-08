package src.chapter6.service;

import static src.chapter6.utils.CloseableUtil.*;
import static src.chapter6.utils.DBUtil.*;

import java.sql.Connection;

import src.chapter6.beans.User;
import src.chapter6.dao.UserDao;
import src.chapter6.utils.CipherUtil;

public class UserService {

    public void register(User user) {

        Connection connection = null;
        try {
            connection = getConnection();

            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);

            UserDao userDao = new UserDao();
            userDao.insert(connection, user);

            commit(connection);
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

    public User getUser(int userId) {

    	Connection connection = null;
    	try {
    		connection = getConnection();

    		UserDao userDao = new UserDao();
    		User user = userDao.getUser(connection, userId);

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

    public void update(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			String encPassword = CipherUtil.encrypt(user.getPassword());
			user.setPassword(encPassword);

			UserDao userDao = new UserDao();
			userDao.update(connection, user);

			commit(connection);
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