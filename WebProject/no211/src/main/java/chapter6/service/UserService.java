package chapter6.service;

import static chapter6.utils.CloseableUtil.*;
import static chapter6.utils.DBUtil.*;

import java.sql.Connection;

import chapter6.beans.User;
import chapter6.dao.UserDao;
import chapter6.utils.CipherUtil;

public class UserService {

    public void insert(User user) {

        Connection connection = null;
        try {
            // パスワード暗号化
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
            User user = new UserDao().select(connection, accountOrEmail, encPassword);
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