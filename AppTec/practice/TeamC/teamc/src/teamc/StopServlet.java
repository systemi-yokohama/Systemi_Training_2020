package teamc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teamc.beans.UserManagement;
import teamc.dao.UserMangementDao;


@WebServlet("/StopServlet")
public class StopServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{

	String stop= request.getParameter("stop");
	String id = request.getParameter("id");
	int i = Integer.parseInt(id);
	int s = Integer.parseInt(stop);
		if(s == 1) {
			UserManagement user =new UserManagement();
			user.setUser_stop(0);
			user.setId(i);
			try {
				UserMangementDao.update(user);
			}catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserManagementServlet");
			dispatcher.forward(request, response);
	}else {
		UserManagement user =new UserManagement();
		user.setUser_stop(1);
		user.setId(i);
		try {
			UserMangementDao.update(user);
		}catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("UserManagementServlet");
		dispatcher.forward(request, response);
	}

	}
}
