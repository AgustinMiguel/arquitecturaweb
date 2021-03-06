import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DAOCustomer {

	public DAOCustomer() {
		super();
	}

	protected static void addCustomerData(Connection con) throws SQLException {
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

	protected void getBestCustomers(String uri, String driver) {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection con = DriverManager.getConnection(uri);
			String select = "SELECT * FROM cliente";
			PreparedStatement ps;
			ResultSet rs;
			select = "SELECT c.id_cliente, c.nombre, sum(fp.cantidad * p.valor) AS recaudacion, count(c.id_cliente) FROM factura_producto fp JOIN producto p ON (fp.id_producto = p.id_producto) JOIN factura f ON (fp.id_factura = f.id_factura) "
					+ "JOIN cliente c ON (f.id_cliente = c.id_cliente) GROUP BY c.id_cliente, c.nombre ORDER BY recaudacion DESC";
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			System.out.println("-----------------LISTA DE FACTURACION POR CLIENTE----------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
