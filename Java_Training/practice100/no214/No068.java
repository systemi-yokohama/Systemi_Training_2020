package Java_Training.practice100.no214;
import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.text.SimpleDateFormat;
import java.util.*;
//以下はリクエストパラメータの情報をModelクラスのインスタンスに変換し、JSON化して出力するサーブレットである。
//問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。
public class No068 extends HttpServlet {
    // 2014/01/01 23:50:11なスタイルでパーズする

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServerCloneException, IOException {

     final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//24時制はhhではなくHH。オーバーライド時に取得する。

        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
    
        m.setId(req.getParameter("id"));
        m.setDate(FORMAT.parse(req.getParameter("date")));//
        m.setSize(Integer.parseInt(req.getParameter("size")));
        m.setMemo(req.getParameter("memo"));

        res.getWriter().write(m.toJson());
    }
}
class Model{
    

}
class HttpServlet{
    
}