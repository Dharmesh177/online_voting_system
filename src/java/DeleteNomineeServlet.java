import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/DeleteNominee"})
public class DeleteNomineeServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        NomineeDao dao = new NomineeDao();
        try {
            dao.deleteNominee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("NomineeListAdmin");
    }

}
