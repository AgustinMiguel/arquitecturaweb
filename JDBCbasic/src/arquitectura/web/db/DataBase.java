package arquitectura.web.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} 
		String uri = "jdbc:derby:MyDerbyDb; create = true";
		
		try {
			Connection con = DriverManager.getConnection(uri);
			createTables(con);
			addPerson(con,1,"Juan",35);
			addPerson(con,2,"Agustin",24);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addPerson(Connection con, int id, String name, int years) throws SQLException {
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3,years);
		ps.executeUpdate();
		ps.close();
		con.commit();
	}

	private static void createTables(Connection con) throws SQLException {
		String table = "CREATE TABLE persona(" + 
				"id INT," + 
				"nombre VARCHAR(35)," + 
				"edad INT," + 
				"PRIMARY KEY(id))";
		con.prepareStatement(table).execute();
		con.commit();
	}
}
