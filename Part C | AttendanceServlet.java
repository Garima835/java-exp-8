import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        String roll = req.getParameter("roll");
        String status = req.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/school","root","root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(roll, status) VALUES(?,?)");
            ps.setString(1, roll);
            ps.setString(2, status);
            ps.executeUpdate();
            con.close();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<h3>Attendance Submitted ✅</h3>");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
