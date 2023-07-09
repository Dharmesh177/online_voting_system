import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection connection;

    public AdminDao() {
        connection = DatabaseConnection.getConnection();
    }
    
    public boolean verifyAdmin(String name, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from admins where username=? AND password=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }
}
