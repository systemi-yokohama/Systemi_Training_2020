package bbs.dao;

import static bbs.util.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bbs.bean.Comment;
import bbs.bean.UserCC;
import bbs.exception.SQLRuntimeException;

public class ContributionCommentDao {

    public List<UserCC> getUserCC(Connection connection) {

    	//投稿のリスト作成
    	List<UserCC> ret = new ArrayList<UserCC>();

        PreparedStatement psCb = null;
        PreparedStatement psCm = null;

        ResultSet rsCb = null;
        ResultSet rsCm = null;

        try {
            //投稿を降順に10件まで表示させるSQL文の作成

        	String sqlCb = "SELECT * FROM contributions";
//            StringBuilder sqlCb = new StringBuilder();
//            sqlCb.append("SELECT * FROM contributions LIMIT ");
//            sqlCb.append();
            String sqlCm = "SELECT * FROM comments";

            psCb = connection.prepareStatement(sqlCb);
            psCm = connection.prepareStatement(sqlCm);

            rsCb = psCb.executeQuery();
            rsCm = psCm.executeQuery();

            //投稿一つ分を取り出す
            while (rsCb.next()) {

            	//投稿とコメントが一つになったインスタンスを生成
            	UserCC userCC = new UserCC();

    			userCC.setCbUserAccount(rsCb.getString("user_account"));
    			userCC.setCbId(rsCb.getInt("id"));
    			userCC.setCbTitle(rsCb.getString("title"));
    			userCC.setCbText(rsCb.getString("text"));
    			userCC.setCbCategory(rsCb.getString("category"));
    			userCC.setCbCreatedDate(rsCb.getDate("created_date"));

    			//インスタンスの中のコメントリストを定義
            	List<Comment> comments = new ArrayList<Comment>();

            	//コメントを一つずつ取り出す
            	while (rsCm.next()) {

            		//投稿とコメントを結合
            		if (rsCm.getInt("contribution_id") == rsCb.getInt("id")) {

            			//投稿のリストに入れるコメントリストの中のコメントインスタンスを生成
            			Comment comment = new Comment();

            			comment.setId(rsCm.getInt("id"));
            			comment.setText(rsCm.getString("text"));
            			comment.setUserAccount(rsCm.getString("user_account"));
            			comment.setContributionId(rsCm.getInt("contribution_id"));
            			comment.setCreatedDate(rsCm.getDate("created_date"));
            			comment.setUpdatedDate(rsCm.getDate("updated_date"));

            			//投稿のコメントリストにコメントを入れる
            			comments.add(comment);

            			System.out.println(comment);

            			}

            		}

            	ret.add(userCC);

            	}

            //投稿が新しい順に最大10件入っているリストを返す
//            System.out.println(ret);
            return ret;
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(psCb);
            close(psCm);
        }
    }

}
