package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.CipherUtil;

public class UserService {

    public void register(User user) {

        Connection connection = null;
        try {
            connection = getConnection();

			//パスワードの暗号化
            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);

			UserDao userDao = new UserDao();
			//接続とuser情報を引数にしてSQL文（新規登録）を実行
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

	//更新のコネクション作成とSQL文の実行
    public void update(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			String encPassword = CipherUtil.encrypt(user.getPassword());
			user.setPassword(encPassword);

			UserDao userDao = new UserDao();
			//UserDaoでupdateをする
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