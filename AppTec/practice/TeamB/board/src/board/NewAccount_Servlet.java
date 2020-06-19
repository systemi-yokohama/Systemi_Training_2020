package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

@WebServlet("/NewAccount_Servlet")
public class NewAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.2.5/board";
		String USER = "testuser";
		String password = "test";

		String user_account = request.getParameter("user_account");
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_office = request.getParameter("user_office");
		String user_department = request.getParameter("user_department");
		String check_user_password = request.getParameter("check_user_password");

		Connection con = null;




		//userの新規登録
		try

		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, USER, password);

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = con.createStatement();

			//ResultSet rs = null;

			//アカウント重複チェック

//			String sql_check = "SELECT user_account FROM users";
//			rs = statement.executeQuery(sql_check);
//			List<Users> ret = new ArrayList<Users>();
//			while (rs.next()) {
//				Users check_users = new Users();
//
//				check_users.setUser_account(rs.getString("user_account"));
//				ret.add(check_users);
//			}
//			System.out.println(ret.get(0));
//			System.out.println(user_account);
//			int list = ret.size();
//			for (int i = 0; i < list; i++) {
//				if (ret.equals(user_account)) {
//					request.setAttribute("errorMessage", "アカウントが重複しています");
//					request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
//				}
//			}
//			rs.close();
//			statement.close();

			//名称の長さ
			if (user_name.length() > 10) {

				request.setAttribute("errorMessage", "名称は10文字以下で入力してください");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
			}

			//支社と部署のチェック

			if (Integer.parseInt(user_office) == 1 && Integer.parseInt(user_department) <= 2) {

			} else if (Integer.parseInt(user_office) == 2 && Integer.parseInt(user_office) == 3
					&& Integer.parseInt(user_office) == 3
					&& Integer.parseInt(user_department) == 3 && Integer.parseInt(user_department) == 4) {

			} else {
				request.setAttribute("errorMessage", "支社と部署の組み合わせに誤りがあります");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
			}

			//		//アカウントの文字数の確認
			if (user_account.length() < 6 || user_account.length() > 20) {
				request.setAttribute("errorMessage", "アカウント名は文字数6～20で入力してください");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
			}
			//		//パスワードチェック
			if (StringUtils.equals(user_password, check_user_password)) {
			} else {
				request.setAttribute("errorMessage", "パスワードと確認パスワードが違います");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
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

	//	private boolean isValid(String user_account, String user_password, String user_name, String user_office,
	//			String user_department, String check_user_password, List<String> errorMessage) {

	//アカウント重複チェック
	//				ResultSet rs = null;
	//
	//				String sql_check = "SELECT user_account FROM users";
	//				rs = statement.executeQuery(sql_check);
	//				List<Users> ret = new ArrayList<Users>();
	//				while (rs.next()) {
	//					Users users = new Users();
	//
	//					user_account = rs.getString("user_account");
	//					users.setUser_account(rs.getString("user_account"));
	//					ret.add(users);
	//				}
	//				int size = ret.size();
	//				Users[] bar = ret.toArray(new Users[size]);
	//
	//				String str = "";
	//				for (int i = 0; i < size; i++) {
	//					str += bar[i] + ", ";
	//				}
	//				System.out.println(str);
	//
	//				if (user_account != str) {
	//					request.setAttribute("errorMessage", "アカウントが重複しています");
	//								request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
	//				}
	//
	//		//名称の文字数確認
	//		if (user_name.isEmpty() && user_name.length() > 10) {
	//			errorMessage.add("名称は10文字以下で入力してください");
	//		}
	//
	//		//支社と部署のチェック
	//
	//		//アカウントの文字数の確認
	//		if (user_account.isEmpty() && 6 > user_account.length() | user_account.length() < 20) {
	//			errorMessage.add("アカウント名は文字数6～20で入力してください");
	//		}
	//
	//		//パスワードチェック
	//		if (user_password.isEmpty() && check_user_password.isEmpty()) {
	//			errorMessage.add("パスワードと確認パスワードを入力してください");
	//		} else if (user_password != check_user_password) {
	//			errorMessage.add("パスワードと確認パスワードが違います");
	//		}
	//
	//		if (errorMessage.size() != 0) {
	//			return false;
	//		}
	//		return true;
	//	}

}
