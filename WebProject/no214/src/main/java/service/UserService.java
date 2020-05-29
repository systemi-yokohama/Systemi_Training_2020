 package service;

  import static utils.utils.CloseableUtil.*;
  import static utils.utils.DBUtil.*;

  import java.sql.Connection;

  import beans.User;
  import dao.UserDao;
  import utils.utils.CipherUtil;

  public class UserService {

    public void insert(User user) {

        Connection connection = null;
        try {
            // パスワード暗号化
            //encrypt：リポジトリに登録されている暗号形式に合わせてPWを暗号化する
            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);

            connection = getConnection();
            new UserDao().insert(connection, user);
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
    public User select(String accountOrEmail, String password) {
        Connection connection = null;
        try {
            // パスワード暗号化
            String encPassword = CipherUtil.encrypt(password);
           connection = getConnection();
            User user = new UserDao().select(connection, accountOrEmail, encPassword);//引数の数が合わない
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
				// パスワード暗号化
				String encPassword = CipherUtil.encrypt(user.getPassword());
				user.setPassword(encPassword);
		
				connection = getConnection();
				new UserDao().update(connection, user);
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
  