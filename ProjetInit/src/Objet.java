
public class Objet {

	private String attribut;
	
	private static String staticAttribut = "Cet attribut est static";
	
	public String getAttribut() {
		return attribut;
	}
	
	public void setAttribut(String attribut) {
		this.attribut = attribut;
	}
	
	public Objet() {
		this.attribut = "valeur initiale";
	}
	
	public Objet(String attribut) {
		this.attribut = attribut;
	}
	
	
	public static void staticDisplay() {
		System.out.println(staticAttribut);
	}
}
