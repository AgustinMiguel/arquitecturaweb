import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DAOBill {
	
	public DAOBill() {
		super();
	}

	protected static void addBillData(Connection con) throws SQLException {
		String insert = "INSERT INTO factura (id_factura, id_cliente) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/facturas.csv"));
			for (CSVRecord row : parser) {
				ps.setInt(1, Integer.parseInt(row.get("idFactura")));
				ps.setInt(2, Integer.parseInt(row.get("idCliente")));
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
