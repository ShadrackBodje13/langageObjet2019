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
		for(AbstractPersonne personne : listPersonnes) {
			personne.display();
		}
		
		// Exercice static
		Objet.staticDisplay();
		
		
	}

}
