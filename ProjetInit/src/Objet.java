
public class Objet {

	private String attribut;
	
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
	
}
