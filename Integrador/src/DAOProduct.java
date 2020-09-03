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

public class DAOProduct {
	public DAOProduct() {
		super();
	}

	protected static void addProductData(Connection con) throws SQLException {
		String insert = "INSERT INTO producto (id_producto, nombre, valor) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/productos.csv"));
			for (CSVRecord row : parser) {
				ps.setInt(1, Integer.parseInt(row.get("idProducto")));
				ps.setString(2, row.get("nombre"));
				ps.setFloat(3, Float.parseFloat(row.get("valor")));
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

	protected void getBestProduct(String uri, String driver) {
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
			select = "SELECT fp.id_producto,p.nombre, sum(fp.cantidad * p.valor) AS recaudacion FROM factura_producto fp JOIN producto p ON (fp.id_producto = p.id_producto) GROUP BY fp.id_producto, p.nombre ORDER BY recaudacion DESC FETCH FIRST 1 ROWS ONLY";
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			System.out.println("-----------------PRODUCTO MAS RECAUDADOR----------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
