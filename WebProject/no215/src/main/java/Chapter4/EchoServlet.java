 package Chapter4;

 import java.io.IOException;

 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 @WebServlet("/echo")
 public class EchoServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request,
       HttpServletResponse response)
       throws ServletException, IOException {
        
     
     String message = request.getParameter("m");
     System.out.println(message);

     request.setAttribute("message", message);

     RequestDispatcher dispatcher = request.getRequestDispatcher("echo.jsp");
     dispatcher.forward(request, response);
   }
 }