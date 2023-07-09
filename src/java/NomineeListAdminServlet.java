import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NomineeListAdmin"})
public class NomineeListAdminServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NomineeDao dao = new NomineeDao();
        
        List<Nominee> nominees = null;
        try {
            nominees = dao.fetchNomineesWithVotes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("nominees", nominees);
        response.getWriter().print("Nominees : " + nominees.toString());
        request.getRequestDispatcher("NomineesWithVotes.jsp").forward(request, response);
    }

}
