 package service;

  import static utils.utils.CloseableUtil.*;
  import static utils.utils.DBUtil.*;

  import java.sql.Connection;

  import beans.User;
  import dao.UserDao;
  import utils.utils.CipherUtil;

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