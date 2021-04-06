import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/servlets")

public class servlets extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/BD";
    String username= "newBD";
    String password = "zelena_26A";
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try(Connection conn = DriverManager.getConnection(url, username, password))
			{
				Statement statement = conn.createStatement();
				String sql = "SELECT id, name, surname FROM person";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()){
			         String id = rs.getString("id");
			         String name = rs.getString("name");
			         String surname = rs.getString("surname");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Name: " + name);
			         System.out.println(", Surname: " + surname);
			      }
			      rs.close();
			}
		}
		catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
            try (Connection conn = DriverManager.getConnection(url, username, password))
            {
            	Statement statement = conn.createStatement();
            	int rows = statement.executeUpdate("INSERT person (id, name, surname) VALUES ('15', 'Vasylii', 'Heorhiian')");
            	System.out.println("Added rows" + rows);
            }
            }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try(Connection conn = DriverManager.getConnection(url, username, password))
			{
				Statement statement = conn.createStatement();
				int rows = statement.executeUpdate("UPDATE person SET name = 'Zahar' WHERE id = '15'");
            	System.out.println("Updated rows" + rows);
			}
		}
		catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			try(Connection conn = DriverManager.getConnection(url, username, password))
			{
				Statement statement = conn.createStatement();
				int rows = statement.executeUpdate("DELETE FROM person id WHERE id = '1'");
            	System.out.println("Deleted %d rows" + rows);
			}
		}
		catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
	}
}