import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {

	private static MySQLManager instance = null;

	private Statement statement = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/application";
	private String utilisateur = "root";
	private String motDePasse = "";

	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	private MySQLManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			this.statement = this.connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayUserId() {
		try {
			ResultSet resultat = statement.executeQuery("SELECT id, username, password FROM users;");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {

			}
		}
	}

}