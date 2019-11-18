
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
	
	public void test(int i) throws Exception {
		if(i == 0) {
			throw new Exception("test");
		} else {
			System.out.println("Youpi");
		}
	}
}