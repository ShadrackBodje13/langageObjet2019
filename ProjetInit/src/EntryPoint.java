
public class EntryPoint {

	public static void main(String[] args) {
		
		Objet o1 = new Objet();
		System.out.println(o1.getAttribut());
		
		Objet o2 = new Objet("valeur saisie en parametre du constructeur");
		System.out.println(o2.getAttribut());

	}

}
