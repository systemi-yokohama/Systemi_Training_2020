package chapter6.service;

import static chapter6.utils.CloseableUtil.*;
import static chapter6.utils.DBUtil.*;

import java.sql.Connection;
import java.util.List;

import chapter6.beans.Message;
import chapter6.beans.UserMessage;
import chapter6.dao.MessageDao;
import chapter6.dao.UserMessageDao;
public class MessageService {

    public void insert(Message message) {

        Connection connection = null;
        try {
            connection = getConnection();
            new MessageDao().insert(connection, message);
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

    public List<UserMessage> select() {
        final int LIMIT_NUM = 1000;

        Connection connection = null;
        try {
            connection = getConnection();
            List<UserMessage> messages = new UserMessageDao().select(connection, LIMIT_NUM);
            commit(connection);

            return messages;
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