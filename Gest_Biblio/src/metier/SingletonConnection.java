package metier;


import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;
	static{

		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/gestlivre","postgres","HbEr9785");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
