package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

@WebServlet(urlPatterns = { "/NewAccount_Servlet" })
public class NewAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.2.5/board";
		String USER = "testuser";
		String password = "test";
		request.setCharacterEncoding("UTF-8");

		String user_account = request.getParameter("user_account");
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_office = request.getParameter("user_office");
		String user_department = request.getParameter("user_department");
		String check_user_password = request.getParameter("check_user_password");

		System.out.println("user_account:" + user_account);
		System.out.println("user_password:" + user_password);
		System.out.println("user_name:" + user_name);
		System.out.println("office_name:" + user_office);
		System.out.println("department_name:" + user_department);


		Connection con = null;

		//userの新規登録
		try

		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, USER, password);

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = con.createStatement();
			con.setAutoCommit(false);

			//新規アカウント登録の条件

			//アカウント重複チェック
			StringBuilder sql_check = new StringBuilder();
			sql_check.append("SELECT COUNT(*) FROM users ");
			sql_check.append("WHERE user_account = ");
			sql_check.append("'");
			sql_check.append(user_account);
			sql_check.append("'");

			ResultSet rs = null;
			rs = statement.executeQuery(sql_check.toString());

			System.out.println(sql_check.toString());

			int count = 0;

			rs.next();
			count = rs.getInt(1);

			System.out.println(count);

			if (count >= 1) {
				con.commit();
				con.close();
				statement.close();
				rs.close();
				request.setAttribute("errorMessage", "アカウントが重複しています");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
				return;
			}

			//名称の長さ
			if (user_name.length() > 10) {

				request.setAttribute("errorMessage", "名称は10文字以下で入力してください");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
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
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
				return;
			}

			//アカウントの文字数の確認
			if (user_account.length() < 6 || user_account.length() > 20) {
				request.setAttribute("errorMessage", "アカウント名は文字数6～20で入力してください");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
				return;
			}
			//パスワードチェック
			if (StringUtils.equals(user_password, check_user_password)) {
			} else {
				request.setAttribute("errorMessage", "パスワードと確認パスワードが違います");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
				return;
			}

			//SQL文作成
			StringBuilder sql = new StringBuilder();
			sql.append(
					"insert into board.users(user_account,user_password, user_name,user_office,user_department,user_status)values ('");
			sql.append(user_account);
			sql.append("','");
			sql.append(user_password);
			sql.append("','");
			sql.append(user_name);
			sql.append("',");
			sql.append(user_office);
			sql.append(",");
			sql.append(user_department);
			sql.append(",");
			sql.append(0);
			sql.append(")");

			//sqlの確認
			System.out.println(sql.toString());

			statement.executeUpdate(sql.toString());

			con.commit();

			getServletConfig().getServletContext().getRequestDispatcher("/UserManagement_Servlet").forward(request,
					response);
			statement.close();
			con.close();

		} catch (SQLException |

				ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ServletException();
			}
		}
	}

}
