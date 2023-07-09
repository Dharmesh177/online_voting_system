import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/VotesListAdmin"})
public class VotesListAdminServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VoterDao dao = new VoterDao();
        
        List<Vote> votes = null;
        try {
            votes = dao.fetchVotes();
            request.setAttribute("votes", votes);
            request.getRequestDispatcher("VotesList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
