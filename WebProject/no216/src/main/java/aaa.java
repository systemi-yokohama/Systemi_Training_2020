package teamA;

import static teamA.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //SQL文を書いて実行している
    //新規ユーザーデータをDBに追加する（insertメソッド？）
    public void insert(Connection connection, User user) {
        //statement=問い合わせを実行したり問い合わせの結果の取得に関するベースとなるもの
        //問い合わせ文の不正な入力を防ぐ
        PreparedStatement ps = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO users ( ");
            sql.append("account");
            sql.append(", password");
            sql.append(", name");
            sql.append(", branch_id");
            sql.append(", department_id");
            sql.append(", status");
            sql.append(", created_date");
            sql.append(", updated_date");
            sql.append(") VALUES (");
            sql.append("?"); // account
            sql.append(", ?"); // password
            sql.append(", ?"); // name
            sql.append(", ?"); // branch_id
            sql.append(", ?"); // department_id
            sql.append(", ?"); // status
            sql.append(", CURRENT_TIMESTAMP"); // created_date
            sql.append(", CURRENT_TIMESTAMP"); // updated_date
            sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setString(1, user.getAccount());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getBranchId());
            ps.setInt(5, user.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }


    //登録しているユーザーを見つけるためのSQL文
    public User getUser(Connection connection, String account,
            String password) {

        PreparedStatement ps = null;
        try {
            //StringBuilderを使えば？は使用しなくてもできる
            String sql = "SELECT * FROM users WHERE (account = ? OR email = ?) AND password = ?";

            //ステートメントとる
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, );
            ps.setString(3, password);

            //SQL文の実行
            ResultSet rs = ps.executeQuery();
            //toUserListの変数としてrsを使う

            List<User> userList = toUserList(rs);

            //isEmpty=文字列が空かどうか判断する
            //ユーザーが重複していたらエラーをなげて
            //ユーザーが登録されていなかったらnullを投げる
            //ユーザーが一つだけだったらユーザーのデータを投げる
            if (userList.isEmpty() == true) {
                return null;
                //ユーザーリストのサイズ（配列の数を数える＝length）を確認(格納したユーザーデータの数)
                //２個以上だとユーザーが重複していることになるから例外を投げる
            } else if (2 <= userList.size()) {
                throw new IllegalStateException("2 <= userList.size()");
            } else {
                return userList.get(0);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    //
    private List<User> toUserList(ResultSet rs) throws SQLException {

        List<User> ret = new ArrayList<User>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String account = rs.getString("account");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String description = rs.getString("description");
                Timestamp createdDate = rs.getTimestamp("created_date");
                Timestamp updatedDate = rs.getTimestamp("updated_date");


                //
                User user = new User();
                user.setId(id);
                user.setAccount(account);
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setDescription(description);
                user.setCreatedDate(createdDate);
                user.setUpdatedDate(updatedDate);

                ret.add(user);
            }
            return ret;
        } finally {
            close(rs);
        }
    }


    public User getUser(Connection connection, int id) {

    	PreparedStatement ps = null;
    	try {
    		String sql = "SELECT * FROM users WHERE id = ?";

    		ps = connection.prepareStatement(sql);
    		ps.setInt(1, id);

    		ResultSet rs = ps.executeQuery();
    		List<User> userList = toUserList(rs);
    		if (userList.isEmpty() == true) {
    			return null;
    		} else if (2 <= userList.size()) {
    			throw new IllegalStateException("2 <= userList.size()");
    		} else {
    			return userList.get(0);
    		}
    	} catch (SQLException e) {
    		throw new SQLRuntimeException(e);
    	} finally {
    		close(ps);
    	}
    }

    public void update(Connection connection, User user) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET");
			sql.append("  account = ?");
			sql.append(", name = ?");
			sql.append(", email = ?");
			sql.append(", password = ?");
			sql.append(", description = ?");
			sql.append(", updated_date = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" id = ?");

			ps = connection.prepareStatement(sql.toString());

			ps.setString(1, user.getAccount());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getDescription());
			ps.setInt(6, user.getId());

			int count = ps.executeUpdate();
			if (count == 0) {
				throw new NoRowsUpdatedRuntimeException();
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}

	}

}




//入力値が空ならメッセージを出す
	//isValidメソッド＝ユーザーが入力した最後の値が有効かどうかを返す

private boolean isValid(HttpServletRequest request, List<String> messages) {

	if (StringUtils.isEmpty(account) == true) {
		messages.add("アカウント名を入力してください");
	}
	if (StringUtils.isEmpty(password) == true) {
		messages.add("パスワードを入力してください");
	}
	if (StringUtils.isEmpty(name) == true) {
		messages.add("アカウント名を入力してください");
	}
	if (branchId == 0) {
		messages.add("支社名を入力してください");
	}
	if (departmentId == 0) {
		messages.add("部署名を入力してください");
	}
	   //メッセージなし＝正常
	if (messages.size() == 0) {
		return true;
	} else {
		return false;
	}
}






package teamA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamA.beans.User;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//jspを表示する
	@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

//	１．入力した値を受け取る
	@Override
	  protected void doPost(HttpServletRequest request,
			  HttpServletResponse response)
	      throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//入力するデータを入れる変数
		String account = null;
		String password = null;
		String password2 = null;
		String name = null;
		int branchId = 0;
		int departmentId = 0;

//		//SQL文
//		ResultSet rs = null;
//		//statement=問い合わせを実行したり問い合わせの結果の取得に関するベースとなるもの
//		Statement statement = null;
		
		

		 //入力した値をそれぞれの変数に格納
		 User user = new User();
		 account  = request.getParameter("account");
         password = request.getParameter("password");
         password2 = request.getParameter("password2");
         name  = request.getParameter("name");
         branchId  = Integer.parseInt((request.getParameter("branchId")));
         departmentId  = Integer.parseInt((request.getParameter("departmentId")));

       //セッションスコープを取得
		 HttpSession session = request.getSession();
	}


}



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamA.beans.User;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        List<String> messages = new ArrayList<String>();

        HttpSession session = request.getSession();
        if (isValid(request, messages) == true) {

            User user = new User();
            user.setAccount(request.getParameter("account"));
            user.setPassword(request.getParameter("password"));
            //user.setPassword2(request.getParameter("password2"));
            user.setName(request.getParameter("name"));
            user.setBranchId(Integer.parseInt(request.getParameter("branchId")));
            user.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));

            new UserService().register(user);

            response.sendRedirect("./");
        } else {
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("signup");
        }
    }

    private boolean isValid(HttpServletRequest request, List<String> messages) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(account) == true) {
            messages.add("アカウント名を入力してください");
        }
        if (StringUtils.isEmpty(password) == true) {
            messages.add("パスワードを入力してください");
        }
        // TODO アカウントが既に利用されていないか、メールアドレスが既に登録されていないかなどの確認も必要
        if (messages.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
