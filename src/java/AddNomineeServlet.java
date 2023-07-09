import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/AddNomineeServlet"})
public class AddNomineeServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String slogan = request.getParameter("slogan");
        
        
        Nominee nm = new Nominee(name, slogan);
        
        NomineeDao dao = new NomineeDao();
        
        try {
            dao.addNominee(nm);
            request.getRequestDispatcher("NomineeListAdmin").forward(request, response);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
