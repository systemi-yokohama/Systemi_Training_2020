package Java_Training.practice100.no217;


public class No068 extends HttpServlet {
    // 2014/01/01 23:50:11なスタイルでパーズする
    //private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        // 修正箇所. #3
        final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
        m.setId(req.getParameter("id"));
        
        // 取得した日付パラメータがnullの場合の処理. #1
        if (req.getParameter("date") != null) {
            try {
                m.setDate(FORMAT.parse(req.getParameter("date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            m.setDate(null);
        }
        
        // 取得したサイズパラメータがnullの場合の処理. #2
        if (req.getParameter("size") != null) {
            try {
                m.setSize(Integer.parseInt(req.getParameter("size")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            m.setSize(-1);
        }
        
        m.setMemo(req.getParameter("memo"));

        res.getWriter().write(m.toJson());
    }
}

