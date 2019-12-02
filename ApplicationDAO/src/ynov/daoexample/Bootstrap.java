package ynov.daoexample;

import java.util.List;

import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.dao.DAOUser;
import ynov.daoexample.model.User;

public class Bootstrap {

	public static void main(String[] args) {
		System.out.println("Lancement du programme");
		
		// Initialisation des objets.
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		
		System.out.println("Affichage de tous les utilisateurs");
		List<User> users = daoUser.getAllUsers();
		for(User user : users) {
			System.out.println(user.getFirstname());
		}
		
		System.out.println("Insertion d'un nouvel utilisateur");
		User newUsr = new User();
		newUsr.setFirstname("Chuck");
		newUsr.setSurname("Norris");
		newUsr.setMail("chucknorris@gmail.com");
		newUsr.setPassword("chucknorris");
		daoUser.addUser(newUsr);

		System.out.println("Récupération de l'utilisation inséré et affichage");
		User createdUser = daoUser.getUser(newUsr.getId());
		System.out.println(createdUser);
		
		System.out.println("Modification de l'adresse mail de cet utilisateur");
		createdUser.setMail("toto@chucknorris.com");
		daoUser.updateUser(createdUser);
		
		System.out.println("Récupération de l'utilisation modifié et affichage");
		User updatedUser = daoUser.getUser(createdUser.getId());
		System.out.println(updatedUser);
		
		System.out.println("Affichage de tous les utilisateurs");
		users = daoUser.getAllUsers();
		for(User user : users) {
			System.out.println(user.getFirstname());
		}
		
		System.out.println("Suppression de l'utilisateur");
		daoUser.deleteUser(updatedUser);
		
		System.out.println("Affichage de tous les utilisateurs");
		users = daoUser.getAllUsers();
		for(User user : users) {
			System.out.println(user.getFirstname());
		}
	}
	
}
