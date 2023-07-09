import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoterDao {
    private Connection connection;

    public VoterDao() {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addVote(Vote v) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into voter(voter_id, nominee_id) values (?, ?)");
        preparedStatement.setString(1, v.getVoter_id());
        preparedStatement.setInt(2, v.getNominee_id());
        preparedStatement.executeUpdate();
    }
    
    public List<Vote> fetchVotes() throws SQLException {
        List<Vote> votes = new ArrayList<Vote>();
        String query = "select * from Voter;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
            Vote n = new Vote(
                    resultSet.getString("voter_id"),
                    resultSet.getInt("vote_id"),
                    resultSet.getInt("nominee_id")
            );
            votes.add(n);
        }
        return votes;
    }
    
    public void deleteVote(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from voter where vote_id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
