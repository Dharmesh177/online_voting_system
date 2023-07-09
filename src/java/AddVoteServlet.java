import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/AddVoteServlet"})
public class AddVoteServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String voter_id = request.getParameter("voter_id");
        int nominee_id = Integer.parseInt(request.getParameter("nominee_id"));
        
        VoterDao dao = new VoterDao();
        Vote v = new Vote(voter_id, nominee_id);
        
        try {
            dao.addVote(v);
            request.getRequestDispatcher("index.html").forward(request, response);
        }catch(SQLException e) {
            e.printStackTrace();
            response.getWriter().print(e.getMessage());
        }
        
    }

}
