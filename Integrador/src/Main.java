import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		String uri = "jdbc:derby:MyDerbyDb; create = true";
		DAOFactory factory = new DAOFactory();
		factory.getBestProduct(uri);
		factory.getBestCustomers(uri);
	}
}
