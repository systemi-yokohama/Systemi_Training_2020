package bbs.service;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.sql.Connection;
import java.util.List;

import bbs.bean.UserCC;
import bbs.dao.ContributionCommentDao;

public class ContributionService {

    public List<UserCC> getContribution() {

    	Connection connection = null;
    	try {
    		//コネクションをとる
    		connection = getConnection();

    		//SQL文を通った投稿のインスタンスリストを受け取る
    		ContributionCommentDao contributionDao = new ContributionCommentDao();
    		List<UserCC> ret = contributionDao.getUserCC(connection);

    		commit(connection);
            //投稿のリストを返す
    		return ret;

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
