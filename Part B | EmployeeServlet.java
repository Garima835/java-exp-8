import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
          throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Employee Records</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, salary FROM employee");

            while(rs.next()) {
                out.println("<tr><td>"+rs.getInt(1)+"</td><td>"
                    +rs.getString(2)+"</td><td>"+rs.getDouble(3)+"</td></tr>");
            }

            out.println("</table>");
            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
