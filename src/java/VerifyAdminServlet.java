import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/VerifyAdminServlet"})
public class VerifyAdminServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDao();
        
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            boolean res = adminDao.verifyAdmin(name, password);
            response.getWriter().write(res+"");
            if (res) {
                request.setAttribute("name", name);
                request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
