package Chapter4;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kazuate")

public class KazuateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    private static int answerNum;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();

        if (isNewGame(parameterMap) == true) {
            processNewGame(request);
        } else {
            processGuess(request);
        }
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("kazuate.jsp");
        dispatcher.forward(request, response);
    }

    private void processGuess(HttpServletRequest request) {
		if (isValidParam(request) == false) {
            request.setAttribute("message", "0～99の数値を入力してください。");
            return;
        }

        int num = Integer.parseInt(request.getParameter("num"));
        String message;
        if (answerNum == num) {
            message = "正解です！";
        } else if (answerNum < num) {
            message = "ハズレ！" + num + "は正解より大きい値です。";
        } else {
            message = "ハズレ！" + num + "は正解より小さい値です。";
        }
        request.setAttribute("message", message);
	}
	
	private boolean isValidParam(HttpServletRequest request) {
        String numString = request.getParameter("num");
        if (numString == null || numString.isEmpty() == true) {
            return false;
        }
        try {
            Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void processNewGame(HttpServletRequest request) {

        answerNum = StrictMath.abs(new Random(System.currentTimeMillis())
                .nextInt() % 100);
    }

    private boolean isNewGame(Map<String, String[]> parameterMap) {

        return parameterMap.containsKey("newGame");
    }


	
}