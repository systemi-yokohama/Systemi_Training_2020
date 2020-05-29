  package controller;
  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import beans.User;
  import beans.UserMessage;
  import service.MessageService;
  
  @WebServlet(urlPatterns = { "/index.jsp" })
  public class TopServlet extends HttpServlet {
     private static final long serialVersionUID=1L;
     
 		  @Override
 		       protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws IOException, ServletException {
 				boolean isShowMessageForm = false;
 				User user = (User) request.getSession().getAttribute("loginUser");
 				if (user != null) {
				isShowMessageForm = true;
 				}

 		List<UserMessage> messages = new MessageService().select();

         request.setAttribute("messages", messages);
 		request.setAttribute("isShowMessageForm", isShowMessageForm);
         request.getRequestDispatcher("/top.jsp").forward(request, response);
      }
  }