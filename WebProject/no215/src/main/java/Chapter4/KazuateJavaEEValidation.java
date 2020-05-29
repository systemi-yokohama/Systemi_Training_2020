package Chapter4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet("/kazuateJavaEEValidation")

public class KazuateJavaEEValidation extends HttpServlet{
	private static final long serialVersionUID = 1L;

    private static int answerNum;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        KazuateForm form = toKazuateForm(request);

        if (isNewGame(parameterMap) == true) {
            processNewGame(request, form);
        } else {
            processGuess(request, form);
        }
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("kazuateJavaEEValidation.jsp");
        dispatcher.forward(request, response);
    }

    private KazuateForm toKazuateForm(HttpServletRequest request) {
        KazuateForm ret = new KazuateForm();

        String num = request.getParameter("num");
        if (num.isEmpty() == false) {
            ret.setNum(num);
        }

        return ret;
    }

    private void processGuess(HttpServletRequest request, KazuateForm form) {

        Map<String, List<String>> validationMessages = validate(request, form);
        if (validationMessages.isEmpty() == false) {
            request.setAttribute("validationMessages", validationMessages);
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

    private Map<String, List<String>> validate(HttpServletRequest request,
            KazuateForm form) {

        ValidatorFactory validatorFactory = Validation
                .buildDefaultValidatorFactory();

        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<KazuateForm>> validationResult = validator
                .validate(form);

        Map<String, List<String>> ret = new HashMap<String, List<String>>();
        for (ConstraintViolation<KazuateForm> violation : validationResult) {
            String propertyPath = violation.getPropertyPath().toString();
            List<String> messages = ret.get(propertyPath);
            if(messages ==null) {
                messages = new ArrayList<String>();
                ret.put(propertyPath, messages);
            }
            messages.add(violation.getMessage());
        }

        return ret;
    }

    private void processNewGame(HttpServletRequest request, KazuateForm form) {

        answerNum = StrictMath.abs(new Random(System.currentTimeMillis())
                .nextInt() % 100);
    }

    private boolean isNewGame(Map<String, String[]> parameterMap) {

        return parameterMap.containsKey("newGame");
    }
}