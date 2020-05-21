/* setTargetYearのgetParameterメソッドがnullだったら
	valueOfメソッドでnullチェックが入る
	Integerは参照型なためInteger.parseIntメソッドを使う
	例外が起きたときのreturnがない */

package Java_Training.practice100.no213.no069;

import javax.servlet.ServletExpection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class No069 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletExpection, IOException {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("application/json; charset=UTF-8");
			Model m = new Model;
			m.setId(req.getParameter("id") == null ? "" : req.getParameter("id"));
			m.setMemo(req.getParameter("memo"));

			String param1 = req.getParameter("yearParam1");
			String param2 = req.getParameter("yearParam2");
			if(param1 == null || param2 == null) {
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				res.getWriter().write(m.toJsonForError());
				return;
			}

			try{
				m.setTargetYear(Integer.parseInt(param1) == Integer.parseInt(param2));
			} catch(NumberFormatException e) {
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				res.getWriter().write(m.toJsonForError());
				return;
			}
			res.setStatus(HttpServletResponse.SC_OK);
			res.getWriter().write(m.toJson());
		}
}