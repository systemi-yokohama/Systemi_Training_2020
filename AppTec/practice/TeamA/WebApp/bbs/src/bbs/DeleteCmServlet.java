package bbs;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteCom"})
public class DeleteCmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		int cmId = Integer.parseInt(request.getParameter("cmId"));

		Connection connection = null;
    	PreparedStatement ps = null;

		try {
			connection = getConnection();

	      	//コメントを削除するSQL文
	      	StringBuilder sql = new StringBuilder();
	      	sql.append("DELETE FROM comments ");
	      	sql.append("WHERE id=");
	      	sql.append(cmId);

	      	System.out.println(sql.toString());

	      	//SQLの実行
	      	ps = connection.prepareStatement(sql.toString());
	      	ps.executeUpdate();

	      	commit(connection);
	      	request.getRequestDispatcher("/contributionIndex").forward(request, response);

			close(connection);

	      	} catch (RuntimeException | SQLException e) {
	    		rollback(connection);
	    	} catch (Error e) {
	    		rollback(connection);
	    		throw e;
	    	} finally {
	    		close(ps);
	    	}
	}
}
