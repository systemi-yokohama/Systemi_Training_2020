package Java_Training.practice100.no217;

public class No069 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
        // idをセットする。ただし、パラメータがない（null）の時は、空値とする。
        m.setId(req.getParameter("id") == null ? "" : req.getParameter("id"));

        // memoをメモとして取得・設定する（null値の場合はnullをセット） 
        m.setMemo(req.getParameter("memo"));
        
        final String param1 = req.getParameter("yearParam1");
        final String param2 = req.getParameter("yearParam2");
        
        /* 各Paramがnullかどうかのチェックを行い、nullであればエラーを出力し、リターンコードを設定する. */
        if (param1 == null || param2 == null) {
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            // エラーの出力.
            res.getWriter().write(m.toJsonForError());
            return;
        }
        
        /* 例外を捕捉する. */
        try {
            // yearParam1とyearParam2を数値に変換したとき、同じ値の場合にtrueをいれる
            m.setTargetYear(Integer.parseInt(param1) == Integer.parseInt(param2));
            
        catch (NumberFormatException e) {
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            // エラーの出力.
            res.getWriter().write(m.toJsonForError());
            return;
        }
        
        /* 正常終了の場合のリターンコードの設定. */
        res.setStatus(HttpServletResponse.SC_OK);
        
        res.getWriter().write(m.toJson());
    }
}