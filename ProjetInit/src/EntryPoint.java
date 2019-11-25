import java.util.ArrayList;

public class EntryPoint {

	public static void main(String[] args) {

		// Exercice getter setter constructeur
		Objet o1 = new Objet();
		System.out.println(o1.getAttribut());
		Objet o2 = new Objet("valeur saisie en parametre du constructeur");
		System.out.println(o2.getAttribut());

		// Exercice Heritage et Polymorphisme
		Employe e = new Employe();
		e.display();

		ArrayList<AbstractPersonne> listPersonnes = new ArrayList<AbstractPersonne>();
		listPersonnes.add(new Personne());
		listPersonnes.add(new Employe());
		listPersonnes.add(new Directeur());
		for (AbstractPersonne personne : listPersonnes) {
			personne.display();
		}

		// Exercice static
		Objet.staticDisplay();

		// Exercice Exception
		try {
			o1.test(0);
		} catch (Exception e1) {
			System.out.println("erreur");
			System.out.println(e1.getMessage());
		}

		// Implémentation design pattern Singleton
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s);
		System.out.println(s2);

		// Connection base de données
		MySQLManager msm = MySQLManager.getInstance();
		msm.displayUserId();
		//msm.insertUser("test", "mdp");
		
		msm.connectUserSecure("toto", "toto");
		msm.connectUserSecure("romain", "romain");
		msm.connectUserUnsecure("romain'; -- ", "");
		msm.connectUserSecure("romain'; -- ", "");		
	}
}