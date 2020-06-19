package bbs;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

    	HttpSession session = request.getSession();

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.2.6:3306/test";
		String user = "testuser";
		String password = "test";

		boolean flg = false;

		if (category.length() >= 11) {
			session.setAttribute("categoryError", "※10文字以下で入力してください");
	      	request.getRequestDispatcher("/contributionIndex").forward(request, response);
		}

		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
	      	//SQL文をDBに送るためのいれもの
	      	connection = DriverManager.getConnection(url,user,password);
	      	connection.setAutoCommit(false);
	      	StringBuilder sql = new StringBuilder();

	      	sql.append("SELECT * FROM contributions WHERE ");



	      	if (date.equals("1d")) {
	      		sql.append("updated_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.DAY_OF_MONTH, -1);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;

	      		System.out.println(sql.toString());

	      	}
	      	if (date.equals("3d")) {
	      		sql.append("updated_date BETWEEN ");
	      		d2.setTime(dt2);
	    		d2.add(Calendar.DAY_OF_MONTH, -3);
	    		Date date2 = d2.getTime();
	      		sql.append("'");
	      		sql.append(sdf.format(date2));
	      		sql.append("' AND '");
	      		sql.append(sdf.format(dt));
	      		sql.append("'");
	      		flg = true;
	      	}
	      	if (date.equals("1w")) {
	      		sql.append("updated_date BETWEEN ");
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
	      		sql.append("updated_date BETWEEN ");
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
	      		sql.append("updated_date BETWEEN ");
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
	      		sql.append("updated_date BETWEEN ");
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

	            String sqlCm = "SELECT * FROM comments";

	            System.out.println(sql.toString());

	            psCb = connection.prepareStatement(sql.toString());
		      	rsCb = psCb.executeQuery();

	            psCm = connection.prepareStatement(sqlCm);
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
	            System.out.println(sql.toString());

		      	commit(connection);
		      	request.setAttribute("contributions", ret);
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