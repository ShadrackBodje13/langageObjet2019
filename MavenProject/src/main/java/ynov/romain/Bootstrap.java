package ynov.romain;

public class Bootstrap {
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		MySQLManager msm = MySQLManager.getInstance();
		msm.displayBddUsers();
	}
}
