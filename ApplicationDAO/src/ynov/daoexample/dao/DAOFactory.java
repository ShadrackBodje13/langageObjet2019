package ynov.daoexample.dao;

public class DAOFactory {

	private MySQLManager mySQLManager;
	private DAOUser daoUser;
	
	public DAOUser getDaoUser() {
		return daoUser;
	}
	
	public DAOFactory() {
		mySQLManager = MySQLManager.getInstance();
		daoUser = new DAOUserImpl(mySQLManager.getConnection());
	}
	
}