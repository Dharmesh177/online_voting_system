import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NomineeDao {
    private Connection connection;

    public NomineeDao() {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addNominee(Nominee nm) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into nominee(nominee_name, slogan) values (?, ?)");
        preparedStatement.setString(1, nm.getName());
        preparedStatement.setString(2, nm.getSlogan());
        preparedStatement.executeUpdate();
    }
    
    public List<Nominee> fetchNomineesWithVotes() throws SQLException {
        List<Nominee> nominess = new ArrayList<Nominee>();
        String query = "select nominee_id, nominee_name, IFNULL(votes, 0) as votes from (SELECT n.nominee_name, n.nominee_id, c.votes from nominee as n LEFT JOIN (SELECT nominee_id, COUNT(nominee_id) as votes from voter v GROUP BY nominee_id) as c on n.nominee_id = c.nominee_id) as f;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
            Nominee n = new Nominee(
                    resultSet.getInt("nominee_id"),
                    resultSet.getString("nominee_name"),
                    resultSet.getInt("votes")
            );
            nominess.add(n);
        }
        return nominess;
    }
    
    public List<Nominee> fetchNominees() throws SQLException {
        List<Nominee> nominess = new ArrayList<Nominee>();
        String query = "select * from Nominee;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
            Nominee n = new Nominee(
                    resultSet.getInt("nominee_id"),
                    resultSet.getString("nominee_name"),
                    resultSet.getString("slogan")
            );
            nominess.add(n);
        }
        return nominess;
    }
    
    public void deleteNominee(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from nominee where nominee_id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
