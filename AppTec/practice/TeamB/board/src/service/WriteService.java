//package service;
//
//import static utils.CloseableUtil.*;
//import static utils.DButil.*;
//
//import java.sql.Connection;
//import java.util.List;
//
//import bean.UserWrite;
//import bean.Writes;
//import dao.UserWriteDao;
//import dao.WriteDao;
//
//
//public class WriteService {
//
//    public void register(Writes write) {
//
//        Connection connection = null;
//        try {
//            connection = getConnection();
//
//            WriteDao writeDao = new WriteDao();
//            writeDao.insert(connection, write);
//
//            commit(connection);
//        } catch (RuntimeException e) {
//            rollback(connection);
//            throw e;
//        } catch (Error e) {
//            rollback(connection);
//            throw e;
//        } finally {
//            close(connection);
//        }
//    }
//
//    private static final int LIMIT_NUM = 1000;
//
//    public List<UserWrite> getWrite() {
//
//    	Connection connection = null;
//    	try {
//    		connection = getConnection();
//
//    		UserWriteDao writeDao = new UserWriteDao();
//    		List<UserWrite> ret = writeDao.getUserWrite(connection, LIMIT_NUM);
//
//    		commit(connection);
//
//    		return ret;
//    	} catch (RuntimeException e) {
//    		rollback(connection);
//    		throw e;
//    	} catch (Error e) {
//    		rollback(connection);
//    		throw e;
//    	} finally {
//    		close(connection);
//    	}
//    }
//
//}