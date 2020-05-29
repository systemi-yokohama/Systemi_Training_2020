
  package controller;
  import java.io.IOException;
  import java.util.ArrayList;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import org.apache.commons.lang.StringUtils;
  import beans.User;
  import service.UserService;

 @WebServlet(urlPatterns = { "/signup" })
  public class SignUpServlet extends HttpServlet {
 	private static final long serialVersionUID=1L;
      @Override//GETの場合はsignup.jspを表示
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws IOException, ServletException {

          request.getRequestDispatcher("signup.jsp").forward(request, response);
      }

      @Override//リクエストパラメータをUserオブジェクトにセット&Serviceのメソッドを呼び出してDBへユーザーの登録
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws IOException, ServletException {
          List<String> errorMessages = new ArrayList<String>();
          User user = getUser(request);
          if (!isValid(user, errorMessages)) {
              request.setAttribute("errorMessages", errorMessages);
              request.getRequestDispatcher("signup.jsp").forward(request, response);
              return;
          }
          new UserService().insert(user);
          response.sendRedirect("./");
      }
/*  private String account;
     private String name;
     private String email;
     private String password;
     private String description;
     private Date createdDate;
     private Date updatedDate;
 */
      private User getUser(HttpServletRequest request) throws IOException, ServletException {
          User user = new User();
          user.setName(request.getParameter("name"));
          user.setAccount(request.getParameter("account"));
          user.setPassword(request.getParameter("password"));
          user.setEmail(request.getParameter("email"));
          user.setDescription(request.getParameter("description"));
          return user;
      }

      private boolean isValid(User user, List<String> errorMessages) {
      String name = user.getName();
         String account = user.getAccount();
          String password = user.getPassword();
          String email = user.getEmail();
         if (!StringUtils.isEmpty(name) && (20 < name.length())) {
              errorMessages.add("名前は20文字以下で入力してください");
          }
         if (StringUtils.isEmpty(account)) {
              errorMessages.add("アカウント名を入力してください");
          } else if (20 < account.length()) {
              errorMessages.add("アカウント名は20文字以下で入力してください");
          }
        if (StringUtils.isEmpty(password)) {
              errorMessages.add("パスワードを入力してください");
          }

          if (!StringUtils.isEmpty(email) && (50 < email.length())) {
              errorMessages.add("メールアドレスは50文字以下で入力してください");
          }

          if (errorMessages.size() != 0) {
              return false;
         }
          return true;
      }
 }