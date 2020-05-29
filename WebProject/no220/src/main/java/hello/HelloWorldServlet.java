// package hello;

// import java.io.IOException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet("/HelloWorld")
// public class HelloWorldServlet extends HttpServlet {
//     private static final long serialVersionUID = 1L;

//     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//             throws ServletException, IOException {

//         try {
//             System.out.println("BEGIN Hello, World! " + getCurrentTime());

//             // リクエストにメッセージをセット
//             req.setAttribute("message", "Hello, World!");
//             // req.setAttribute("message", getCurrentTime());

//             RequestDispatcher dispatcher = req.getRequestDispatcher("/HelloWorld.jsp");
//             dispatcher.forward(req, resp);
//         } finally {
//             System.out.println("END Hello, World! " + getCurrentTime());
//         }
//     }

//     private String getCurrentTime() {
//         return new SimpleDateFormat("HH:mm:ss").format(new Date());
//     }
// }