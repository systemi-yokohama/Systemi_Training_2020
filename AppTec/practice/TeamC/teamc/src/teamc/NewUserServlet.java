package teamc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teamc.beans.Users;
import teamc.dao.UserDao;

@WebServlet(urlPatterns = { "/nU" })
public class NewUserServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");

		Users users = new Users();

		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String branches_name = req.getParameter("branches_name");
		String departments_name = req.getParameter("departments_name");
		String samePassword = req.getParameter("samePassword");
		int branches_id = Integer.parseInt(branches_name);
		int departments_id = Integer.parseInt(departments_name);

		String regex = "^[0-9a-zA-Z]*$";
		Pattern pt = Pattern.compile(regex);
		Matcher m = pt.matcher(account);

		String rgx = "[a-zA-Z0-9]";
		String rgx2 = "[!-/:-@[-`{-~]]";
		Pattern ptn = Pattern.compile(rgx);
		Pattern ptn2 = Pattern.compile(rgx2);
		boolean mt = ptn.matcher(password).find() && ptn2.matcher(password).find();

		boolean ac = false;
		boolean ac2 = false;
		boolean ac3 = false;
		boolean nm = false;
		boolean bcdp = false;
		boolean psw = false;
		boolean ps = false;

		try {

			if (!dame(account) && !dame(name)
					&& !kinshi(branches_id, departments_id)
					&& !dame(password)
					&& !dame(samePassword)) {

				if (accountLength(account)) {
					users.setAccount(account);
					ac = true;
				} else {
					req.setAttribute("error", "アカウント名は6文字以上20文字以下で入力してください");
					req.getRequestDispatcher("newUser.jsp").forward(req, res);
				}

				if (ac) {
					if (m.find()) {
						users.setAccount(account);
						ac2 = true;
					} else {
						req.setAttribute("error", "アカウント名は半角英数字で入力してください");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}

				if (ac2) {
					if (accountW(account)) {
						users.setAccount(account);
						ac3 = true;
					} else {
						req.setAttribute("error", "アカウント名が重複しています");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}
				if (ac3) {
					if (nameLength(name)) {
						users.setName(name);
						nm = true;
					} else {
						req.setAttribute("error", "名称は10文字以下で入力してください");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}
				if (nm) {
					if (branchesAndDepartments(branches_id, departments_id)) {
						users.setBranches_id(branches_id);
						users.setDepartments_id(departments_id);
						bcdp = true;
					} else {
						req.setAttribute("error", "支社と部署の組み合わせが違います");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);

					}
				}
				if (bcdp) {
					if (passwordLength(password)) {
						users.setPassword(password);
						psw = true;
					} else {
						req.setAttribute("error", "パスワードは6文字以上20文字以下で入力してください");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}
				if (psw) {
					if (mt) {
						users.setPassword(password);
						ps = true;
					} else {
						req.setAttribute("error", "パスワードは記号含む半角英数字で入力してください");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}

				if (ps) {
					if (passwordSame(samePassword, password)) {
						System.out.println("DB追加済み");
						UserDao.insert(users);
						req.getRequestDispatcher("UserManagementServlet").forward(req, res);
					} else {
						req.setAttribute("error", "パスワードが一致しません");
						req.getRequestDispatcher("newUser.jsp").forward(req, res);
					}
				}

			} else {
				req.setAttribute("error", "登録内容を入力してください");
				req.getRequestDispatcher("newUser.jsp").forward(req, res);
			}

		} catch (SQLException | IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static boolean accountLength(String account) {
		return account.length() >= 6 && account.length() <= 20;
	}



	public static boolean accountW(String account) {
		String sql = "SELECT * FROM users";
		List<Users> list = new ArrayList<Users>();
		try {
			list = UserDao.select(sql);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(list);
		for (Users user : list) {
			String a = user.getAccount();
			if (!dame(a)) {
				if (a.equals(account)) {
					return false;
				}
			}
		}
		return true;

	}

	public static boolean nameLength(String name) {
		return name.length() <= 10;
	}

	public static boolean branchesAndDepartments(int branches_id, int departments_id) {
		if (branches_id == 1 && departments_id <= 2) {
			return true;
		} else if (branches_id >= 2 && departments_id >= 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean passwordLength(String password) {
		return password.length() >= 6 && password.length() <= 20;
	}

	public static boolean passwordSame(String samePassword, String password) {
		return samePassword.equals(password);
	}

	public static boolean dame(String param) {
		return param == null || param.length() == 0;
	}
	public static boolean kinshi(int branches_id, int departments_id) {
		return branches_id == 0 && departments_id == 0;
	}
}