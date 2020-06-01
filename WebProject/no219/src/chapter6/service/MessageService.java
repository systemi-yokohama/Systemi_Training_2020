package WebProject.no219.src.chapter6.service;

import static chapter6.utils.CloseableUtil.*;
import static chapter6.utils.DBUtil.*;

import java.sql.Connection;
import java.util.List;

import chapter6.beans.Message;
import chapter6.dao.MessageDao;

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
}