NOUVEAU PROJET : DAOExample

Package : 
ynov.daoexample
ynov.daoexample.model
ynov.daoexample.dao

Créer une classe Bootstrap qui contient la fonction main dans le package ynov.daoexample

Créer une classe User dans le package model
La classe User contient les attributs suivants : id, firstname, surname, mail, password  (visibilité : private)
Le classe User contient les getters et setters pour tous ses attributs (visibilité : public)

Créer une interface DAOUser dans le package dao
Définir 5 méthodes dans cette interface :
 - public User getUser(int id);
 - public List<User> getAllUsers();
 - public void addUser(User user);
 - public void updateUser(User user);
 - public void deleteUser(User user);

Créer une classe DAOUserImpl qui implémente l'interface DAOUser dans le package dao 
La classe DAOUserImpl contient un attribut connection (java.sql.Connection), visibilité private
Le classe DAOUserImpl contient un constructeur qui prend en paramètre un objet Connection, 
cet objet est ensuite affecté à l'attribut connection de la classe

Implémenter les méthodes du DAOUserImpl (au nombre de 5) avec des rêquetes préparées en suivant la logique des prototypes des méthodes

Créer une classe MySQLManager dans le package dao qui reprendra le code que vous aviez fait précédemment.
La classe MySQLManager sera implémentée selon le modèle Singleton. Elle aura un getter pour l'attribut connection (java.sql.Connection)

Créer une classe DAOFactory dans le package dao :

```
public class DAOFactory {
	private MySQLManager manager;
	private DAOUser daoUser;
	public DAOFactory() {
		manager = MySQLManager.getInstance();
		daoUser = new DAOUserImpl(manager.getConnection());
	}
	public DAOUser getDaoUser() {
		return daoUser;
	}
} 
```

```
public class Bootstrap {
	public static void main(String[] args) {
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		System.out.println(daoUser.getUser(1).getName());
		
		System.out.println("Lancement du programme");
		
		System.out.println("Insertion d'un nouvel utilisateur");
		// TODO

		System.out.println("Récupération de l'utilisation inséré et affichage");
		// TODO
		
		System.out.println("Modification de l'adresse mail de cet utilisateur");
		// TODO
		
		System.out.println("Récupération de l'utilisation modifié et affichage");
		// TODO
		
		System.out.println("Suppression de l'utilisateur");
		// TODO
		
		System.out.println("Affichage de tous les utilisateurs");
		// TODO
	}

}