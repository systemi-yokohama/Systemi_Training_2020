package teamc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teamc.beans.Branches;
import teamc.beans.Departments;
import teamc.beans.UserManagement;
import teamc.dao.UserMangementDao;


@WebServlet("/ToUserEditServlet")
public class ToUserEditServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String account=request.getParameter("account");
		String name =request.getParameter("name");
		String password=request.getParameter("password");

		int i = Integer.parseInt(id);
		UserManagement user =new UserManagement();
		user.setAccount(account);
		user.setName(name);
		user.setPassword(password);
		user.setId(i);

		try {
			List<Branches> bc = null;
			List<Departments> dp = null;
			bc = UserMangementDao.editb("SELECT * FROM branches");
			dp = UserMangementDao.editd("SELECT * FROM departments");

			request.setAttribute("branches",bc);
			request.setAttribute("departments",dp);
			request.setAttribute("Edit",user);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/userEdit.jsp");
			dispatcher.forward(request, response);

		}catch(Exception ex){
			ex.printStackTrace();

		}

	}
}
