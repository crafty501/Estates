package de.dis2016.model;


public abstract class Estate {
	private String id;
	private String city;
	private String postalCode;
	private String street;
	private String streetNr;
	private String squareArea;
	private String login;
	private int personid;
	private int contractnr;
	
	
	
	public Estate(String id, String city, String postalCode, String street, String streetNr, String squareArea, String login, int personid, int contractnr) {
		this.id = id;
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.streetNr = streetNr;
		this.squareArea = squareArea;
		this.login = login;
		this. personid = personid;
		this.contractnr = contractnr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNr() {
		return streetNr;
	}
	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}
	public String getSuareArea() {
		return squareArea;
	}
	public void setSquareArea(String squareArea) {
		this.squareArea = squareArea;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getContractnr() {
		return contractnr;
	}
	public void setContractnr(int contractnr) {
		this.contractnr = contractnr;
	}
	
	
}
