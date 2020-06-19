package bbs;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.bean.MnUser;

@WebServlet(urlPatterns = {"/userManagement"})
public class UserManagementServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<MnUser> mnUsers = new ArrayList<MnUser>();
		Connection connection = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.2.6:3306/test";
		String user = "testuser";
		String password = "test";
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
	      	sql.append("SELECT ");
	      	sql.append("users.id as id ,");
	      	sql.append("users.account as account ,");
	      	sql.append("users.name as name ,");
	      	sql.append("users.password as password ,");
	      	sql.append("users.created_date as created_date ,");
	      	sql.append("users.updated_date as updated_date ,");
	      	sql.append("branches.name as branchName ,");
	      	sql.append("departments.name as departmentName ,");
	      	sql.append("users.status as status ");
	      	sql.append("FROM users ");
	      	sql.append("INNER JOIN branches ");
	      	sql.append("ON users.branch_id = branches.id ");
	      	sql.append("INNER JOIN departments ");
	      	sql.append("ON users.department_id = departments.id ");
	      	sql.append("ORDER BY users.id ASC");
	      	System.out.println(sql.toString());
	      	ps = connection.prepareStatement(sql.toString());
	      	rs = ps.executeQuery();
	      	while(rs.next()) {
	      		MnUser mnUser = new MnUser();
	      		mnUser.setAccount(rs.getString("account"));
	      		mnUser.setName(rs.getString("name"));
	      		mnUser.setPassword(rs.getString("password"));
	      		mnUser.setCreatedDate(rs.getDate("created_date"));
	      		mnUser.setUpdatedDate(rs.getDate("updated_date"));
	      		mnUser.setBranchName(rs.getString("branchName"));
	      		mnUser.setDepartmentName(rs.getString("departmentName"));
	      		mnUser.setStatus(rs.getString("status"));
	      		mnUsers.add(mnUser);
	      	}

	      	commit(connection);
	      	request.setAttribute("mnUsers", mnUsers);
	      	request.getRequestDispatcher("/userManagement.jsp").forward(request, response);

	} catch (RuntimeException | SQLException e) {
		rollback(connection);
	} catch (Error e) {
		rollback(connection);
		throw e;
	} finally {
		close(rs);
	}
		close(connection);
	}
}
