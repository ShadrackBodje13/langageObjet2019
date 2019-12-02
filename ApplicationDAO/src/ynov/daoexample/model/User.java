package ynov.daoexample.model;

public class User {

	private int id;
	private String firstname;
	private String surname;
	private String mail;
	private String password;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		sb.append(" - ");
		sb.append(getFirstname());
		sb.append(" - ");
		sb.append(getSurname());
		sb.append(" - ");
		sb.append(getMail());
		sb.append(" - ");
		sb.append(getPassword());
		return sb.toString();
	}
}
