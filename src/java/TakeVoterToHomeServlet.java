import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/TakeVoterToHome"})
public class TakeVoterToHomeServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NomineeDao dao = new NomineeDao();
        
        List<Nominee> nominees = null;
        try {
            nominees = dao.fetchNominees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("nominees", nominees);
        request.setAttribute("name", request.getParameter("id"));
        request.getRequestDispatcher("VoterHome.jsp").forward(request, response);
    }

}
