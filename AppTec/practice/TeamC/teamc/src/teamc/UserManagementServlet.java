package teamc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamc.beans.UserManagement;
import teamc.beans.Users;
import teamc.dao.UserMangementDao;
@WebServlet("/UserManagementServlet")

public class UserManagementServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");



		Users loginUser = (Users) session.getAttribute("loginUser");

		int branchesId = loginUser.getBranches_id();
		int departmentsId=loginUser.getDepartments_id();
		if(branchesId==1 && departmentsId ==1){
			try {
				List<UserManagement> ls = null;
				ls = UserMangementDao.select("SELECT * FROM users left join branches on branches.id=users.branches_id left join departments on departments.id=users.departments_id left join stopmessage on stopmessage.id=users.user_stop");


				request.setAttribute("usersList",ls);

				getServletConfig().getServletContext().getRequestDispatcher("/UserManagement.jsp").forward(request, response);





			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}else {
			System.out.println(" zzzz");
			request.setAttribute("commentVal", "権限がありません。");
			getServletConfig().getServletContext().getRequestDispatcher("/TopServlet").forward(request, response);
		}




	}


}
