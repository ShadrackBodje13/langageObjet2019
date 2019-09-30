import java.util.Random;

public class EntryPoint {

	public static void main(String[] args) {

		System.out.println("Application 1");
		
		int table[] = new int[6];
		int compteur = 0;
		Random r = new Random();
		for(int c=0; c<6; c++) {
			table[c] = r.nextInt(11);
			if(table[c] > 5) {
				compteur++; 
			}			
		}
		System.out.println("Debut du tableau :");
		int cpt=0;
		while(cpt<6) {
			System.out.println("Entree numero " + cpt + " : " + table[cpt]);
			cpt++;
		}
		System.out.println("Nombre de valeurs superieur à 5 : " + compteur);
		
		System.out.println("---");
		int number;
		cpt = 0;
		do {
			number = r.nextInt(11);
			cpt++;
		} while (number != 5);
		System.out.println("Chiffre " + number + " atteint en " + cpt + " essais");
		
	}

}