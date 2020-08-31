import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

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
			select = "SELECT c.id_cliente, c.nombre, sum(fp.cantidad * p.valor) AS recaudacion FROM factura_producto fp JOIN producto p ON (fp.id_producto = p.id_producto) JOIN factura f ON (fp.id_factura = f.id_factura) "
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