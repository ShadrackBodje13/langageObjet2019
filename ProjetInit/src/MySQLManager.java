import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public void connectUserUnsecure(String username, String password) {
		try {

			String query = "SELECT username FROM users WHERE username='" + username + "' AND password ='" + password
					+ "';";
			System.out.println(query);

			ResultSet resultat = statement.executeQuery(query);

			if (resultat.next() == false) {
				System.out.println("Non connecté, " + username + " n'existe pas!");
			} else {
				do {
					String name = resultat.getString("username");
					System.out.println(name + " est connecté");
				} while (resultat.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void connectUserSecure(String username, String password) {
		try {
			System.out.println("Connexion sécurisée :");
			String query = "SELECT username FROM users WHERE username=? AND password =?;";
			System.out.println(query);

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet resultat = ps.executeQuery();

			if (resultat.next() == false) {
				System.out.println("Non connecté, " + username + " n'existe pas!");
			} else {
				do {
					String name = resultat.getString("username");
					System.out.println(name + " est connecté");
				} while (resultat.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(String username, String password) {
		try {
			String sqlQuery = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
			int statut = statement.executeUpdate(sqlQuery);
			System.out.println(statut);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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