
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CreateTable {

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
			addData(con);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addData(Connection con) throws SQLException {
		String insert = "INSERT INTO cliente (id_cliente, nombre, email) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/clientes.csv"));
			for (CSVRecord row : parser) {
				ps.setInt(1, Integer.parseInt(row.get("idCliente")));
				ps.setString(2, row.get("nombre"));
				ps.setString(3, row.get("email"));
				ps.executeUpdate();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ps.close();
		con.commit();
	}

	private static void createTables(Connection con) throws SQLException {
		String table = "CREATE TABLE  cliente(" + "id_cliente INT," + "nombre VARCHAR(500)," + "email VARCHAR(150),"
				+ "PRIMARY KEY(id_cliente))";
		con.prepareStatement(table).execute();
		con.commit();
		table = "CREATE TABLE  factura(" + "id_factura INT," + " id_cliente INT NOT NULL,"
				+ " PRIMARY KEY(id_factura), " + " FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente))";
		con.prepareStatement(table).execute();
		con.commit();
		table = "CREATE TABLE producto(id_producto int NOT NULL," + " nombre varchar(45) NOT NULL,"
				+ " valor int NOT NULL," + " PRIMARY KEY(id_producto))";
		con.prepareStatement(table).execute();
		con.commit();
		table = "CREATE TABLE factura_producto(cantidad int NOT NULL," + " id_producto int NOT NULL,"
				+ " id_factura int NOT NULL," + " valor int NOT NULL,"
				+ " FOREIGN KEY(id_producto) REFERENCES producto(id_producto),"
				+ " FOREIGN KEY(id_factura) REFERENCES factura(id_factura))";
		con.prepareStatement(table).execute();
		con.commit();
	}

}