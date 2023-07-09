import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/DeleteVoteServlet"})
public class DeleteVoteServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        VoterDao dao = new VoterDao();
        try {
            dao.deleteVote(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("VotesListAdmin");
    }

}
