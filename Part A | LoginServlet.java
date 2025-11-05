import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        String user = req.getParameter("uname");
        String pass = req.getParameter("pwd");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if(user.equals("admin") && pass.equals("12345")) {
            out.println("<h3>Login Successful ✅</h3>");
        } else {
            out.println("<h3>Invalid Credentials ❌</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
