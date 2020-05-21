/* getParameter()にnullチェックをする */ 

package Java_Training.practice100.no213.no068;

import javax.servlet.ServletExpection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class No068 extends HttpServlet {
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd hh;mm:ss");

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletExpection, IOException {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("application/json; charset=UTF-8");
			
			Model m = new Model();
			m.setId(req.getParameter("id"));
			if(req.getParameter("date") != null) {
				try{
					m.setDate(FORMAT.getParameter("date"));
				} catch(ParseException e) {
					e.printStackTrace();
				}
			else {
				m.setDate(null);
			}

			if(req.getParameter("size") != null) {
				try {
					m.setSize(Integer.parseInt(req.getParameter("size")));
				} catch(ParseException e) {
					e.printStackTrace();
				}
			else {
				m.setSize(null);
			}
			if(req.getParameter("memo" != null)) {
				try {
					m.setMemo(req.getParameter("memo"));
				} catch(NullPointerException e) {
					e.printStackTrace();
				}
				
			res.getWriter().write(m.toJson());
			}
		
	}
}