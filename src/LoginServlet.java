import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 초기 세팅
        Gson gson = new Gson();
        resp.setContentType("application/json; charset=utf-8");

        // 2. form-urlencoded 값 받기
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 3. 유효성 검사 및 실패 처리
        if (username == null || username.equals("") || password == null || password.equals("")) {
            ResponseMsg responseMsg = new ResponseMsg(ResponseEnum.FAIL.getValue(), "loginFail");
            String responseBody = gson.toJson(responseMsg);
            resp.getWriter().println(responseBody);
            return;
        }

        ResponseMsg responseMsg = new ResponseMsg(ResponseEnum.SUCCESS.getValue(), "loginSuccess");
        String responseBody = gson.toJson(responseMsg);
        resp.getWriter().println(responseBody);
        
    }

}
