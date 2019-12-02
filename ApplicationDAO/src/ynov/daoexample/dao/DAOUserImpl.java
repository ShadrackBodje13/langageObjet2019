package ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.daoexample.model.User;

public class DAOUserImpl implements DAOUser {

	private Connection connection;

	public DAOUserImpl(Connection co) {
		this.connection = co;
	}

	@Override
	public User getUser(int id) {

		User user = new User();
		try {
			String query = "SELECT * FROM userc WHERE id=?;";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next() == false) {
				return null;
			} else {
				do {
					user.setId(rs.getInt("id"));
					user.setFirstname(rs.getString("firstname"));
					user.setSurname(rs.getString("surname"));
					user.setMail(rs.getString("mail"));
					user.setPassword(rs.getString("password"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		try {
			String query = "SELECT * FROM userc;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setSurname(rs.getString("surname"));
				user.setMail(rs.getString("mail"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void addUser(User user) {
		try {
			String query = "INSERT INTO userc (firstname, surname, mail, password) VALUES (?,?,?,?);";
			String generatedColumns[] = { "ID" };
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getMail());
			ps.setString(4, user.getPassword());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				user.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		try {
			String query = "UPDATE userc SET firstname=?, surname=?, mail=?, password=? WHERE id=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getMail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			String query = "DELETE FROM userc WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, user.getId());
						
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
