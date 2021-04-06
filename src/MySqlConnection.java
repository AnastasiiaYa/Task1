import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/BD";
    String username= "newBD";
    String password = "zelena_26A";
    
    private Connection connection;
    
    public Connection connect() {
        if (connection == null)
        {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public void disconnect() {
        if (connection != null)
        {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
