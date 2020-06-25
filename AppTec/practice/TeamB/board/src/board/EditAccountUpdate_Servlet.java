package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import utils.DButil;

@WebServlet("/EditAccountUpdate_Servlet")
public class EditAccountUpdate_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		Connection connection = DButil.getConnection();

		try {

			String old_user_account = request.getParameter("old_user_account");
			String new_user_account = request.getParameter("new_user_account");
			String user_password = request.getParameter("user_password");
			String check_user_password=request.getParameter("check_user_password");
			String user_name = request.getParameter("user_name");
			String user_office = request.getParameter("user_office");
			String user_department = request.getParameter("user_department");

			System.out.println("user_account:" + new_user_account);
			System.out.println("user_password:" + user_password);
			System.out.println("user_name:" + user_name);
			System.out.println("office_name:" + user_office);
			System.out.println("department_name:" + user_department);

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = connection.createStatement();


			//アカウント重複チェック
			StringBuilder sql_check = new StringBuilder();
			sql_check.append("SELECT COUNT(*) FROM users ");
			sql_check.append("WHERE user_account = ");
			sql_check.append("'");
			sql_check.append(new_user_account);
			sql_check.append("'");

			ResultSet rs = null;
			rs = statement.executeQuery(sql_check.toString());

			System.out.println(sql_check.toString());


			int count = 0;

			rs.next();
			count = rs.getInt(1);

			System.out.println(count);
			if(new_user_account== old_user_account){
			if (count >= 1) {
				connection.commit();
				connection.close();
				statement.close();
				rs.close();
				request.setAttribute("errorMessage", "アカウントが重複しています");
				request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
				return;
			}
			}

			rs.next();

			//名称の長さ

			if (user_name.length() > 10) {

				request.setAttribute("errorMessage", "名称は10文字以下で入力してください");
				request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
				return;
			}

			//支社と部署のチェック

			if (Integer.parseInt(user_office) == 1 && Integer.parseInt(user_department) <= 2) {

			} else if (Integer.parseInt(user_office) == 2 && Integer.parseInt(user_department) == 3) {
			} else if (Integer.parseInt(user_office) == 2 && Integer.parseInt(user_department) == 4) {
			} else if (Integer.parseInt(user_office) == 3 && Integer.parseInt(user_department) == 3) {
			} else if (Integer.parseInt(user_office) == 3 && Integer.parseInt(user_department) == 4) {
			} else if (Integer.parseInt(user_office) == 4 && Integer.parseInt(user_department) == 3) {
			} else if (Integer.parseInt(user_office) == 4 && Integer.parseInt(user_department) == 4) {
			} else {
				request.setAttribute("errorMessage", "支社と部署の組み合わせに誤りがあります");
				request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
				return;
			}

			//アカウントの文字数の確認
			if (new_user_account.length() < 6 || new_user_account.length() > 20) {
				request.setAttribute("errorMessage", "アカウント名は文字数6～20で入力してください");
				request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
				return;
			}
			//パスワードチェック
			if (StringUtils.equals(user_password, check_user_password)) {
			} else {
				request.setAttribute("errorMessage", "パスワードと確認パスワードが違います");
				request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
				return;
			}

			//パスワードの長さ
			if( user_password .length() < 6 || user_password.length() > 20) {
				if(0 < user_password .length()){
							request.setAttribute("errorMessage", "パスワードは文字数6～20で入力してください");
							request.getRequestDispatcher("/editaccount.jsp").forward(request, response);
							return;
				}
			}

			//SQL文作成
			StringBuilder sql = new StringBuilder();

			/*UPDATE users SET user_account='sakakibara',user_password='sakakibara',
			 * user_name='榊原義人', user_office=1 ,user_department=2 where user_account='koyamada';*/
			sql.append("UPDATE users SET");
			//アカウント名が変更される場合

			if (!(new_user_account == null) && !(new_user_account.trim().equals(""))) {
				sql.append(" user_account = '");
				sql.append(new_user_account);
				sql.append("',");

			}

			if (!(user_password == null) && !(user_password.trim().equals(""))) {
				sql.append(" user_password = '");
				sql.append(user_password);
				sql.append("',");

			}
			if (!(user_name == null) && !(user_name.trim().equals(""))) {
				sql.append(" user_name = '");
				sql.append(user_name);
				sql.append("',");
			}
			if (!(user_office == null) && !(user_office.trim().equals(""))) {
				sql.append(" user_office  =");
				sql.append(user_office);
				sql.append(",");
			}
			if (!(user_department == null) && !(user_department.trim().equals(""))) {
				sql.append(" user_department = ");
				sql.append(user_department);

			}
			sql.append(" WHERE user_account='");
			sql.append(old_user_account);
			sql.append("';");

			System.out.println(sql.toString());
			//executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている

			   PreparedStatement ps = null;
		    	ps = connection.prepareStatement(sql.toString());
				ps.executeUpdate();


		        ps.close();
			statement.close();
			connection.commit();


		        getServletConfig().
			    getServletContext().
			    getRequestDispatcher("/UserManagement_Servlet").forward(request,response);

	//	connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
