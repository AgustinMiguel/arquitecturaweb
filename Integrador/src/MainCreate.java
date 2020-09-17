
public class MainCreate {

	public static void main(String[] args) {
		String uri = "jdbc:derby:MyDerbyDb; create = true";
		DAOFactory factory = new DAOFactory();
		factory.createData(uri);
	}

}
