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

public class DAOFactory {
	final static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private DAOBill bills;
	private DAOCustomer customers;
	private DAOProduct products;
	private DAOBillProduct billsProducts;

	public DAOFactory() {
		super();
		this.bills = new DAOBill();
		this.customers = new DAOCustomer();
		this.products = new DAOProduct();
		this.billsProducts = new DAOBillProduct();
	}

	protected void createData(String uri) {
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection con = DriverManager.getConnection(uri);
			createTables(con);
			insertData(uri);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void insertData(String uri) {
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection con = DriverManager.getConnection(uri);
			customers.addCustomerData(con);
			bills.addBillData(con);
			products.addProductData(con);
			billsProducts.addBillProductData(con);
			con.close();
		} catch (SQLException e) {
		}
	}

	protected void getBestProduct(String uri) {
		products.getBestProduct(uri, DRIVER);
	}
	
	protected void getBestCustomers(String uri) {
		customers.getBestCustomers(uri, DRIVER);
	}
	private void createTables(Connection con) { 
		String table = "CREATE TABLE cliente(" + "id_cliente INT," + "nombre VARCHAR(500)," + "email VARCHAR(150),"
				+ "PRIMARY KEY(id_cliente))";
		try {
			con.prepareStatement(table).execute();
			con.commit();
		} catch (SQLException e) {
		}
		table = "CREATE TABLE  factura(" + "id_factura INT," + " id_cliente INT NOT NULL,"
				+ " PRIMARY KEY(id_factura), " + " FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente))";
		try {
			con.prepareStatement(table).execute();
			con.commit();
		} catch (SQLException e) {
		}
		table = "CREATE TABLE producto(id_producto int NOT NULL," + " nombre varchar(45) NOT NULL,"
				+ " valor double NOT NULL," + " PRIMARY KEY(id_producto))";
		try {
			con.prepareStatement(table).execute();
			con.commit();
		} catch (SQLException e) {
		}
		table = "CREATE TABLE factura_producto(cantidad int NOT NULL," + " id_producto int NOT NULL,"
				+ " id_factura int NOT NULL," + " FOREIGN KEY(id_producto) REFERENCES producto(id_producto),"
				+ " FOREIGN KEY(id_factura) REFERENCES factura(id_factura))";
		try {
			con.prepareStatement(table).execute();
			con.commit();
		} catch (SQLException e) {
		}
	}
}
