import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DAOBillProduct {
	
	public DAOBillProduct() {
		super();
	}

	protected static void addBillProductData(Connection con) throws SQLException {
		String insert = "INSERT INTO factura_producto (cantidad, id_producto, id_factura) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/facturas-productos.csv"));
			for (CSVRecord row : parser) {
				ps.setInt(1, Integer.parseInt(row.get("cantidad")));
				ps.setInt(2, Integer.parseInt(row.get("idProducto")));
				ps.setInt(3, Integer.parseInt(row.get("idFactura")));
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
}
