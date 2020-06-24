package bbs;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import bbs.bean.Comment;
import bbs.bean.UserCC;

@WebServlet(urlPatterns = {"/narrow"})
public class NarrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		//現在時刻
		Date dt2 = new Date();
		Date dt = new Date();

		Calendar d2 = Calendar.getInstance();
		//フォーマットを変える
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		request.setCharacterEncoding("UTF-8");

		String date = request.getParameter("date");
		String category = request.getParameter("category");

		Connection connection = null;
    	PreparedStatement psCb = null;
    	PreparedStatement psCm = null;
    	ResultSet rsCb = null;
        ResultSet rsCm = null;
    	//投稿のリスト作成
    	List<UserCC> ret = new ArrayList<UserCC>();
    	String error = "";
    	HttpSession session = request.getSession();

		boolean flg = false;

		if (StringUtils.isBlank(category) && StringUtils.isEmpty(date)) {
			response.sendRedirect("/bbs/contributionIndex");
		}

		if (category.length() >= 11) {
			session.setAttribute("categoryError", "※10文字以下で入力してください");
	      	request.getRequestDispatcher("/contributionIndex").forward(request, response);
		}

		try {
			connection = getConnection();
	      	StringBuilder sql = new StringBuilder();

	      	sql.append("SELECT * FROM contributions WHERE ");



	      	if (date.equals("1d")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.DAY_OF_MONTH, -1);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;

	      	}
	      	if (date.equals("3d")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.DAY_OF_MONTH, -3);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;

	      		System.out.println(sql.toString());
	      	}

	      	if (date.equals("1w")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.DAY_OF_MONTH, -7);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;
	      	}
	      	if (date.equals("1m")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.MONTH, -1);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;
	      	}
	      	if (date.equals("3m")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.MONTH, -3);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;
	      	}
	      	if (date.equals("1y")) {
	      		sql.append("created_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.YEAR, -1);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;
	      	}

	      	if (!(StringUtils.isBlank(category))) {
	      		if (flg) {
		      		sql.append(" AND category LIKE '%");
		      		sql.append(category);
		      		sql.append("%'");
		      	} else {
		      		sql.append(" category LIKE '%");
		      		sql.append(category);
		      		sql.append("%'");
		      	}
	      	}

	      	sql.append(" ORDER BY created_date DESC");

	            psCb = connection.prepareStatement(sql.toString());
		      	rsCb = psCb.executeQuery();

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

	            	String sqlCm = "SELECT * FROM comments ORDER BY created_date DESC";
	            	psCm = connection.prepareStatement(sqlCm);
	 	            rsCm = psCm.executeQuery();

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
	           if (ret.size() == 0) {
	        	   error = "該当する投稿がありません";
	           }

		      	commit(connection);
		      	request.setAttribute("contributions", ret);
		      	session.setAttribute("error", error);
		      	request.getRequestDispatcher("/home.jsp").forward(request, response);

		} catch (RuntimeException | SQLException e) {
		rollback(connection);
	} catch (Error e) {
		rollback(connection);
		throw e;
	} finally {
		close(rsCb);
		close(rsCm);
	}
		close(connection);
	}
}