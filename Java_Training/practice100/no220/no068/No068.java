package Java_Training.practice100.no220.no068;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class No068 extends HttpServlet {
    // 2014/01/01 23:50:11なスタイルでパーズする
    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
        m.setId(req.getParameter("id"));
        m.setDate(FORMAT.parse(req.getParameter("date")));
        m.setSize(Integer.parseInt(req.getParameter("size")));
        m.setMemo(req.getParameter("memo"));

        res.getWriter().write(m.toJson());
    }
}